package ro.robert.Captcha.Events;

import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ro.robert.Captcha.A;
import ro.robert.Captcha.Configuration;
import ro.robert.Captcha.MainClass;
import ro.robert.Captcha.StringGen;

public class Chat implements Listener {


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        String mess = e.getMessage();

        if(value(e.getPlayer().getName())==0)
        {
            if(!A.inCaptcha.containsKey(e.getPlayer().getName()))
            {
                A.pString.put(e.getPlayer().getName(), StringGen.plugin.generateString());
                A.inCaptcha.put(e.getPlayer().getName(),true);
                A.captchaEvent(e.getPlayer());

                for(String s : MainClass.plugin.messages.getStringList("CaptchaStart"))
                {
                    e.getPlayer().sendMessage(Configuration.plugin.c(s).replace("%cod%",A.pString.get(e.getPlayer().getName())).replace("%player%",e.getPlayer().getName()));
                }
                e.setCancelled(true);

                return;

            }
            if(A.inCaptcha.containsKey(e.getPlayer().getName()))
            {
                if(mess.equals(A.pString.get(e.getPlayer().getName())))
                {
                    TitleAPI.sendTitle(e.getPlayer(),0,25,10,Configuration.c(MainClass.plugin.messages.getString("Display.Title2")),
                            Configuration.c(MainClass.plugin.messages.getString("Display.Subtitle2")));
                    MainClass.plugin.data.set(e.getPlayer().getName(),1);
                    A.inCaptcha.put(e.getPlayer().getName(), false);
                    MainClass.plugin.saveConfig(MainClass.plugin.data, MainClass.plugin.dataFile);
                    e.setCancelled(true);
                    return;
                }
                else
                {
                    //A.inCaptcha.put(e.getPlayer().getName(), false);
                    e.getPlayer().sendMessage(Configuration.c(MainClass.plugin.messages.getString("Prefix")) + Configuration.c(MainClass.plugin.messages.getString("Failed")));
                    e.setCancelled(true);
                    return ;
                }
            }
            /*else
            {
                if(mess.equals("fff")==false);
                {
                    MainClass.plugin.data.set(e.getPlayer().getName(),1);
                    A.inCaptcha.put(e.getPlayer().getName(), false);
                    e.getPlayer().sendMessage("1");


                }
                /*if(!e.getMessage().equals(A.pString.get(e.getPlayer().getName())))
                {
                    A.inCaptcha.put(e.getPlayer().getName(), false);
                    e.getPlayer().sendMessage("2");
                }
            }*/
            //e.getPlayer().sendMessage("Ai chatul blocat");
            e.setCancelled(true);
        }
    }

    public int value(String s)
    {
        return MainClass.plugin.data.getInt(s);
    }
}
