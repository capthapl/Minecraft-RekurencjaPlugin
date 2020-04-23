package pl.rekurencja;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.rekurencja.controllers.RecipeController;
import pl.rekurencja.enums.ECustomItems;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class CustomItemsRepository {
    public static ItemStack GetCustomItem(ECustomItems customItem){
        switch (customItem){
            case Bandage:
                return RecipeController.SetNameAndLore(new ItemStack(Material.PAPER,1),"Bandaz","Uzupelnia czesc zdrowia");
            case StrongBandage:
                return RecipeController.SetGlowAndNoEnchant(RecipeController.SetNameAndLore(new ItemStack(Material.PAPER,1),"Magiczny bandaz","Uzupelnia duza czesc zdrowia"));
            case Quartz:
                return new ItemStack(Material.QUARTZ,4);
            case DiamondBow:
                ItemStack diamondBow = RecipeController.SetNameAndLore(new ItemStack(Material.BOW,1),"Diamentowy łuk","Drogi, ale potezny");
                diamondBow.getItemMeta().setCustomModelData(10);
                diamondBow = RecipeController.SetGlowAndNoEnchant(diamondBow);
                diamondBow.addEnchantment(Enchantment.DURABILITY,3);
                diamondBow.addEnchantment(Enchantment.MENDING,1);
                return diamondBow;
            default: throw new NotImplementedException();
        }
    }

    public static ArrayList<ItemStack> GetBlockedInAnvilEnchantCustomItems(){
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        items.add(GetCustomItem(ECustomItems.DiamondBow));
        items.add(GetCustomItem(ECustomItems.Bandage));
        items.add(GetCustomItem(ECustomItems.StrongBandage));
        return items;
    }

    public static void SetCustomItemPotionEffect(ECustomItems customItem, PlayerInteractEvent playerInteractEvent){
        switch (customItem){
            case Bandage:
                playerInteractEvent.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*35, 0));
                break;
            case StrongBandage:
                playerInteractEvent.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*50, 1));
                break;
            default: throw new NotImplementedException();
        }
    }

    public static ShapedRecipe GetCustomItemRecipe(ECustomItems customItem, NamespacedKey nsKey){
        switch (customItem){
            case Bandage:
                ItemStack bandage = CustomItemsRepository.GetCustomItem(ECustomItems.Bandage);
                ShapedRecipe recipe = new ShapedRecipe(nsKey,bandage);
                recipe.shape(" A "," B "," C ");
                recipe.setIngredient('A',Material.REDSTONE);
                recipe.setIngredient('B',Material.POPPY);
                recipe.setIngredient('C',Material.PAPER);
                return recipe;
            case StrongBandage:
                ItemStack strongBandage = CustomItemsRepository.GetCustomItem(ECustomItems.StrongBandage);
                ShapedRecipe strongBandageRecipe = new ShapedRecipe(nsKey,strongBandage);
                strongBandageRecipe.shape(" A "," B "," C ");
                strongBandageRecipe.setIngredient('A',Material.DIAMOND);
                strongBandageRecipe.setIngredient('B',Material.POPPY);
                strongBandageRecipe.setIngredient('C',Material.PAPER);
                return strongBandageRecipe;
            case Quartz:
                ItemStack quartzBlock = CustomItemsRepository.GetCustomItem(ECustomItems.Quartz);
                ShapedRecipe quartzBlockrecipe = new ShapedRecipe(nsKey,quartzBlock);
                quartzBlockrecipe.shape("A");
                quartzBlockrecipe.setIngredient('A',Material.QUARTZ_BLOCK);
                return quartzBlockrecipe;
            case DiamondBow:
                ItemStack diamondBow = CustomItemsRepository.GetCustomItem(ECustomItems.DiamondBow);
                ShapedRecipe diamondBowRecipe = new ShapedRecipe(nsKey,diamondBow);
                diamondBowRecipe.shape("BBB","BAB", "BBB");
                diamondBowRecipe.setIngredient('A',Material.BOW);
                diamondBowRecipe.setIngredient('B',Material.DIAMOND_BLOCK);
                return diamondBowRecipe;
            default: throw new NotImplementedException();
        }
    }
}
