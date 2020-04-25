package pl.rekurencja.controllers;
import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import pl.rekurencja.CustomItemsRepository;
import pl.rekurencja.enums.ECustomItems;

import java.util.ArrayList;

public class EatController {
    static ArrayList<String> cooldowns = new ArrayList<>();

    public void EatAndGetEffectWithCooldown(PlayerInteractEvent event,Material material,PotionEffectType potionEffect, int duration,int amplifier,String cooldownName){
        final String cooldownId = event.getPlayer().getUniqueId().toString()+cooldownName;
        if(event.getAction() == Action.RIGHT_CLICK_AIR && event.getPlayer().getInventory().getItemInMainHand().getType() == material && !cooldowns.contains(cooldownId)) {
                event.setCancelled(true);
                event.getPlayer().addPotionEffect(new PotionEffect(potionEffect, duration, amplifier));
                event.getPlayer().getInventory().removeItem(new ItemStack(material,1));
                cooldowns.add(cooldownId);
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        event.getPlayer().playSound( event.getPlayer().getLocation(), Sound.ENTITY_PLAYER_BREATH, 1.0F, 1.0F);
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                cooldowns.remove(cooldownId);
                            }
                        }.runTaskLater(Bukkit.getPluginManager().getPlugin("Rekurencja"), 10);
                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("Rekurencja"), 20);
        }else{
            event.setCancelled(false);
        }
    }

    public void EatAndGetEffectWithCustomItem(@NotNull PlayerInteractEvent event, @NotNull ECustomItems customItem ){
        ItemStack customItemFromRepository = CustomItemsRepository.GetCustomItem(customItem);
        final String cooldownId = event.getPlayer().getUniqueId().toString()+customItem.toString();
        if(customItemFromRepository != null) {
            if (ItemEqualsToCustom(event.getPlayer().getInventory().getItemInMainHand(), customItemFromRepository) && !cooldowns.contains(cooldownId)) {
                event.setCancelled(true);
                CustomItemsRepository.SetCustomItemPotionEffect(customItem, event);
                event.getPlayer().getInventory().removeItem(customItemFromRepository);
                cooldowns.add(cooldownId);
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_PLAYER_BREATH, 1.0F, 1.0F);
                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                cooldowns.remove(cooldownId);
                            }
                        }.runTaskLater(Bukkit.getPluginManager().getPlugin("Rekurencja"), 10);
                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("Rekurencja"), 20);
            } else {
                event.setCancelled(false);
            }
        }
    }

    public static Boolean ItemEqualsToCustom(ItemStack p, ItemStack q){
        if(p.getItemMeta()!=null && q.getItemMeta() != null) {
            if (p.getItemMeta().hasLore() && q.getItemMeta().hasLore() && (p.getItemMeta().getLore().get(0).equals(q.getItemMeta().getLore().get(0)))
                    && (p.getType() == q.getType())) {
                return true;
            }
        }
        return false;
    }
}
