package pl.pijok.playerzombies;

import org.bukkit.plugin.PluginManager;
import pl.pijok.playerzombies.listeners.EntityDamageByEntityListener;
import pl.pijok.playerzombies.listeners.PlayerDeathListener;

public class Listeners {

    public static void register(PlayerZombies plugin){
        PluginManager pluginManager = plugin.getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerDeathListener(), plugin);
        pluginManager.registerEvents(new EntityDamageByEntityListener(), plugin);
    }

}
