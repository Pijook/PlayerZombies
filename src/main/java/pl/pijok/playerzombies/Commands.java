package pl.pijok.playerzombies;

import pl.pijok.playerzombies.commands.PlayerZombiesCommand;

public class Commands {


    public static void register(PlayerZombies plugin){
        plugin.getCommand("playerzombies").setExecutor(new PlayerZombiesCommand(plugin));
    }

}
