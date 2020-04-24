package pl.rekurencja;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import pl.rekurencja.controllers.EnchantController;
import pl.rekurencja.enums.ECustomItems;
import pl.rekurencja.enums.EMob;
import pl.rekurencja.model.ChanceItemStack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class LootRepository {
    public static ArrayList<ChanceItemStack> GetLootFromEMobType(EMob mob){
        ArrayList<ChanceItemStack> drop = new ArrayList<ChanceItemStack>();

        switch (mob){
            case ZOMBIE:
                drop.add(new ChanceItemStack(new ItemStack(Material.LEATHER,1),25,1,2,3,4));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.StrongBandage),1,1,1,2,2));
                drop.add(new ChanceItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE,1),20,4,5,6,7));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.Bandage),10,1,1,2,2));
                return drop;
            case SKELETON:
                drop.add(new ChanceItemStack(new ItemStack(Material.ARROW,1),35,2,3,4,5));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.StrongBandage),1,1,1,2,2));
                drop.add(new ChanceItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE,1),20,4,5,6,7));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.Bandage),10,1,1,2,2));
                return drop;
            case CREEPER:
                drop.add(new ChanceItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE,1),25,4,5,6,7));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.StrongBandage),1,1,1,2,2));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.Bandage),10,1,1,2,2));
                return drop;
            case SPIDER:
                drop.add(new ChanceItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE,1),20,4,5,6,7));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.StrongBandage),1,1,1,2,2));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.Bandage),10,1,1,2,2));
                return drop;
            case CAVE_SPIDER:
                drop.add(new ChanceItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE,1),25,4,5,6,7));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.StrongBandage),1,1,1,2,2));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.Bandage),15,1,1,2,2));
                return drop;
            case WITHER_SKELETON:
                drop.add(new ChanceItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE,1),30,4,5,6,7));
                drop.add(new ChanceItemStack(new ItemStack(Material.WITHER_SKELETON_SKULL,1),5,1,2,3,4));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.StrongBandage),1,1,1,2,2));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.Bandage),10,1,1,2,2));
                return drop;
            case DEATH_DANCE:
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.Bandage),50,3,4,5,6));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.StrongBandage),10,2,3,4,5));
                drop.add(new ChanceItemStack(new ItemStack(Material.LEATHER,1),40,6,8,10,12));
                drop.add(new ChanceItemStack(new ItemStack(Material.AZURE_BLUET,1),40,6,8,10,12));
                drop.add(new ChanceItemStack(new ItemStack(Material.BOOK,1),45,6,8,10,12));
                drop.add(new ChanceItemStack(new ItemStack(Material.GOLD_INGOT,1),30,2,5,7,12));
                drop.add(new ChanceItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE,1),60,35,40,45,55));
                drop.add(new ChanceItemStack(new ItemStack(Material.ARROW,1),50,10,15,25,35));
                drop.add(new ChanceItemStack(new ItemStack(Material.GOLDEN_APPLE,1),25,2,3,4,5));
                return drop;
            case PHANTOM_DANCER:
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.Bandage),50,3,4,5,6));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.StrongBandage),10,2,3,4,5));
                drop.add(new ChanceItemStack(new ItemStack(Material.AZURE_BLUET,1),50,6,8,10,12));
                drop.add(new ChanceItemStack(new ItemStack(Material.BOOK,1),45,6,8,10,12));
                drop.add(new ChanceItemStack(new ItemStack(Material.GOLD_INGOT,1),30,2,5,7,12));
                drop.add(new ChanceItemStack(new ItemStack(Material.EXPERIENCE_BOTTLE,1),60,35,40,45,55));
                drop.add(new ChanceItemStack(new ItemStack(Material.ARROW,1),50,30,45,55,65));
                ItemStack bow = new ItemStack(Material.BOW,1);
                EnchantController.EnchantItem(bow, Enchantment.ARROW_DAMAGE,4);
                EnchantController.EnchantItem(bow, Enchantment.ARROW_INFINITE,0);
                EnchantController.EnchantItem(bow, Enchantment.ARROW_FIRE,0);

                drop.add(new ChanceItemStack(bow,2,1,1,1,1));
                drop.add(new ChanceItemStack(CustomItemsRepository.GetCustomItem(ECustomItems.DeerBow),5,1,1,1,1));

                return drop;
            default: throw new NotImplementedException();
        }
    }
}
