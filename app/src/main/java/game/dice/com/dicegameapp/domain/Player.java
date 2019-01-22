package game.dice.com.dicegameapp.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<Game> games = new ArrayList<>();
	
	public Player(String name){		
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public String getAverageScore(){
		if (games.size() == 0) {
			return ("This user hasn't played yet.");
		}
		int wins = 0;
		for(Game g: games){
			if (g.hasWon()) {
				wins++;
			}
		}

		return ("WIN RATE: " + (100 * wins / games.size()) + " %");
	}
	
	public void addGame(Game game){
		this.games.add(game);
	}

	public List<Game> getAllGames() {
		return games;
	}
}
