package icbm.core;

import icbm.api.ICBMTab;
import icbm.explosion.ZhuYao;

import java.util.Random;

import net.minecraft.block.material.Material;

public class BLiu extends ICBMBlock
{
	public BLiu(int id)
	{
		super(id, 10, Material.rock);
		this.setBlockName("sulfurOre");
		this.setHardness(3.0f);
		this.setCreativeTab(ICBMTab.INSTANCE);
	}

	@Override
	public int getBlockTextureFromSide(int side)
	{
		return this.blockIndexInTexture;
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return ZhuYao.itLiu.itemID;
	}

	@Override
	public int quantityDropped(Random par1Random)
	{
		return 3 + par1Random.nextInt(3);
	}

	@Override
	public int quantityDroppedWithBonus(int par1, Random par2Random)
	{
		return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
	}
}