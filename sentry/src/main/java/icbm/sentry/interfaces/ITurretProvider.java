package icbm.sentry.interfaces;

import icbm.sentry.turret.EntityMountableDummy;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;
import universalelectricity.api.vector.IVector3;

/** Implement this on any object that hosts a turret.
 * 
 * @author Darkguardsman, Calclavia */
public interface ITurretProvider
{
    /** Gets the sentry hosted by this container */
    public ITurret getTurret();

    public World world();

    public double x();

    public double y();

    public double z();

    public void sendFireEventToClient(IVector3 target);

    public EntityMountableDummy getFakeEntity();

    public IInventory getInventory();
}
