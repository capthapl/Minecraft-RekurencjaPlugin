package pl.rekurencja.model;

import org.bukkit.Bukkit;

import java.util.Random;

public abstract class APercentEntity {
    float PercentChance;

    public APercentEntity(float percentChance){
        this.PercentChance = percentChance;
    }

    public Boolean RollChance(){
        Random rnd = new Random();
        double i = 0 + (100 - 0) * rnd.nextDouble();
        return i <= PercentChance;
    }
}
