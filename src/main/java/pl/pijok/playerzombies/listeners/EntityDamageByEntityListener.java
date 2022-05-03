package pl.pijok.playerzombies.listeners;

import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pl.pijok.playerzombies.Controllers;
import pl.pijok.playerzombies.zombie.ZombieController;

public class EntityDamageByEntityListener implements Listener {

    private final ZombieController zombieController;

    public EntityDamageByEntityListener(){
        zombieController = Controllers.getZombieController();
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event){

        if(!(event.getEntity() instanceof Player)){
            return;
        }

        if(!(event.getDamager() instanceof Zombie)){
            return;
        }

        zombieController.handleZombieHit(((Player) event.getEntity()).getPlayer());

    }

}
