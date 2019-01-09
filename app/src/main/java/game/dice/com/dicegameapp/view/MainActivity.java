package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import game.dice.com.dicegameapp.R;

public class MainActivity extends AppCompatActivity {
    // La capa VIEW és la capa API, la que connecta amb l'usuari. Si algo es relaciona amb
    // l'usuari, ha d'anar si o si en aquesta capa.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.dice_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mainMenuSettings) {

        }

        if(id == R.id.mainMenuAbout) {
            View view = new View(this);
            openInfoView(view);
        }

        return super.onOptionsItemSelected(item);
    }

    private void openInfoView(View view) {
        Intent aboutScreenIntent = new Intent(this, InfoActivity.class);
        startActivity(aboutScreenIntent);
    }
}
