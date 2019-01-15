package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import game.dice.com.dicegameapp.R;

public class SelectUserActivity extends AppCompatActivity {

    ArrayList<UserCharacter> userArrayList;
    RecyclerView recyclerPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        userArrayList = new ArrayList<>();
        // le linkeo la recyclerView
        recyclerPlayers = findViewById(R.id.recyclerId);
        // forma de presentar los datos
        recyclerPlayers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        fillAllPlayers();

        // 2 pasos finales:
        UsernameListAdapter adapter = new UsernameListAdapter(userArrayList);
        recyclerPlayers.setAdapter(adapter);
    }

    private void fillAllPlayers(){
        userArrayList.add(new UserCharacter("DEFAULT NAME", "DEFAULT INFO", R.drawable.play_button));
    }

}
