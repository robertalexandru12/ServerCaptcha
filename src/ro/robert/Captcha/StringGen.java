package ro.robert.Captcha;

import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Random;

public class StringGen {

    public static StringGen plugin;

    public String generateString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
        //p.sendMessage(generatedString);
        //TitleAPI.sendTitle(p,10,1000,10,Configuration.c("&c&lDEBLOCHEAZA CHAT"),
               // Configuration.plugin.c("&fTasteaza acest cod: &b&l") + generatedString);

    }
}
