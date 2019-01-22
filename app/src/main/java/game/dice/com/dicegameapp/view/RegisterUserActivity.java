package game.dice.com.dicegameapp.view;

// import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;

public class RegisterUserActivity extends AppCompatActivity {

    EditText editTextUsername; // declaro la variable como un objeto editText, no como un String! Luego obtendré su String

    protected GameController currentGame = new GameController(); // Lo declaramos sin static: Mientras sus variables sí sean estáticas, simplemente
                                                                 // repetimos esta línea de declaración donde necesitemos y ya está

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        editTextUsername = findViewById(R.id.editText_username);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO actualitzar llistats d'usuaris
    }

    public void setUserName(View view) {
        String userName = editTextUsername.getText().toString(); //getText() coge el contenido de la variable editText (no el String)

        try {
            currentGame.createPlayer(userName);
            Toast.makeText(this, getString(R.string.toastCreatedUser), Toast.LENGTH_LONG).show(); // New player created :)
        } catch (Exception e){
            if (e.getMessage().equals("")) {
                Toast.makeText(this, getString(R.string.toastInvalidUser), Toast.LENGTH_LONG).show(); // User can't be empty
            } else {
                // "else" means the user already exists
                Toast.makeText(this, "Username " + e.getMessage() + " already exists.", Toast.LENGTH_LONG).show();
            }
        }

        /*
        Útil de lanzar Intents con datos dentro:

        Intent createUserIntent = new Intent(getApplicationContext(), MainActivity.class);
        createUserIntent.putExtra("userNameKey", userName); // userNameKey es la KEY que utilizaré para hacer un getExtras luego
        startActivity(createUserIntent); */

    }
}