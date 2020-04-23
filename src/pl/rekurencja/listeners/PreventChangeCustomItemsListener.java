package pl.rekurencja.listeners;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.*;
import pl.rekurencja.CustomItemsRepository;
import pl.rekurencja.controllers.EatController;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PreventChangeCustomItemsListener implements Listener {
    @EventHandler
    public void OnEnchant(InventoryClickEvent e) {
        if(e.getInventory() instanceof AnvilInventory) {
            AnvilInventory anvil = (AnvilInventory) e.getInventory();
            InventoryView view = e.getView();
            int rawSlot = e.getRawSlot();
            if(e.getSlotType() == InventoryType.SlotType.RESULT) {
            ItemStack[] anvilContent = anvil.getContents();
            ArrayList<ItemStack> blockedItems = CustomItemsRepository.GetBlockedInAnvilEnchantCustomItems();
                for (int i = 0; i < blockedItems.size(); i++) {
                    if((anvilContent[0].getType() == Material.ENCHANTED_BOOK || anvilContent[1].getType() == Material.ENCHANTED_BOOK)
                            && EatController.ItemEqualsToCustom(e.getCurrentItem(),blockedItems.get(i))){
                            e.setCancelled(true);
                    }
                }
            }
        }
        if(e.getInventory() instanceof EnchantingInventory) {
            ArrayList<ItemStack> blockedItems = CustomItemsRepository.GetBlockedInAnvilEnchantCustomItems();
            for (int i = 0; i < blockedItems.size(); i++) {
                if(EatController.ItemEqualsToCustom(e.getCurrentItem(),blockedItems.get(i))){
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void OnGrindstone(InventoryClickEvent e) {
        if(e.getInventory() instanceof GrindstoneInventory) {
            ArrayList<ItemStack> blockedItems = CustomItemsRepository.GetBlockedInAnvilEnchantCustomItems();
            for(int i = 0 ;i < blockedItems.size();i++) {
                if(EatController.ItemEqualsToCustom(e.getCurrentItem(), blockedItems.get(i))){
                    e.setCancelled(true);
                }
            }
        }
    }
}
