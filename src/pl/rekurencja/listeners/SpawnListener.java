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

import java.util.Random;

public class SpawnListener implements Listener {
    @EventHandler
    public void OnZombieSpawned(CreatureSpawnEvent event){
        if(event.getEntity().getType() == EntityType.ZOMBIE){
            Random rnd = new Random();
            double i = 0 + (100 - 0) * rnd.nextDouble();
            Bukkit.getLogger().info("chance spawn: " + Double.toString(i));
            if(i <= 2.5D){
                LivingEntity ent = event.getEntity();
                ent.setMetadata("custom",new FixedMetadataValue(Bukkit.getPluginManager().getPlugin("Rekurencja"),true));
                ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                sword.addEnchantment(Enchantment.DAMAGE_ALL,4);
                ent.getEquipment().setItemInMainHand(sword);
                ent.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS,1));
                ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
                chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3);
                ent.getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET,1));
                ent.getEquipment().setChestplate(chestplate);
                ent.getEquipment().setChestplateDropChance(0f);
                ent.getEquipment().setItemInMainHandDropChance(0f);
                ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS, 1);
                leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,3);
                ent.getEquipment().setLeggings(leggings);
                ent.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,20*99999,1));
                ent.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,20*99999,0));
                ent.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,20*99999,3));
                ent.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40D);
                ent.setHealth(40D);
                ent.setCustomName("Death Dance");
            }
        }
    }
}
