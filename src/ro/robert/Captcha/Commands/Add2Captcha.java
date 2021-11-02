package ro.robert.Captcha.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ro.robert.Captcha.Configuration;
import ro.robert.Captcha.MainClass;
import ro.robert.Captcha.StringGen;

public class Add2Captcha implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandSender player = sender;
        Player p = (Player)sender;

        if (cmd.getName().equalsIgnoreCase("add2captcha"))
        {
            if(args.length==0) player.sendMessage(ChatColor.RED+"Foloseste comanda /add2captcha help pentru a vedea toate comenzile");
            else {
                if (args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(ChatColor.RED + "/add2captcha reset - jucatorul va trebui sa rezolve iar captcha-ul");
                    return true;
                }
                if (args[0].equalsIgnoreCase("reset")) {
                    if (args.length == 2) {
                        if (MainClass.plugin.data.contains(args[1])) {
                            MainClass.plugin.data.set(args[1], 0);
                            MainClass.plugin.saveConfig(MainClass.plugin.data, MainClass.plugin.dataFile);
                            player.sendMessage(Configuration.plugin.c(MainClass.plugin.messages.getString("Prefix")) + Configuration.plugin.c(MainClass.plugin.messages.getString("Reset")).replace("%player%", args[1]));
                            return true;
                        }
                        if (!MainClass.plugin.data.contains(args[1])) {
                            player.sendMessage(Configuration.plugin.c(MainClass.plugin.messages.getString("NoPlayer")));
                            return true;
                        }
                    } else p.sendMessage(Configuration.plugin.c(MainClass.plugin.messages.getString("Prefix")) +
                            Configuration.plugin.c("&fFoloseste comanda in felul urmator: &c/add2captcha reset <player>"));
                    return true;
                }
                if (args[0].equalsIgnoreCase("verify"))
                {
                    if(args.length==2)
                    {
                        if (MainClass.plugin.data.contains(args[1])) {
                            MainClass.plugin.data.set(args[1], 1);
                            MainClass.plugin.saveConfig(MainClass.plugin.data, MainClass.plugin.dataFile);
                            player.sendMessage(Configuration.plugin.c(MainClass.plugin.messages.getString("Prefix")) +
                                    Configuration.plugin.c(MainClass.plugin.messages.getString("Verified")).replace("%player%", args[1]));
                            return true;
                        }
                        if (!MainClass.plugin.data.contains(args[1])) {
                            player.sendMessage(Configuration.plugin.c(MainClass.plugin.messages.getString("NoPlayer")));
                            return true;
                        }
                        else p.sendMessage(Configuration.plugin.c(MainClass.plugin.messages.getString("Prefix")) +
                                Configuration.plugin.c("&fFoloseste comanda in felul urmator: &c/add2captcha verify <player>"));
                    }
                    return true;
                }
                if(args[0].equalsIgnoreCase("generate"))
                {
                    StringGen.plugin.generateString();
                }
                else
                    player.sendMessage(ChatColor.RED+"Foloseste comanda /add2captcha help pentru a vedea toate comenzile");
;
                return true;
                }
            }
        return true;
    }
}
