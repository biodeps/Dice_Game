package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Player;

public class SelectUserActivity extends AppCompatActivity {

    static ArrayList<Player> userArrayList;
    RecyclerView recyclerPlayers;
    protected UsernameListAdapter adapter;
    protected GameController currentGame = new GameController();
    boolean ranking = false;
    TextView recyclerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);
        ranking = getIntent().getExtras().getBoolean("ranking", false);
        userArrayList = new ArrayList<>();
        recyclerPlayers = findViewById(R.id.recyclerId);
        recyclerPlayers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new UsernameListAdapter(userArrayList);
        recyclerTextView = findViewById(R.id.textView_SelectUser);

        if (ranking) {
            recyclerTextView.setText(R.string.text_HallOfFame);
        }

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentUserName = userArrayList.get(recyclerPlayers.getChildAdapterPosition(view)).getName();
                Player selectedPlayer = new Player("");
                for (Player p: userArrayList) {
                    if (p.getName().equals(currentUserName)) {
                        currentGame.setCurrentPlayer(p); // Aquí se obtiene el jugador seleccionado
                        selectedPlayer = p;
                    }
                }
                if (ranking) {
                    // si lo que quería era ver su ranking, voy a otra Activity
                    Intent rankingIntent = new Intent(getApplicationContext(), ViewScoreActivity.class);
                    rankingIntent.putExtra("player", selectedPlayer);
                    startActivity(rankingIntent);
                } else {
                    // si no quería ver su ranking, iré a la activity de jugar
                    Intent newGameIntent = new Intent(getApplicationContext(), PlayGameActivity.class);
                    startActivity(newGameIntent);
                }

            }
        });
        recyclerPlayers.setAdapter(adapter);
        fillAllPlayers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


    private void fillAllPlayers(){
        userArrayList.addAll(currentGame.getPlayersList());
        if (ranking) {
            //TODO ordenar
            // TODO en la clase Player hay que poner "implements comparable" y hacer Override de sus métodos de comparación
            Collections.sort(userArrayList);
            adapter.notifyDataSetChanged(); //notifica que s'ha modificat l'arraylist i actualitza automàticament
        }
        adapter.notifyDataSetChanged();
    }

}
