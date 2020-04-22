package pl.rekurencja.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import pl.rekurencja.LootRepository;
import pl.rekurencja.controllers.LootController;
import pl.rekurencja.enums.EMob;


public class KillListener implements Listener {

    @EventHandler
    public void EntityDeathEvent(EntityDeathEvent event){
        LootController controller = new LootController();
        if(event.getEntity().getCustomName() != null && event.getEntity().getCustomName().equals("Death Dance")){
            controller.DropItemIfKilledByPlayerWithPercentChanceCustomMob(event, EntityType.ZOMBIE, LootRepository.GetLootFromEMobType(EMob.DEATH_DANCE),"Death Dance");
        }else {
            controller.DropItemIfKilledByPlayerWithPercentChance(event, EntityType.ZOMBIE, LootRepository.GetLootFromEMobType(EMob.ZOMBIE));
            controller.DropItemIfKilledByPlayerWithPercentChance(event, EntityType.SKELETON, LootRepository.GetLootFromEMobType(EMob.SKELETON));
            controller.DropItemIfKilledByPlayerWithPercentChance(event, EntityType.SPIDER, LootRepository.GetLootFromEMobType(EMob.SPIDER));
            controller.DropItemIfKilledByPlayerWithPercentChance(event, EntityType.CAVE_SPIDER, LootRepository.GetLootFromEMobType(EMob.CAVE_SPIDER));
            controller.DropItemIfKilledByPlayerWithPercentChance(event, EntityType.CREEPER, LootRepository.GetLootFromEMobType(EMob.CREEPER));
            controller.DropItemIfKilledByPlayerWithPercentChance(event, EntityType.WITHER_SKELETON, LootRepository.GetLootFromEMobType(EMob.WITHER_SKELETON));
        }
    }
}
