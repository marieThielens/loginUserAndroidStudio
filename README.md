# Utilisateur connection base android studio

## fichier src/MainActivity.java

```java
// implements pour le onclick
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView phrase_login_demandeNom;
    private EditText nomUtilisateur; // mon input
    private EditText mdp; // mon mot de passe
    private Button btnLogin, btnCancel ; // mon bouton
    private TextView erreur;

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
            erreur.setVisibility(View.GONE); // mon texte n'est pas visible au dépoart

        // Désactiver le bouton tant qu'il y a pas de nom d'une longueur de 5
        btnLogin.setEnabled(false);

        // Ecouter mes boutons
        btnLogin.setOnClickListener(this); // Sans implementer en haut this n'aurait pas marché
        btnCancel.setOnClickListener(this);


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
            if( nomUtilisateur.getText().toString().equals("marie")&& mdp.getText().toString().equals("azerty")) {
                Toast.makeText(getApplicationContext() , "Vous allez être redirigé" , Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext() , "Bonjour " + nomUtilisateur.getText() , Toast.LENGTH_LONG).show();
            } else {
                // mauvais mot de passe
                Toast.makeText(getApplicationContext(), "Mauvais nom ou mot de passe", Toast.LENGTH_LONG).show();
            }
        }
        else if (v == btnCancel) {
            finish();
        }
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
<<?xml version="1.0" encoding="utf-8"?>
 <LinearLayout
     xmlns:android="http://schemas.android.com/apk/res/android"
     xmlns:tools="http://schemas.android.com/tools"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     tools:context=".MainActivity"
     android:orientation="vertical"
     android:background="#3F3F3F"
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
         android:textColor="@color/design_default_color_background"
         android:textSize="20dp"
         android:textStyle="italic"
         />
     <EditText
         android:id="@+id/nomUtilisateur"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:layout_marginStart="10dp"
         android:layout_marginEnd="10dp"
         android:textColorHint="@color/design_default_color_background"
         android:hint ="Ecrivez votre nom"
         android:focusable = "true"
         android:textColorHighlight="#ff7eff15"
         android:textStyle="italic"
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
         android:textColorHint="@color/design_default_color_background"
         android:textStyle="italic"
        
         />
 
     <TextView
         android:id="@+id/erreur"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text=""
         android:textSize="25dp"
         android:textColor="@color/design_default_color_background"
         android:layout_marginStart="10dp"
         android:layout_marginEnd="10dp"
         />
 
     <LinearLayout
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:orientation="horizontal">
         <Button
             android:id="@+id/btn_login_conncet"
             android:layout_height="wrap_content"
             android:layout_width="140dp"
             android:text="@string/se_connecter"
             android:layout_marginTop="20dp"
             android:padding="10dp"
             android:layout_gravity="center_horizontal|center_vertical"
             android:layout_marginStart="25dip"
             android:layout_marginEnd="25dip"
             android:backgroundTint="#88C8C8"
             android:textColor="@color/black"
 
             />
         <Button
             android:id="@+id/btn_login_cancel"
             android:layout_height="wrap_content"
             android:layout_width="140dp"
             android:text="annuler"
             android:layout_marginTop="20dp"
             android:padding="10dp"
             android:layout_gravity="center_horizontal|center_vertical"
             android:layout_marginStart="25dip"
             android:layout_marginEnd="25dip"
             android:backgroundTint="#88C8C8"
             android:textColor="@color/black"
             />
     </LinearLayout>
 </LinearLayout>
```
