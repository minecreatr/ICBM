package icbm;


import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import universalelectricity.Vector3;

public class BYinXing extends BlockContainer
{
    public BYinXing(int par1, int par2)
    {
        super(par1, Material.wood);
        this.setHardness(0.8F);
        this.setBlockName("Invisible Block");
    }
    
    public static void makeInvisibleBlock(World worldObj, Vector3 position, Vector3 mainBlock)
    {
		worldObj.setBlockWithNotify(position.intX(), position.intY(), position.intZ(), ICBM.blockYin3Xing2.blockID);
		((TYinXing)worldObj.getBlockTileEntity(position.intX(), position.intY(), position.intZ())).setMainBlock(mainBlock);
    }

    @Override
    public void breakBlock(World par1World, int x, int y, int z, int par5, int par6)
    {
    	TYinXing tileEntity = (TYinXing)par1World.getBlockTileEntity(x, y, z);
    	tileEntity.onBlockRemoval();
    	super.breakBlock(par1World, x, y, z, par5, par6);
    }
    
    /**
     * Called when the block is right clicked by the player. This modified version detects
     * electric items and wrench actions on your machine block. Do not override this function.
     * Use machineActivated instead! (It does the same thing)
     */
    @Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	TYinXing tileEntity = (TYinXing)par1World.getBlockTileEntity(x, y, z);
    	return tileEntity.onBlockActivated(par1World, x, y, z, par5EntityPlayer);
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
    
    @Override
	public int getRenderType()
    {
        return -1;
    }

    @Override
	public boolean isOpaqueCube()
    {
        return false;
    }
   
    @Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World var1)
	{
    	return new TYinXing();
	}
	
	@Override
    public ItemStack getPickBlock(MovingObjectPosition target, World par1World, int x, int y, int z)
    {
		TileEntity tileEntity = par1World.getBlockTileEntity(x, y, z);
		Vector3 mainBlockPosition = ((TYinXing)tileEntity).mainBlockPosition;
		
		if(mainBlockPosition != null)
		{
			int mainBlockID = par1World.getBlockId(mainBlockPosition.intX(), mainBlockPosition.intY(), mainBlockPosition.intZ());
			
			if(mainBlockID > 0)
			{
				return Block.blocksList[mainBlockID].getPickBlock(target, par1World, mainBlockPosition.intX(), mainBlockPosition.intY(), mainBlockPosition.intZ());
			}
		}
		
		return null;
    }
}