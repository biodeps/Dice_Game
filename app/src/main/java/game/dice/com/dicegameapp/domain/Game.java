package game.dice.com.dicegameapp.domain;

import java.io.Serializable;

public class Game implements Serializable {

	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	
	public Game(){
		
	}
	
	public boolean playGame() {
		dice1.rollDice();
		dice2.rollDice();
		return hasWon();
	}
	
	public int getSumDices(){
		return dice1.getValue() + dice2.getValue();
	}

	public int getLeftDice() { return dice1.getValue(); }

    public int getRightDice() { return dice2.getValue(); }
	
	public boolean hasWon() {
		return getSumDices() == 7;
	}

}
