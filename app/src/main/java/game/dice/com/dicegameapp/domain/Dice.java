package game.dice.com.dicegameapp.domain;

import java.util.Random;

public class Dice {
	// la capa domain és la que conté les classes, els objectes.

	private static final int DICE_SIDES=6;
	private int value;

	public Dice() {
		value = 1;
	}
	
	public void rollDice() {
		value = new Random().nextInt(DICE_SIDES)+1;
	}
	
	public int getValue() {
		return value;
	}
}
