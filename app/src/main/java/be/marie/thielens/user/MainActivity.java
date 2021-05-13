package be.marie.thielens.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView phrase_login_demandeNom;
    private EditText nomUtilisateur; // mon input
    private EditText mdp; // mon mot de passe
    private Button btnLogin; // mon bouton
    private Button btnCancel;
    private TextView erreur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupérer mes éléments ( visuel ) à l'aide de l'id
        phrase_login_demandeNom = (TextView)  findViewById(R.id.phrase_login_demandeNom);
        btnLogin = (Button) findViewById(R.id.btn_login_conncet);
        nomUtilisateur = (EditText) findViewById(R.id.nomUtilisateur);
        mdp = (EditText) findViewById(R.id.mdp);
        btnCancel = (Button) findViewById(R.id.btn_login_cancel);
        erreur = (TextView) findViewById(R.id.erreur);
            erreur.setVisibility(View.GONE); // mon texte n'est pas visible au dépoart

        // Saisie utilisateur

        // Désactiver le bouton tant qu'il y a pas de nom
        btnLogin.setEnabled(false);


        // methode quand l'utilisateur rentre du texte
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
        // Ajouter l'évenement à mon bouton se connecter
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // l'utilisateur a rentré le bon nom et mot de passe
                if( nomUtilisateur.getText().toString().equals("marie")&& mdp.getText().toString().equals("azerty")) {
                    Toast.makeText(getApplicationContext() , "Vous allez être redirigé" , Toast.LENGTH_LONG).show();
                } else {
                    // mauvais mot de passe
                    Toast.makeText(getApplicationContext(), "Mauvais nom ou mot de passe", Toast.LENGTH_LONG).show();
                }
            }
        });
        // Ajouter l'evenement à mon bouton annuler
        btnCancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
        });
    }
}