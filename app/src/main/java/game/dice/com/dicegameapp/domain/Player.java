package game.dice.com.dicegameapp.domain;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.R;

public class Player {

	private String name;
	private List<Game> games = new ArrayList<>();
	
	public Player(String name){		
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public int getPicture() {
		return (R.id.imageUserAvatar);
	}

	public String getAverageScore(){ // Esta función se usa cuando se muestra la lista de usuarios, NO en el Ranking
		if (games.size() == 0) {
			return ("This user hasn't played yet.");
		}
		int wins = 0;
		for(Game g: games){
			if (g.hasWon()) {
				wins++;
			}
		}
		return ("WIN RATE: " + String.format("%.2f", 100.0 * wins / (games.size())) + " %  (Win: " + (wins) + ", Lost: " + (games.size()-wins) + ")");
	}
	
	public void addGame(Game game){
		this.games.add(game);
	}

	public List<Game> getAllGames() {
		return games;
	}
}
