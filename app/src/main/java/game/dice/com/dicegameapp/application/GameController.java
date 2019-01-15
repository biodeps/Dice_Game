package game.dice.com.dicegameapp.application;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.domain.*;

public class GameController {
    // la capa application conté la lògica del negoci. És el controlador, qui demana les coses a
    // les altres capes. L'usuari no hi ha d'interaccionar directament, si no a través de view

    private static Player currentPlayer; // Como Jordi ha puesto static aquí... (leer abajo)
    private static ArrayList<Player> players;

    public GameController() {

    }

    public void createPlayer(String name) {
        currentPlayer = new Player(name); // ... he quitado el this.currentPlayer para poner currentPlayer solo
    }

    public String getPlayerName() {
        return currentPlayer.getName();
    }

    public boolean playGame() {
        Game game = new Game();
        boolean hasWon = game.playGame();
        currentPlayer.addGame(game);
        return hasWon;
    }

    public String getPlayerGamesToString() {
        String text = "";
        List<Game> games = currentPlayer.getAllGames();

        for (Game game : games) {
            text += "SUMA: " + game.getSumDices() + " RESULTAT: " + game.hasWon();
        }
        return text;
    }

    public double getPlayerRanking() {
        List<Game> games = currentPlayer.getAllGames();

        double wins = 0.0;
        for (Game game : games) {
            if (game.hasWon())
                wins++;
        }
        return wins / games.size();
    }

}
