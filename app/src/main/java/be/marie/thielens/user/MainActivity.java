package be.marie.thielens.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// implements pour le onclick
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView phrase_login_demandeNom;
    private EditText nomUtilisateur; // mon input
    private EditText mdp; // mon mot de passe
    private Button btnLogin, btnCancel ; // mon bouton
    private TextView erreur;
    private TextView textNoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupérer mes éléments ( visuel ) à l'aide de l'id. R c'est la classe de l'id
        // par defaut findViewById est une View. Il faut préciser quel type de vue (un cast)
        phrase_login_demandeNom = (TextView)  findViewById(R.id.phrase_login_demandeNom);
        btnLogin = (Button) findViewById(R.id.btn_login_conncet);
        nomUtilisateur = (EditText) findViewById(R.id.nomUtilisateur);
        mdp = (EditText) findViewById(R.id.mdp);
        btnCancel = (Button) findViewById(R.id.btn_login_cancel);
        erreur = (TextView) findViewById(R.id.erreur);
        textNoRegister = findViewById(R.id.lien_inscription);

        erreur.setVisibility(View.GONE); // mon texte n'est pas visible au dépoart


        // Désactiver le bouton tant qu'il y a pas de nom d'une longueur de 5
        btnLogin.setEnabled(false);

        // Ecouter mes boutons
        btnLogin.setOnClickListener(this); // Sans implementer en haut this n'aurait pas marché
        btnCancel.setOnClickListener(this);
        textNoRegister.setOnClickListener(this);

        // ......... methode quand l'utilisateur rentre du texte..............
        nomUtilisateur.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ici que l'on verifie l'entrée utilisateur. Si au moins 5 lettre est saisie
                btnLogin.setEnabled(s.toString().length() >= 5 );
                erreur.setText(" La longueur de l'utilisateur doit être de 5");
                erreur.setVisibility(View.VISIBLE); // Je rends mon message visible
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    // Ce qui se passe après avoir cliqué sur l'un des boutons
    @Override
    public void onClick(View v) { // View v represente le bouton qui a été cliqué
        if (v == btnLogin) { // si c'est le bouton de login
            // l'utilisateur a rentré le bon nom et mot de passe
            if (nomUtilisateur.getText().toString().equals("marie") && mdp.getText().toString().equals("azerty")) {
                Toast.makeText(getApplicationContext(), "Vous allez être redirigé", Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Bonjour " + nomUtilisateur.getText(), Toast.LENGTH_LONG).show();
            } else {
                // mauvais mot de passe
                Toast.makeText(getApplicationContext(), "Mauvais nom ou mot de passe", Toast.LENGTH_LONG).show();
            }
        } else if (v == btnCancel) {
            nomUtilisateur.setText("");
            mdp.setText("");
            // finish(); // Sortir de l'application
        } else if (v == textNoRegister) {
            // Toast.makeText(getApplicationContext(), "boum le texte est cliquable", Toast.LENGTH_SHORT).show();
            // faire un chemein vers mon autre page
            // creer l intent , le context , activiteAdemarrer.class
            Intent intent = new Intent(getApplicationContext(), activity_register.class);
            startActivity(intent);
            intent.putExtra("Demo", "Ceci est passé d un cote a l autre");
            finish(); // Arreter l'activité (la page ) précédente
        }


    }
}