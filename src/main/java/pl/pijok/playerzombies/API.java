package pl.pijok.playerzombies;

import pl.pijok.api.ChatManager;
import pl.pijok.api.ConfigProvider;
import pl.pijok.api.Debugger;
import pl.pijok.api.PijokAPI;

import java.util.Random;

public class API {

    private static PijokAPI pijokAPI;

    public static void create(PlayerZombies plugin){
        pijokAPI = new PijokAPI(plugin);

        pijokAPI.getDebugger().setPrefix("[PlayerZombies] ");
        pijokAPI.getChatManager().setPrefix("&7[&c&lPlayerZombies&7] &r");
    }

    public static Debugger getDebugger(){
        return pijokAPI.getDebugger();
    }

    public static ChatManager getChatManager(){
        return pijokAPI.getChatManager();
    }

    public static ConfigProvider getConfigProvider(){
        return pijokAPI.getConfigProvider();
    }

    public static Double round(double a, int precision){
        int multiplier = (int) Math.pow(10, precision);
        a = a * multiplier;
        a = (int) a;
        a = a / multiplier;
        return a;
    }

    public static double randomDoubleInRange(double rangeMin, double rangeMax){
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }

}
