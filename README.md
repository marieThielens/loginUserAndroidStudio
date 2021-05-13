# Utilisateur connection base android studio`

## fichier src/MainActivity.java

```java
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
```

## Fichier Strings.xml

```xml
<resurces>
    <string name="app_name">AdopteUneMarie</string>
    <string name="phrase_login_demandeNom">Veuillez entrer votre nom d\'utilisateur ainsi que votre mot de passe</string>
    <string name="se_connecter">Se connecter</string>
    <string name="mot_de_passe">Mot de passe</string>
</resources>
```

## Fichier activity_main.xml

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    >
    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/moi"
        android:src="@drawable/abc_vector_test"
        />
    <TextView
        android:id="@+id/phrase_login_demandeNom"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:padding="20dp"
        android:text="@string/phrase_login_demandeNom"
        android:gravity="center"
        />
    <EditText
        android:id="@+id/nomUtilisateur"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="10dp"
        android:layout_marginEnd="10dp"
        android:hint ="Ecrivez votre nom"
        android:focusable = "true"
        android:textColorHighlight="#ff7eff15"
        />
    <EditText
        android:id="@+id/mdp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="10dp"
        android:layout_marginEnd="10dp"
        android:hint="@string/mot_de_passe"
        android:inputType="textPassword"
        android:focusable = "true"
        />

    <TextView
        android:id="@+id/erreur"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="New Text"
        android:textSize="25dp"
        />

        <Button
            android:id="@+id/btn_login_conncet"
            android:layout_height="wrap_content"
            android:layout_width="wrap_content"
            android:text="@string/se_connecter"
            android:layout_marginTop="20dp"
            android:padding="20dp"
            android:layout_gravity="center_horizontal|center_vertical"
            />
        <Button
            android:id="@+id/btn_login_cancel"
            android:layout_height="wrap_content"
            android:layout_width="wrap_content"
            android:text="annuler"
            android:layout_marginTop="20dp"
            android:padding="20dp"
            android:layout_gravity="center_horizontal|center_vertical"
        />
```
