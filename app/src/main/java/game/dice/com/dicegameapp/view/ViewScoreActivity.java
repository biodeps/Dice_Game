package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Player;

public class ViewScoreActivity extends AppCompatActivity {

    static ArrayList<Player> userArrayList;
    protected UsernameListAdapter adapter;
    protected GameController currentGame = new GameController();

    TextView rankingHeader;
    String textHeader;
    TextView listedGames;
    String textBody;

    // TODO Esta activity muestra una lista con el String de TODOS los juegos del usuario, que ya están implementados en una función

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);
        listedGames = findViewById(R.id.textView_GamesList);
        Player selectedPlayer = (Player) getIntent().getSerializableExtra("player"); //recupero cuál es el player a mostrar
        textHeader = String.format(getResources().getString(R.string.text_GameList), selectedPlayer.getName());
        textBody = currentGame.getPlayerGamesToString();

    }
    @Override
    protected void onResume() {
        super.onResume();
        rankingHeader.setText(textHeader);
        listedGames.setText(textBody);
        adapter.notifyDataSetChanged();
    }

}
