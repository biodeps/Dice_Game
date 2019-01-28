package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;

public class MainActivity extends AppCompatActivity {

    protected GameController currentGame = new GameController();

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
            // Rellenar aquí la llamada a la Activity de Settings que permita cambiar el fondo
        }

        if (id == R.id.mainMenuAbout) {
            View view = new View(this);
            openInfoView(view);
        }

        return super.onOptionsItemSelected(item);
    }

    private void openInfoView(View view) {
        Intent aboutScreenIntent = new Intent(this, InfoActivity.class);
        startActivity(aboutScreenIntent);
    }

    public void goPlay(View view) {
        Intent playIntent = new Intent(this, SelectUserActivity.class);
        playIntent.putExtra("ranking", false);
        startActivity(playIntent);
    }

    public void goRegister(View view) {
        Intent registerIntent = new Intent(this, RegisterUserActivity.class);
        startActivity(registerIntent);
    }

    public void goRanking(View view) {
        Intent rankingIntent = new Intent(this, SelectUserActivity.class);
        rankingIntent.putExtra("ranking", true);
        startActivity(rankingIntent);
    }

    public void exitApp(View view) {
        finish();
    }

}
