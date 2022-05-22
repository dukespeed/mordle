package io.github.dukespeed.mordle.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public  class ListenerMordle implements Listener {

    private static boolean gameStarted = false;
    private static boolean gameOver = true;
    private static int guesses = 0;
    private static String answer = "";

    public static void startGame() {
        gameOver = false;
        gameStarted = true;
        answer = "Slope";

    }

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {

        if (gameStarted && (!gameOver)) {
            String message = event.getMessage();
            // if got right answer end game
            if (message.equalsIgnoreCase(answer)) {
                Bukkit.broadcastMessage("you got the answer right you immbecile");
                Bukkit.broadcastMessage("The answer was: " + ChatColor.GREEN + answer);
                gameOver = true;
            } else {
                // if out of guesses end game. increment guesses
                guesses += 1;
                // make sure it is a five letter word
                if (message.length() == 5) {
                    handleGuess(message);
                }

                if (guesses > 4) {
                    gameOver = true;
                    Bukkit.broadcastMessage("you ran outta guesses my guy");
                }
            }

        }
    }

    // This function handles guessing, and outpuitting
    // which letters were right and in which spot
    // guess is always a five letter word
    private void handleGuess(String guess) {
        String retString = "";
        // Iterate thru each letter, checking if contained?
        for (int i = 0; i < guess.length(); i++) {
            // Check if the cur char is in the right place.
            char curGuessChar = guess.charAt(i);
            String guessChar = guess.substring(i, i+1);
            char curAnswerChar = answer.charAt(i);


            if (curGuessChar == curAnswerChar) {
                // If it is in the right place, indicate with a green char.
                retString += (ChatColor.GREEN + guessChar);
            } else if (answer.contains(guessChar)) {
                // If it isn't in the right place, but it is in the word
                // Mark the letter yellow.
                retString += (ChatColor.YELLOW + guessChar);
            } else {
                // Otherwise, mark it as gray for not being in the word.
                retString += (ChatColor.GRAY + guessChar);
            }
        }

        Bukkit.broadcastMessage(retString);

    }
}
