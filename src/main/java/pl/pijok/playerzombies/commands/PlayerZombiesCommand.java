package pl.pijok.playerzombies.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.pijok.api.ChatManager;
import pl.pijok.playerzombies.API;
import pl.pijok.playerzombies.Language;
import pl.pijok.playerzombies.PlayerZombies;

public class PlayerZombiesCommand implements CommandExecutor {

    private final PlayerZombies plugin;
    private final ChatManager chatManager;

    public PlayerZombiesCommand(PlayerZombies plugin){
        this.plugin = plugin;
        this.chatManager = API.getChatManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("reload")){
                if(sender instanceof Player){
                    Player player = (Player) sender;
                    if(!player.hasPermission("playerzombies.reload")){
                        chatManager.sendMessage(sender, Language.getText("PERMISSION_DENIED"));
                        return true;
                    }
                }

                plugin.loadStuff(true);
                chatManager.sendMessage(sender, "&aReloaded!");
                return true;
            }
        }

        chatManager.sendMessage(sender, "&7/" + label + " reload");
        return true;
    }

}
