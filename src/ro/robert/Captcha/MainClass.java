package ro.robert.Captcha;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ro.robert.Captcha.Commands.Add2Captcha;
import ro.robert.Captcha.Events.Chat;
import ro.robert.Captcha.Events.Join;
import ro.robert.Captcha.Events.Quit;

import java.io.File;
import java.io.IOException;

public class MainClass extends JavaPlugin {

    public File dataFile = new File(getDataFolder(), "data.yml");
    public YamlConfiguration data = YamlConfiguration.loadConfiguration(dataFile);
    public File configFile= new File(getDataFolder(), "config.yml");
    public YamlConfiguration config = YamlConfiguration.loadConfiguration(this.configFile);
    public File messagesFile = new File(getDataFolder(), "messages.yml");
    public YamlConfiguration messages = YamlConfiguration.loadConfiguration(this.messagesFile);
    public File settingsFile = new File(getDataFolder(), "settings.yml");
    public YamlConfiguration settings = YamlConfiguration.loadConfiguration(this.settingsFile);
    public static MainClass plugin;

    @Override
    public void onEnable()
    {
        plugin = this;
        Configuration.plugin = new Configuration();
        StringGen.plugin = new StringGen();
        A.plugin = new A();
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "-----------------------------------");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Addicted2Captcha a fost activat");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "-----------------------------------");
        loadEvents();
        loadCommands();
        if(!dataFile.exists())
        {
            data.set("test",0);
            saveConfig(data,dataFile);
        }
        if(!messagesFile.exists()) Configuration.plugin.createMessageConfig();
        if(!settingsFile.exists()) Configuration.plugin.createSettings();
        loadSettings();
    }
    @Override
    public void onDisable()
    {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "-----------------------------------");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Addicted2Captcha a fost activat");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "-----------------------------------");
    }
    public void saveConfig(FileConfiguration ymlConfig, File ymlFile) {
        try {
            ymlConfig.save(ymlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents((Listener)new Join(), (Plugin)this);
        pm.registerEvents((Listener) new Chat(), (Plugin)this);
        pm.registerEvents((Listener) new Quit(), (Plugin)this);
    }

    private void loadSettings()
    {
        A.plugin.maxCooldown=settings.getInt("Settings.Cooldown");
    }

    private void loadCommands()
    {
        getCommand("add2captcha").setExecutor((CommandExecutor)new Add2Captcha());
    }
}
