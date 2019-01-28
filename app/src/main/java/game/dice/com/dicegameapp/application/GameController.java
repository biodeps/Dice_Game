package game.dice.com.dicegameapp.application;

import java.util.ArrayList;
import java.util.List;
import game.dice.com.dicegameapp.domain.*;

public class GameController {
    // la capa application conté la lògica del negoci. És el controlador, qui demana les coses a
    // les altres capes. L'usuari no hi ha d'interaccionar directament, si no a través de view

    private static Player currentPlayer;
    private static ArrayList<Player> players = new ArrayList<>();

    public GameController() {

    }

    public ArrayList<Player> getPlayersList() {
        return players;
    }

    public void setCurrentPlayer (Player p) {
        currentPlayer = p;
    }

    public void createPlayer(String name) throws Exception {
        boolean alreadyExists = false;

        for (Player p: players) {
            if (p.getName().equals(name)) {
                alreadyExists = true;
                break;
            }
        }

        if (!name.equals("") && !alreadyExists) { // si no existeix el jugador a l'array de jugadors
            currentPlayer = new Player(name);
            players.add(currentPlayer);
        } else {
            throw new Exception(name);
            // [Solved] Cómo hacer para que coja el String de los resources?: Lanzo la exception y en su activity ya cojo el resource
        }

    }

    public String getCurrentPlayerName() {
        return currentPlayer.getName();
    }

    public int getCurrentPlayerNumberOfGames() { return currentPlayer.getAllGames().size();}

    public boolean playGame() {
        Game game = new Game();
        boolean hasWon = game.playGame();
        currentPlayer.addGame(game);
        return hasWon;
    }

    public int getLeftDiceLastValue () {
        return currentPlayer.getAllGames().get(currentPlayer.getAllGames().size()-1).getLeftDice();
    }

    public int getRightDiceLastValue () {
        return currentPlayer.getAllGames().get(currentPlayer.getAllGames().size()-1).getRightDice();
    }

    public String getPlayerGamesToString() {
        String text = "";
        List<Game> games = currentPlayer.getAllGames();
        String result = "";

        for (Game game : games) {
            if (game.hasWon()) { result = "WON";}
            else { result = "LOST"; }
            text += ("SUM: " + game.getSumDices() + " RESULT: " + result + "\n");
        }
        return text;
    }

    public Player getPlayerByName(String name) {
        for (Player p: players) {
            if (p.getName().equals(name)){
                return p;
            }
        }
        return new Player("Player not found");
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
