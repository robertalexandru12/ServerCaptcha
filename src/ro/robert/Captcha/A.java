package ro.robert.Captcha;

import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class A {

    public static A plugin;
    public static HashMap<String, Integer> playersCooldown = new HashMap<>();
    public static HashMap<String, Boolean> inCaptcha = new HashMap<>();
    public static HashMap<String, String> pString = new HashMap<>();

    public static int maxCooldown;


    public static void captchaEvent(final Player p) {
        playersCooldown.put(p.getName(), Integer.valueOf(30));

        Thread thread = new Thread(new Runnable()
        {
            public void run()
            {
                for (int i = maxCooldown; i >= 1; i--) {

                    if (i >= 0) A.playersCooldown.put(p.getName(), Integer.valueOf(i));

                    if ( A.inCaptcha.get(p.getName())==false) {
                        A.playersCooldown.remove(p.getName());
                        A.inCaptcha.remove(p.getName());
                        A.pString.remove(p.getName());

                        return;
                    }
                    TitleAPI.sendTitle(p,0,25,10,Configuration.c(MainClass.plugin.messages.getString("Display.Title")).replace("%timp%", String.valueOf(A.playersCooldown.get(p.getName()))),
                            Configuration.c(MainClass.plugin.messages.getString("Display.Subtitle")).replace("%cod%",pString.get(p.getName())));
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                A.playersCooldown.remove(p.getName());
                A.inCaptcha.remove(p.getName());
                A.pString.remove(p.getName());

            }
        });


        thread.start();
    }


}
