package pl.rekurencja;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.rekurencja.controllers.EnchantController;
import pl.rekurencja.enums.EMob;
import pl.rekurencja.model.CustomMob;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class CustomMobRepository {

    public ArrayList<CustomMob> GetEntityList(LivingEntity livingEntity){
        ArrayList<CustomMob> mobList = new ArrayList<CustomMob>();
        switch (livingEntity.getType()){
            case ZOMBIE:
                mobList.add(new CustomMob(EMob.DEATH_DANCE,2.5F));
                break;
            case SKELETON:
                mobList.add(new CustomMob(EMob.PHANTOM_DANCER,2.5F));
                break;
            default: return mobList;
        }

        return mobList;
    }

    public void SetLivingEntityByChance(LivingEntity entity){
        ArrayList<CustomMob> customMobs = GetEntityList(entity);
        if(customMobs.size() > 0){
            for(int i = 0;i<customMobs.size();i++){

                if(customMobs.get(i).RollChance()){
                    EMobToCustomMob(customMobs.get(i).EMob,entity);
                    return;
                }
            }
        }
    }



    private void EMobToCustomMob(EMob mob,LivingEntity livingEntity){
        CustomMob customMob;
        livingEntity.setMetadata("custom",new FixedMetadataValue(Bukkit.getPluginManager().getPlugin("Rekurencja"),true));
        switch (mob){
            case DEATH_DANCE:
                livingEntity.getEquipment().setItemInMainHand(EnchantController.EnchantItem(new ItemStack(Material.DIAMOND_SWORD,1), Enchantment.DAMAGE_ALL,3));
                livingEntity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS,1));
                livingEntity.getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET,1));
                livingEntity.getEquipment().setChestplate(EnchantController.EnchantItem(new ItemStack(Material.DIAMOND_CHESTPLATE,1),Enchantment.PROTECTION_ENVIRONMENTAL,3));
                livingEntity.getEquipment().setChestplateDropChance(0f);
                livingEntity.getEquipment().setItemInMainHandDropChance(0f);
                livingEntity.getEquipment().setLeggings(EnchantController.EnchantItem(new ItemStack(Material.IRON_LEGGINGS,1),Enchantment.PROTECTION_ENVIRONMENTAL,3));
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,20*99999,1));
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,20*99999,0));
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,20*99999,3));
                livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40D);
                livingEntity.setHealth(40D);
                livingEntity.setCustomName("Death Dance");
                break;
            case PHANTOM_DANCER:
                livingEntity.getEquipment().setItemInMainHand(EnchantController.EnchantItem(new ItemStack(Material.BOW,1), Enchantment.ARROW_DAMAGE,2));
                livingEntity.getEquipment().setBoots(new ItemStack(Material.GOLDEN_BOOTS,1));
                livingEntity.getEquipment().setHelmet(new ItemStack(Material.GOLDEN_HELMET,1));
                livingEntity.getEquipment().setChestplate(EnchantController.EnchantItem(new ItemStack(Material.GOLDEN_CHESTPLATE,1),Enchantment.PROTECTION_ENVIRONMENTAL,1));
                livingEntity.getEquipment().setChestplateDropChance(0f);
                livingEntity.getEquipment().setItemInMainHandDropChance(0f);
                livingEntity.getEquipment().setLeggings(EnchantController.EnchantItem(new ItemStack(Material.GOLDEN_LEGGINGS,1),Enchantment.PROTECTION_ENVIRONMENTAL,1));
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,20*99999,2));
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,20*99999,0));
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,20*99999,0));
                livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40D);
                livingEntity.setHealth(20D);
                livingEntity.setCustomName("Phantom Dancer");
                break;
            default: throw new NotImplementedException();
        }
    }
}
