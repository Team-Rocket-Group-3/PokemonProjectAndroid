package com.teamRocket.pokemonandroidapp.trainer.login.presenter;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Trainer;
import com.teamRocket.pokemonandroidapp.trainer.login.contract.MyLoginContract;
import com.teamRocket.pokemonandroidapp.trainer.login.model.LoginModel;

public class LoginPresenter implements MyLoginContract.Presenter {
    private MyLoginContract.View vista;
    private LoginModel modelo;

    public LoginPresenter(MyLoginContract.View vista) {
        this.vista = vista;
        this.modelo = new LoginModel();
    }

    @Override
    public void getTrainer(Context context, Trainer trainer) {
        modelo.getTrainerService(context, new MyLoginContract.Model.OnLoginListener() {
            @Override
            public void onResolve(Trainer trainer) {
                vista.successLogin(trainer);
            }

            @Override
            public void onReject(String error) {
                vista.failureLogin(error);
            }

        }, trainer);
    }
}
