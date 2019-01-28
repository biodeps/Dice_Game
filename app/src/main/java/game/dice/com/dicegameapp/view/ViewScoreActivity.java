package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Player;

public class ViewScoreActivity extends AppCompatActivity {

    protected GameController currentGame = new GameController();

    TextView rankingHeader;
    String textHeader;
    TextView listedGames;
    String textBody;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);
        listedGames = findViewById(R.id.textView_GamesList);
        rankingHeader = findViewById(R.id.textView_Ranking);
        String selectedPlayerName = getIntent().getExtras().getString("player"); //recupero cuál es el player a mostrar
        player = currentGame.getPlayerByName(selectedPlayerName);
        currentGame.setCurrentPlayer(player);

        textHeader = String.format(getResources().getString(R.string.text_GameList), player.getName());
        textBody = currentGame.getPlayerGamesToString();

    }

    @Override
    protected void onResume() {
        super.onResume();
        rankingHeader.setText(textHeader);
        listedGames.setText(textBody);
    }

}
