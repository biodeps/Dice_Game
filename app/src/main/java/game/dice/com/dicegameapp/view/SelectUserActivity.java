package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Player;

public class SelectUserActivity extends AppCompatActivity {

    ArrayList<Player> userArrayList;
    RecyclerView recyclerPlayers;
    protected UsernameListAdapter adapter;
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

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // implementación del método onClick que he generado en mi adaptador
                String currentUserName = userArrayList.get(recyclerPlayers.getChildAdapterPosition(view)).getName(); // String del currentUserName
                for (Player p: userArrayList) {
                    if (p.getName().equals(currentUserName)) { // encuentro el usuario con el que voy a jugar, y lo asigno
                        currentGame.setCurrentPlayer(p);
                    }
                }
                Intent newGameIntent = new Intent(getApplicationContext(), PlayGameActivity.class);
                startActivity(newGameIntent);
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
        adapter.notifyDataSetChanged(); //notifica que s'ha modificat l'arraylist i actualitza automàticament
    }

}
