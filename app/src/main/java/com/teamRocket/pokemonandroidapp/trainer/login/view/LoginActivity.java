package com.teamRocket.pokemonandroidapp.trainer.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.teamRocket.pokemonandroidapp.R;
import com.teamRocket.pokemonandroidapp.beans.Trainer;
import com.teamRocket.pokemonandroidapp.pokemon.lstPokemon.view.LstPokemonView;
import com.teamRocket.pokemonandroidapp.trainer.login.contract.MyLoginContract;
import com.teamRocket.pokemonandroidapp.trainer.login.presenter.LoginPresenter;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements MyLoginContract.View {

    private TextInputLayout textInputLayoutUsername;
    private TextInputLayout textInputLayoutPassword;
    private EditText edtName;
    private EditText edtPass;
    private Button btnLogin;
    private LoginPresenter loginPresenter;
    private ArrayList<Trainer> lstTrainers;
    private String nameEnter;
    private String passwordEnter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);
        initComponents();

        /*Accion al pulsar el boton Login*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEnter = edtName.getText().toString();
                passwordEnter = edtPass.getText().toString();
                Trainer trainer = new Trainer();
                trainer.setName(nameEnter);
                trainer.setPassword(passwordEnter);
                loginPresenter.getTrainer(getApplicationContext(), trainer);
            }
        });

    }

    private void initComponents(){
        edtName = (EditText) findViewById(R.id.edtName);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        textInputLayoutUsername = findViewById(R.id.activity_login_TextInputLayout_username);
        textInputLayoutPassword = findViewById(R.id.activity_login_TextInputLayout_password);
    }

    @Override
    public void successLogin(Trainer trainer) {
        textInputLayoutUsername.setError(null);
        textInputLayoutPassword.setError(null);

        Toast.makeText(this, "Bienvenido " + trainer.getName(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getBaseContext(), LstPokemonView.class);
        // Send the id's trainer with the key "Trainer" to the next activity
        intent.putExtra("trainerId", trainer.getId());
        startActivity(intent);
    }

    @Override
    public void failureLogin(String message) {
        textInputLayoutUsername.setError(message);
        textInputLayoutPassword.setError(message);
    }


}
