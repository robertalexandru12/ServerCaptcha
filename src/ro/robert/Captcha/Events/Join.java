package ro.robert.Captcha.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ro.robert.Captcha.MainClass;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        if(!e.getPlayer().hasPlayedBefore())
        {
            MainClass.plugin.data.set(e.getPlayer().getName(),0);
            MainClass.plugin.saveConfig(MainClass.plugin.data,MainClass.plugin.dataFile);
        }
        else
        {

        }
    }
}
