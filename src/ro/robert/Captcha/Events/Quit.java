package ro.robert.Captcha.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import ro.robert.Captcha.A;

public class Quit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        A.inCaptcha.remove(e.getPlayer().getName());
        A.pString.remove(e.getPlayer().getName());
        A.inCaptcha.remove(e.getPlayer().getName());
    }
}
