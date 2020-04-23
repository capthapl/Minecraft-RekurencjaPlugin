package pl.rekurencja.model;

import com.sun.istack.internal.NotNull;
import org.bukkit.entity.LivingEntity;

public class CustomMob extends  APercentEntity {
    @NotNull
    public LivingEntity Entity;

    public CustomMob(LivingEntity entity,float percentSpawnChance){
        super(percentSpawnChance);
        this.Entity = entity;
    }
}
