package be.marie.thielens.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class activity_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Méthode pour récupérer l'intent qui a démarré l'éctivité ( dans main )
        Intent intent = getIntent();
        // La méthode getExtrads sur l'intent nous permet de récupérer l'ensemble des données envoyée
        getIntent().getExtras();
        Bundle data = intent.getExtras();
        // Si on veut récupérer qu'une donnée c'est getExtra sans le texte
        String msg = intent.getStringExtra("DEMO");
    }
}