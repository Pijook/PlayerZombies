package pl.pijok.playerzombies;

import org.bukkit.plugin.java.JavaPlugin;
import pl.pijok.api.Debugger;

public class PlayerZombies extends JavaPlugin {

    private Debugger debugger;

    @Override
    public void onEnable() {

        API.create(this);
        debugger = API.getDebugger();

        if(!loadStuff(false)){
            debugger.log("&4&lSomething went wrong while loading plugin!");
            debugger.log("&4&lDisabling!");
            getServer().getPluginManager().disablePlugin(this);
        }

    }

    @Override
    public void onDisable() {

    }

    public boolean loadStuff(boolean reload){
        try{
            if(!reload){
                Controllers.create();
                Listeners.register(this);
                Commands.register(this);
            }

            Controllers.getZombieController().loadSettings();

        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
