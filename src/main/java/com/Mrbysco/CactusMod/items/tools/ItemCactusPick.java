package com.Mrbysco.CactusMod.items.tools;

import com.Mrbysco.CactusMod.CactusMod;
import com.Mrbysco.CactusMod.Reference;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCactusPick extends ItemPickaxe{
    private final ToolMaterial material;
	
    public ItemCactusPick(String registryName) {
		super(CactusMod.cactusTool);
		
		this.material = CactusMod.cactusTool;
        this.maxStackSize = 1;
        this.setCreativeTab(CactusMod.cactustab);
        
		this.setUnlocalizedName(Reference.PREFIX + registryName.replaceAll("_", ""));
		this.setRegistryName(registryName);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos,
			EntityLivingBase entityLiving) {
		if(worldIn.rand.nextInt(10) < 3)
			entityLiving.attackEntityFrom(DamageSource.CACTUS, 1F);
		return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}
}