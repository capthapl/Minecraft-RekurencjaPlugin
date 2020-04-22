package pl.rekurencja.controllers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import pl.rekurencja.model.ChanceItemStack;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class LootController {

    public void DropItemAtEventEntityLocation(EntityDeathEvent event,ItemStack itemStack){
        LivingEntity entity = event.getEntity();
        if(entity!=null){
            entity.getWorld().dropItem(entity.getLocation(),itemStack);
        }else{
            Bukkit.getLogger().info("DropItemAtEventEntityLocation get null entity.");
        }
    }

    public void DropItemIfKilledByPlayerWithPercentChance(EntityDeathEvent event, EntityType entityType, ArrayList<ChanceItemStack> items){
        Random rnd = new Random();


        for(ChanceItemStack item: items){
            double i = 0 + (100 - 0) * rnd.nextDouble();
            Bukkit.getLogger().info("chance loot: " + Double.toString(i));

            if(i <= item.LootChance){
                DropItemIfKilledByPlayer(event,entityType,item);
            }
        }
    }

    public void DropItemIfKilledByPlayerWithPercentChanceCustomMob(EntityDeathEvent event, EntityType entityType, ArrayList<ChanceItemStack> items,String customName){
        if(event.getEntity().getCustomName().equals(customName)) {
            DropItemIfKilledByPlayerWithPercentChance(event, entityType, items);
        }
    }

    public void DropItemIfKilledByPlayer(EntityDeathEvent event, EntityType entityType, ChanceItemStack item){
        if(event.getEntity().getKiller() != null) {
            EntityType killerType = event.getEntity().getKiller().getType();
            {
                if (killerType == EntityType.PLAYER) {
                    Player killer = event.getEntity().getKiller().getPlayer();
                    ItemStack itemInHand = killer.getInventory().getItemInMainHand();
                    Map<Enchantment,Integer> enchants = itemInHand.getEnchantments();
                    if (event.getEntityType() == entityType) {
                        if(enchants.containsKey(Enchantment.LOOT_BONUS_MOBS)){
                            Bukkit.getLogger().info(enchants.get(Enchantment.LOOT_BONUS_MOBS).toString());
                            switch (enchants.get(Enchantment.LOOT_BONUS_MOBS)){
                                case 1:
                                    DropItemAtEventEntityLocation(event, item.GetItemFromFortuneLevel(1));
                                    break;
                                case 2:
                                    DropItemAtEventEntityLocation(event, item.GetItemFromFortuneLevel(2));
                                    break;
                                case 3:
                                    DropItemAtEventEntityLocation(event, item.GetItemFromFortuneLevel(3));
                                    break;
                            }
                        }else {
                                DropItemAtEventEntityLocation(event, item.GetItemFromFortuneLevel(0));

                        }
                    }
                }
            }
        }
    }
}
