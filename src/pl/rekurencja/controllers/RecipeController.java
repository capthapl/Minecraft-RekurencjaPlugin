package pl.rekurencja.controllers;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.rekurencja.CustomItemsRepository;
import pl.rekurencja.enums.ECustomItems;

import java.util.ArrayList;

public class RecipeController {
    public static void InitRecipes(){
        NamespacedKey quartzKey = new NamespacedKey(Bukkit.getPluginManager().getPlugin("Rekurencja"),"quartz_recipe");
        Bukkit.addRecipe(CustomItemsRepository.GetCustomItemRecipe(ECustomItems.Quartz,quartzKey));

        NamespacedKey bandageKey = new NamespacedKey(Bukkit.getPluginManager().getPlugin("Rekurencja"),"bandage_recipe");
        Bukkit.addRecipe(CustomItemsRepository.GetCustomItemRecipe(ECustomItems.Bandage,bandageKey));

        NamespacedKey stringBandageKey = new NamespacedKey(Bukkit.getPluginManager().getPlugin("Rekurencja"),"string_bandage_recipe");
        Bukkit.addRecipe(CustomItemsRepository.GetCustomItemRecipe(ECustomItems.StrongBandage,stringBandageKey));

        NamespacedKey diamondBowKey = new NamespacedKey(Bukkit.getPluginManager().getPlugin("Rekurencja"),"diamond_bow");
        Bukkit.addRecipe(CustomItemsRepository.GetCustomItemRecipe(ECustomItems.DiamondBow,diamondBowKey));
    }

    public static ItemStack SetNameAndLore(ItemStack item,String displayName,String lore){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        ArrayList<String> newLore = new ArrayList<String>();
        newLore.add(lore);
        meta.setLore(newLore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack SetGlowAndNoEnchant(ItemStack item){
        item.addUnsafeEnchantment(Enchantment.LUCK, 0);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
}
