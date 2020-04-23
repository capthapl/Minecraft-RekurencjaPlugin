package pl.rekurencja.controllers;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class EnchantController {
    public static ItemStack EnchantItem(ItemStack itemStack, Enchantment enchantment,int level){
        itemStack.addEnchantment(enchantment,level);
        return itemStack;
    }
}
