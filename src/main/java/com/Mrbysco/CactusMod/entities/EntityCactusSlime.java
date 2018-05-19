package com.Mrbysco.CactusMod.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityCactusSlime extends EntitySlime implements ICactusMob{

	private static final DataParameter<Integer> SLIME_SIZE = EntityDataManager.<Integer>createKey(EntityCactusSlime.class, DataSerializers.VARINT);
	private int lifetime;
	private boolean wasOnGround;
	
	public EntityCactusSlime(World worldIn) {
		super(worldIn);
		this.moveHelper = new EntityCactusSlime.SlimeMoveHelper(this);
	}
	
	@Override
	protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(SLIME_SIZE, Integer.valueOf(1));
    }

	@Override
    protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityCactusSlime.AISlimeFloat(this));
        this.tasks.addTask(2, new EntityCactusSlime.AISlimeAttack(this));
        this.tasks.addTask(3, new EntityCactusSlime.AISlimeFaceRandom(this));
        this.tasks.addTask(5, new EntityCactusSlime.AISlimeHop(this));
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
        this.targetTasks.addTask(3, new EntityAIFindEntityNearest(this, EntityIronGolem.class));
    }
    
	@Override
	public void notifyDataManagerChange(DataParameter<?> key)
    {
        if (SLIME_SIZE.equals(key))
        {
            int i = this.getSlimeSize();
            this.setSize(0.51000005F * (float)i, 0.51000005F * (float)i);
            this.rotationYaw = this.rotationYawHead;
            this.renderYawOffset = this.rotationYawHead;

            if (this.isInWater() && this.rand.nextInt(20) == 0)
            {
                this.doWaterSplashEffect();
            }
        }

        super.notifyDataManagerChange(key);
    }
	
	@Override
    protected void setSlimeSize(int size, boolean resetHealth)
    {
        this.dataManager.set(SLIME_SIZE, Integer.valueOf(size));
        this.setSize(0.51000005F * (float)size, 0.51000005F * (float)size);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)(size * size));
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)(0.2F + 0.1F * (float)size));

        if (resetHealth)
        {
            this.setHealth(this.getMaxHealth());
        }

        this.experienceValue = size;
    }

    /**
     * Returns the size of the slime.
     */
	@Override
    public int getSlimeSize()
    {
        return ((Integer)this.dataManager.get(SLIME_SIZE)).intValue();
    }
	
	@Override
	@Nullable
    protected ResourceLocation getLootTable()
    {
		return new ResourceLocation("cactusmod:entities/cactus_slime");
    }
	
	@Override
	protected void dealDamage(EntityLivingBase entityIn)
    {
        int i = this.getSlimeSize();

        if (this.canEntityBeSeen(entityIn) && this.getDistanceSq(entityIn) < 0.6D * (double)i * 0.6D * (double)i && entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.getAttackStrength()))
        {
            this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            entityIn.attackEntityFrom(DamageSource.CACTUS, 1F);
        }
    }
	
	public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        int i = compound.getInteger("Size");

        if (i < 0)
        {
            i = 0;
        }

        this.setSlimeSize(i + 1, false);
        this.wasOnGround = compound.getBoolean("wasOnGround");
        compound.setInteger("Lifetime", this.lifetime);
    }
	
	public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        compound.setInteger("Size", this.getSlimeSize() - 1);
        compound.setBoolean("wasOnGround", this.wasOnGround);
        this.lifetime = compound.getInteger("Lifetime");
    }
	
	@Override
	public void onUpdate()
    {
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL && this.getSlimeSize() > 0)
        {
            this.isDead = true;
        }

        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor + 1;
        super.onUpdate();

        if (this.onGround && !this.wasOnGround)
        {
            int i = this.getSlimeSize();
            if (spawnCustomParticles()) { i = 0; } // don't spawn particles if it's handled by the implementation itself
            for (int j = 0; j < i * 8; ++j)
            {
                float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
                World world = this.world;
                EnumParticleTypes enumparticletypes = this.getParticleType();
                double d0 = this.posX + (double)f2;
                double d1 = this.posZ + (double)f3;
                world.spawnParticle(enumparticletypes, d0, this.getEntityBoundingBox().minY, d1, 0.0D, 0.0D, 0.0D);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.squishAmount = -0.5F;
        }
        else if (!this.onGround && this.wasOnGround)
        {
            this.squishAmount = 1.0F;
        }

        this.wasOnGround = this.onGround;
        this.alterSquishAmount();
    }
	
	@Override
	public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (!this.world.isRemote)
        {
            if (!this.isNoDespawnRequired())
            {
                ++this.lifetime;
            }

            if (this.lifetime >= 2400)
            {
                this.setDead();
            }
        }
    }
	
	@Override
	protected EntityCactusSlime createInstance()
    {
        return new EntityCactusSlime(this.world);
    }
	
	@Override
	public void setDead()
    {
        int i = this.getSlimeSize();

        if (!this.world.isRemote && i > 1 && this.getHealth() <= 0.0F)
        {
            int j = 2 + this.rand.nextInt(3);

            for (int k = 0; k < j; ++k)
            {
                float f = ((float)(k % 2) - 0.5F) * (float)i / 4.0F;
                float f1 = ((float)(k / 2) - 0.5F) * (float)i / 4.0F;
                EntityCactusSlime entityslime = this.createInstance();

                if (this.hasCustomName())
                {
                    entityslime.setCustomNameTag(this.getCustomNameTag());
                }

                if (this.isNoDespawnRequired())
                {
                    entityslime.enablePersistence();
                }

                entityslime.setSlimeSize(i / 2, true);
                entityslime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
                this.world.spawnEntity(entityslime);
            }
        }

        super.setDead();
    }
	
    static class AISlimeAttack extends EntityAIBase
    {
        private final EntityCactusSlime slime;
        private int growTieredTimer;

        public AISlimeAttack(EntityCactusSlime slimeIn)
        {
            this.slime = slimeIn;
            this.setMutexBits(2);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            EntityLivingBase entitylivingbase = this.slime.getAttackTarget();

            if (entitylivingbase == null)
            {
                return false;
            }
            else if (!entitylivingbase.isEntityAlive())
            {
                return false;
            }
            else
            {
                return !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer)entitylivingbase).capabilities.disableDamage;
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.growTieredTimer = 300;
            super.startExecuting();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            EntityLivingBase entitylivingbase = this.slime.getAttackTarget();

            if (entitylivingbase == null)
            {
                return false;
            }
            else if (!entitylivingbase.isEntityAlive())
            {
                return false;
            }
            else if (entitylivingbase instanceof EntityPlayer && ((EntityPlayer)entitylivingbase).capabilities.disableDamage)
            {
                return false;
            }
            else
            {
                return --this.growTieredTimer > 0;
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            this.slime.faceEntity(this.slime.getAttackTarget(), 10.0F, 10.0F);
            ((EntityCactusSlime.SlimeMoveHelper)this.slime.getMoveHelper()).setDirection(this.slime.rotationYaw, this.slime.canDamagePlayer());
        }
    }

    static class AISlimeFaceRandom extends EntityAIBase
    {
        private final EntityCactusSlime slime;
        private float chosenDegrees;
        private int nextRandomizeTime;

        public AISlimeFaceRandom(EntityCactusSlime slimeIn)
        {
            this.slime = slimeIn;
            this.setMutexBits(2);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return this.slime.getAttackTarget() == null && (this.slime.onGround || this.slime.isInWater() || this.slime.isInLava() || this.slime.isPotionActive(MobEffects.LEVITATION));
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (--this.nextRandomizeTime <= 0)
            {
                this.nextRandomizeTime = 40 + this.slime.getRNG().nextInt(60);
                this.chosenDegrees = (float)this.slime.getRNG().nextInt(360);
            }

            ((EntityCactusSlime.SlimeMoveHelper)this.slime.getMoveHelper()).setDirection(this.chosenDegrees, false);
        }
    }

	static class AISlimeFloat extends EntityAIBase
    {
        private final EntityCactusSlime slime;

        public AISlimeFloat(EntityCactusSlime slimeIn)
        {
            this.slime = slimeIn;
            this.setMutexBits(5);
            ((PathNavigateGround)slimeIn.getNavigator()).setCanSwim(true);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return this.slime.isInWater() || this.slime.isInLava();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            if (this.slime.getRNG().nextFloat() < 0.8F)
            {
                this.slime.getJumpHelper().setJumping();
            }

            ((EntityCactusSlime.SlimeMoveHelper)this.slime.getMoveHelper()).setSpeed(1.2D);
        }
    }

	static class AISlimeHop extends EntityAIBase
    {
        private final EntityCactusSlime slime;

        public AISlimeHop(EntityCactusSlime slimeIn)
        {
            this.slime = slimeIn;
            this.setMutexBits(5);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            ((EntityCactusSlime.SlimeMoveHelper)this.slime.getMoveHelper()).setSpeed(1.0D);
        }
    }

	static class SlimeMoveHelper extends EntityMoveHelper
    {
        private float yRot;
        private int jumpDelay;
        private final EntityCactusSlime slime;
        private boolean isAggressive;

        public SlimeMoveHelper(EntityCactusSlime slimeIn)
        {
            super(slimeIn);
            this.slime = slimeIn;
            this.yRot = 180.0F * slimeIn.rotationYaw / (float)Math.PI;
        }

        public void setDirection(float p_179920_1_, boolean p_179920_2_)
        {
            this.yRot = p_179920_1_;
            this.isAggressive = p_179920_2_;
        }

        public void setSpeed(double speedIn)
        {
            this.speed = speedIn;
            this.action = EntityMoveHelper.Action.MOVE_TO;
        }

        public void onUpdateMoveHelper()
        {
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, this.yRot, 90.0F);
            this.entity.rotationYawHead = this.entity.rotationYaw;
            this.entity.renderYawOffset = this.entity.rotationYaw;

            if (this.action != EntityMoveHelper.Action.MOVE_TO)
            {
                this.entity.setMoveForward(0.0F);
            }
            else
            {
                this.action = EntityMoveHelper.Action.WAIT;

                if (this.entity.onGround)
                {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                    if (this.jumpDelay-- <= 0)
                    {
                        this.jumpDelay = this.slime.getJumpDelay();

                        if (this.isAggressive)
                        {
                            this.jumpDelay /= 3;
                        }

                        this.slime.getJumpHelper().setJumping();

                        if (this.slime.makesSoundOnJump())
                        {
                            this.slime.playSound(this.slime.getJumpSound(), this.slime.getSoundVolume(), ((this.slime.getRNG().nextFloat() - this.slime.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                        }
                    }
                    else
                    {
                        this.slime.moveStrafing = 0.0F;
                        this.slime.moveForward = 0.0F;
                        this.entity.setAIMoveSpeed(0.0F);
                    }
                }
                else
                {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
                }
            }
        }
    }
}