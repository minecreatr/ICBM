package icbm.sentry.turret.weapon;

import icbm.sentry.interfaces.ITurret;
import universalelectricity.api.vector.IVector3;
import universalelectricity.api.vector.Vector3;
import calclavia.lib.prefab.damage.ObjectDamageSource;

/** Basic projectile weapon system design more to be used as a prefab. By default it acts like a hand
 * gun with low hit chance and damage.
 * 
 * @author DarkGuardsman, tgame14, Calclavia */
public class WeaponInaccuracy extends WeaponDamage
{
    protected float inaccuracy = 0.00005f;
    protected float min_range = 1;
    protected float max_range = 100;

    public WeaponInaccuracy(ITurret sentry, int ammoAmount, float damage)
    {
        super(sentry, ObjectDamageSource.doBulletDamage(sentry), damage);
        this.itemsConsumedPerShot = ammoAmount;
    }

    @Override
    public void fire(IVector3 t)
    {
        Vector3 target = new Vector3(t);
        double d = target.distance(turret());
        super.fire(target.translate(getInaccuracy(d), getInaccuracy(d), getInaccuracy(d)));
        consumeAmmo(itemsConsumedPerShot, true);
    }

    protected double getInaccuracy(double distance)
    {
        double offset = distance * (world().rand.nextFloat() - world().rand.nextFloat()) * inaccuracy;
        if (distance < min_range || distance > max_range)
        {
            return offset * 2;
        }
        return offset;
    }
}
