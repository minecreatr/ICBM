package icbm.explosion.missile.types;

import icbm.Reference;
import icbm.explosion.entities.EntityMissile;
import icbm.explosion.explosive.Explosive;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class Missile extends Explosive
{
    @SideOnly(Side.CLIENT)
    private ResourceLocation resourceLocation;

    public Missile(String mingZi, int tier)
    {
        super(mingZi, tier);
    }

    /** Called when launched. */
    public void launch(EntityMissile missileObj)
    {
    }

    /** Called every tick while flying. */
    public void update(EntityMissile missileObj)
    {
    }

    public boolean onInteract(EntityMissile missileObj, EntityPlayer entityPlayer)
    {
        return false;
    }

    /** Is this missile compatible with the cruise launcher?
     * 
     * @return */
    public boolean isCruise()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public ResourceLocation getMissileResource()
    {
        if (this.resourceLocation == null)
        {
            this.resourceLocation = new ResourceLocation(Reference.DOMAIN, Reference.MODEL_TEXTURE_PATH + "missile_" + this.getUnlocalizedName() + ".png");
        }

        return this.resourceLocation;
    }
}
