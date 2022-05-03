package pl.pijok.playerzombies;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;

public class Language {

    private static HashMap<String, String> texts = new HashMap<>();

    public static void load(){
        texts.clear();

        YamlConfiguration configuration = API.getConfigProvider().load("lang.yml");

        for(String key : configuration.getConfigurationSection("lang").getKeys(false)){
            texts.put(key, configuration.getString("lang." + key));
        }

        API.getChatManager().setPrefix(getText("PREFIX"));
    }

    public static String getText(String a){
        return texts.getOrDefault(a, "NULL");
    }

}
