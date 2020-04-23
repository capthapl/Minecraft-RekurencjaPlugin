package pl.rekurencja.listeners;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.rekurencja.CustomMobRepository;
import pl.rekurencja.model.CustomMob;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class SpawnListener implements Listener {
    @EventHandler
    public void OnMobSpawned(CreatureSpawnEvent event){
            CustomMobRepository cmr = new CustomMobRepository();
            cmr.SetLivingEntityByChance(event.getEntity());
    }
}
