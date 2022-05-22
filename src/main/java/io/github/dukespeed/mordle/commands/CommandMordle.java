package io.github.dukespeed.mordle.commands;

import io.github.dukespeed.mordle.listeners.ListenerMordle;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/*
 * This class should execute and start a game of wordle in minecraft?
 */
public class CommandMordle implements CommandExecutor {
    private boolean gameStarted = false;
    private boolean gameOver = true;
    private int guesses = 0;
    private String answer = "";
    // Called when someone uses the command
    /*
    CommandSender represents whatever is sending the command. This could be a Player, ConsoleCommandSender, or BlockCommandSender (a command block)
    Command represents what the command being called is. This will almost always be known ahead of time.
    Label represents the exact first word of the command (excluding arguments) that was entered by the sender
    Args is the remainder of the command statement (excluding the label) split up by spaces and put into an array.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Start/toggle the game of wordle?
        ListenerMordle.startGame();
        Bukkit.broadcastMessage("Shitty Wordle started??\n You have five guesses.");


        return true;
    }


}
