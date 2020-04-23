package pl.rekurencja.model;

import com.sun.istack.internal.NotNull;
import org.bukkit.entity.LivingEntity;
import pl.rekurencja.enums.EMob;

public class CustomMob extends  APercentEntity {
    @NotNull
    public EMob EMob;

    public CustomMob(EMob eMob, float percentSpawnChance){
        super(percentSpawnChance);
        this.EMob = eMob;
    }
}
