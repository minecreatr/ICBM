package icbm.explosion.missile.ex;

import icbm.ModelICBM;
import icbm.Settings;
import icbm.explosion.explosive.Explosive;
import icbm.explosion.explosive.blast.BlastSonic;
import icbm.explosion.missile.types.Missile;
import icbm.explosion.model.missiles.MMChaoShengBuo;
import icbm.explosion.model.missiles.MMShengBuo;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import calclavia.lib.recipe.RecipeUtility;
import calclavia.lib.recipe.UniversalRecipe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ExSonic extends Missile
{
	public ExSonic(String mingZi, int tier)
	{
		super(mingZi, tier);
	}

	@Override
	public void init()
	{
		if (this.getTier() == 3)
		{
			RecipeUtility.addRecipe(new ShapedOreRecipe(this.getItemStack(), new Object[] { " S ", "S S", " S ", 'S', Explosive.sonic.getItemStack() }), this.getUnlocalizedName(), Settings.CONFIGURATION, true);
		}
		else
		{
			RecipeUtility.addRecipe(new ShapedOreRecipe(this.getItemStack(), new Object[] { "@?@", "?R?", "@?@", 'R', Explosive.replsive.getItemStack(), '?', Block.music, '@', UniversalRecipe.SECONDARY_METAL.get() }), this.getUnlocalizedName(), Settings.CONFIGURATION, true);
		}
	}

	@Override
	public void doCreateExplosion(World world, double x, double y, double z, Entity entity)
	{
		if (this.getTier() == 3)
		{
			new BlastSonic(world, entity, x, y, z, 20, 35).setShockWave().explode();
		}
		else
		{
			new BlastSonic(world, entity, x, y, z, 15, 30).explode();
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelICBM getMissileModel()
	{
		if (this.getTier() == 3)
		{
			return new MMChaoShengBuo();
		}
		else
		{
			return new MMShengBuo();
		}
	}

}
