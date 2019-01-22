package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Player;


public class SelectUserActivity extends AppCompatActivity {

    ArrayList<Player> userArrayList;
    RecyclerView recyclerPlayers;
    UsernameListAdapter adapter;
    protected GameController currentGame = new GameController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        userArrayList = new ArrayList<>();
        // le linkeo la recyclerView
        recyclerPlayers = findViewById(R.id.recyclerId);
        // forma de presentar los datos
        recyclerPlayers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        // 2 pasos finales:
        adapter = new UsernameListAdapter(userArrayList);
        recyclerPlayers.setAdapter(adapter);
        fillAllPlayers();

    }

    private void fillAllPlayers(){

        //TODO ACCEDER A LOS PLAYERS DEL CURRENTGAME PARA RELLENARLOS EN UN FOREACH
        // OLD: userArrayList.add(new UserCharacter("DEFAULT NAME", "DEFAULT INFO", R.drawable.play_button));
        userArrayList.addAll(currentGame.getPlayersList());

        adapter.notifyDataSetChanged(); //notifica que s'ha modificat l'arraylist i actualitza automàticament
    }

}
