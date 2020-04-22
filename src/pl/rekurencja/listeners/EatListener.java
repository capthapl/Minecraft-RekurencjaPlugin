package pl.rekurencja.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;
import pl.rekurencja.controllers.EatController;
import pl.rekurencja.enums.ECustomItems;

public class EatListener implements Listener {

    @EventHandler
    public void OnRightClick(PlayerInteractEvent event){
        EatController controller = new EatController();
        switch (event.getPlayer().getInventory().getItemInMainHand().getType()){
            case CORNFLOWER:
                controller.EatAndGetEffectWithCooldown(event,Material.CORNFLOWER,PotionEffectType.NIGHT_VISION,20*60,1,"CORNFLOWER");
            break;
            case AZURE_BLUET:
                controller.EatAndGetEffectWithCooldown(event,Material.AZURE_BLUET,PotionEffectType.SPEED,20*20,1,"AZURE_BLUET");
            break;
            case PAPER:
                controller.EatAndGetEffectWithCustomItem(event, ECustomItems.Bandage);
                controller.EatAndGetEffectWithCustomItem(event, ECustomItems.StrongBandage);
                break;
            default:
                break;
        }

    }
}
