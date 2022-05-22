package io.github.dukespeed.mordle;

import io.github.dukespeed.mordle.commands.CommandMordle;
import io.github.dukespeed.mordle.listeners.ListenerMordle;
import org.bukkit.plugin.java.JavaPlugin;

public class Mordle  extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Mordle onEnable is called");
        // Register commands.
        this.getCommand("mordle").setExecutor(new CommandMordle());
        this.getServer().getPluginManager().registerEvents(new ListenerMordle(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Mordle onDisable is called");
    }

}
