package pl.rekurencja.model;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ChanceItemStack {
    public ItemStack Item;
    public int LootChance;
    public int NoFortuneAmount;
    public int FortuneIAmount;
    public int FortuneIIAmount;
    public int FortuneIIIAmount;

    public ChanceItemStack(ItemStack item,int lootChance, int noFortuneAmount,int fortuneIAmount,int fortuneIIAmount,int fortuneIIIAmount){
        this.Item = item;
        LootChance = lootChance;
        NoFortuneAmount = noFortuneAmount;
        FortuneIAmount = fortuneIAmount;
        FortuneIIAmount = fortuneIIAmount;
        FortuneIIIAmount = fortuneIIIAmount;
    }

    public ItemStack GetItemFromFortuneLevel(int enchantLevel){
        ItemStack tempItem = Item;
        switch (enchantLevel){
            case 0:
                Item.setAmount(NoFortuneAmount);
                break;
            case 1:
                Item.setAmount(FortuneIAmount);
                break;
            case 2:
                Item.setAmount(FortuneIIAmount);
                break;
            case 3:
                Item.setAmount(FortuneIIIAmount);
                break;

            default: throw new NotImplementedException();
        }
        return Item;
    }
}
