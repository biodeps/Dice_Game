package game.dice.com.dicegameapp.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Dice;

public class PlayGameActivity extends AppCompatActivity {

    ImageView leftDice;
    ImageView rightDice;
    TextView header;
    TextView result;
    String welcome;
    String resultString = "";

    protected GameController currentGame = new GameController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Lleno las variables con su ID en el onCreate
        setContentView(R.layout.activity_play_game);
        leftDice = findViewById(R.id.imageView_LeftDice);
        rightDice = findViewById(R.id.imageView_RightDice);
        header = findViewById(R.id.textViewGameHeader);
        result = findViewById(R.id.textView_Results);
        updateHeader();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO ARREGLAR ESTO En onResume, le asigno el gráfico del interrogante
        // leftDice.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.dice_initial_icon));
        // rightDice.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.dice_initial_icon));

    }

    public void newThrow (View view) {
        boolean playerWins = currentGame.playGame();
        int dice1 = currentGame.getLeftDiceLastValue();
        int dice2 = currentGame.getRightDiceLastValue();

        updateDicesImage(dice1, dice2);
        updateHeader();
        updateResult(playerWins, dice1, dice2);
    }

    public void updateHeader() {
        welcome = String.format(getResources().getString(R.string.text_Welcome),
                currentGame.getCurrentPlayerName(), currentGame.getCurrentPlayerNumberOfGames());
        header.setText(welcome);
    }

    public void updateResult(boolean playerWins, int dice1, int dice2) {
        resultString = "The sum of dices is : " + (dice1 + dice2) + "\n" + "You ";
        if (playerWins) {
            resultString += "WIN!";
        } else {
            resultString += "LOOSE...";
        }
        result.setText(resultString);
    }

    public void updateDicesImage(int leftDiceNumber, int rightDiceNumber) {
        // todo ACTUALIZAR IMÁGENES DE LOS DADOS CON SU RESULTADO
        Bitmap leftBitmap, rightBitmap;
        int leftDrawableInt = assignDrawable(leftDiceNumber);
        int rightDrawableInt = assignDrawable(rightDiceNumber);
        leftBitmap = BitmapFactory.decodeResource(getResources(), leftDrawableInt);
        rightBitmap = BitmapFactory.decodeResource(getResources(), rightDrawableInt);
        rightDice.setImageBitmap(rightBitmap);
        leftDice.setImageBitmap(leftBitmap);

    }

    private int assignDrawable(int number) {
        switch (number) {
            case 1: return R.drawable.dice_1;
            case 2: return R.drawable.dice_2;
            case 3: return R.drawable.dice_3;
            case 4: return R.drawable.dice_4;
            case 5: return R.drawable.dice_5;
            case 6: return R.drawable.dice_6;
        }
        return 0;
    }

}
