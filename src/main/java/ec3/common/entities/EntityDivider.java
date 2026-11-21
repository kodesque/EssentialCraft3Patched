package ec3.common.entities;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDivider extends Entity {

    public EntityDivider(World w) {
        super(w);
    }

    public EntityDivider(World w, double x, double y, double z) {
        this(w);
        this.setPositionAndRotation(x, y, z, 0, 0);
    }

    public EntityDivider(World w, double x, double y, double z, double delay, EntityLivingBase base) {
        this(w, x, y, z);
        this.delay = delay;
        this.attacker = base;
    }

    public EntityLivingBase attacker;
    double delay = 2;

    public static final float DAMAGE = 2;
    public static final double RANGE = 3;

    @Override
    protected void entityInit() {
        this.getDataWatcher()
            .addObject(12, "||null:null");
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tag) {
        delay = tag.getDouble("delay");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tag) {
        tag.setDouble("delay", delay);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onUpdate() {
        delay -= 0.05D;

        if (this.ticksExisted % 10 == 0) this.playSound("creeper.primed", 1.0F, 0.5F);

        this.worldObj.spawnParticle("reddust", posX, posY, posZ, 1, 0, 1);

        if (delay <= 0 && !this.isDead) {
            List<EntityLivingBase> allEntities = this.worldObj.getEntitiesWithinAABB(
                EntityLivingBase.class,
                AxisAlignedBB
                    .getBoundingBox(posX - 0.5D, posY - 0.5D, posZ - 0.5D, posX + 0.5D, posY + 0.5D, posZ + 0.5D)
                    .expand(3, 3, 3));
            for (int i = 0; i < allEntities.size(); ++i) {

                EntityLivingBase elb = allEntities.get(i);

                if (elb == null) continue;

                if (elb.isDead) continue;

                if (elb == this.attacker) continue;

                if (elb instanceof EntityHologram) continue;

                if (elb.getDistanceToEntity(this) > RANGE) continue;

                if (this.worldObj.isRemote) return;

                elb.attackEntityFrom(DamageSource.magic, elb.getHealth() / DAMAGE);
                elb.addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 4, true));
                elb.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 4, true));
                elb.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 200, 4, true));
                elb.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0, true));

            }
            this.setDead();

        }
    }

}
