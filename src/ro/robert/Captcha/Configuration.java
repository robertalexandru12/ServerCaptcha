package ro.robert.Captcha;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Configuration {
    public static Configuration plugin;

    public static List<String> Lore = new ArrayList<>();

    public void createMessageConfig()
    {

        Lore.add("&c&m-----------------------------");
        Lore.add("&f");
        Lore.add("&f");
        Lore.add("&fAcesta este un mesaj informativ");
        Lore.add("&f");
        Lore.add("&f");
        Lore.add("&f");
        Lore.add("&4&l* &fTasteaza in chat codul &c&l%cod% &fpentru a");
        Lore.add("&fdebloca chatul!");
        Lore.add("&f");
        Lore.add("&c&m-----------------------------");




        MainClass.plugin.messages.set("Prefix","&7[&cAddicted2&7] &f");
        MainClass.plugin.messages.set("No-Permission","&fNu ai permisiunea de a folosi aceasta comanda!");
        MainClass.plugin.messages.set("Reset","&fI-ai resetat captcha-ul lui &c%player%");
        MainClass.plugin.messages.set("Verified","I-ai verificat captcha-ul lui %player%");
        MainClass.plugin.messages.set("Completed", "&fAi verificat captcha-ul, acum poti scrie pe chat!");
        MainClass.plugin.messages.set("Failed", "&fAi gresit captcha-ul, incearca din nou");
        MainClass.plugin.messages.set("CaptchaStart", Lore);
        MainClass.plugin.messages.set("NoPlayer","&fAcest jucator nu exista in baza de date");
        MainClass.plugin.messages.set("Display.Title","&c&lDEBLOCHEAZA CHAT-UL: &7%timp%s");
        MainClass.plugin.messages.set("Display.Subtitle","&fTasteaza codul: &a&l%cod%");
        MainClass.plugin.messages.set("Display.Title2", "&C&LFELICITARI");
        MainClass.plugin.messages.set("Display.Subtitle2", "&7Ai deblocat chat-ul!");


        MainClass.plugin.saveConfig(MainClass.plugin.messages,MainClass.plugin.messagesFile);
    }

    public void createSettings()
    {
        MainClass.plugin.settings.set("Settings.Cooldown", 20);
        MainClass.plugin.saveConfig(MainClass.plugin.settings, MainClass.plugin.settingsFile);

    }

    public static String c(String s)
    {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
