package fr.inconito001.multitools;

import fr.inconito001.multitools.listener.WorldListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Multitools extends JavaPlugin {
    public static Multitools plugin;

    @Override
    public void onEnable() {
        plugin = this;

        this.registerListener();
    }

    @Override
    public void onDisable() {

    }

    private void registerListener() {
        PluginManager manager = this.getServer().getPluginManager();

        manager.registerEvents(new WorldListener(this), this);
    }

    public static Multitools getPlugin() {
        return plugin;
    }
}
