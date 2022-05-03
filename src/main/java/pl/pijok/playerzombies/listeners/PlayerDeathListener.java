package pl.pijok.playerzombies.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import pl.pijok.playerzombies.Controllers;
import pl.pijok.playerzombies.zombie.ZombieController;

public class PlayerDeathListener implements Listener {

    private final ZombieController zombieController;

    public PlayerDeathListener(){
        zombieController = Controllers.getZombieController();
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){

        Player player = event.getEntity();

        zombieController.spawnZombie(player, player.getLocation());

    }

}
