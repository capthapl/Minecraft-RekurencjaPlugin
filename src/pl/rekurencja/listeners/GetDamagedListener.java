package pl.rekurencja.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import pl.rekurencja.CustomItemsRepository;
import pl.rekurencja.controllers.EatController;
import pl.rekurencja.enums.ECustomItems;

public class GetDamagedListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onArrowHit(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Arrow)) {
            return;
        }
        Arrow arrow = (Arrow)e.getDamager();
        if(arrow.getMetadata("customBow").size()>0){

            if(arrow.getMetadata("customBow").get(0).asString().equals(ECustomItems.DiamondBow.toString())){
                e.setDamage(arrow.getVelocity().length()*15.0D);
                if(e.getDamage() > 35){
                    e.setDamage(35D);
                }

                e.getEntity().setFireTicks(60);
            }
        }

    }

    @EventHandler
    public void OnArrowShoot(EntityShootBowEvent event){
        if(EatController.ItemEqualsToCustom(event.getBow(), CustomItemsRepository.GetCustomItem(ECustomItems.DiamondBow))){
            event.getProjectile().setMetadata("customBow", new FixedMetadataValue(Bukkit.getPluginManager().getPlugin("Rekurencja"),ECustomItems.DiamondBow));
        }else{
            return;
        }
    }

}
