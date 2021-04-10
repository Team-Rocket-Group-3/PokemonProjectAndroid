package com.teamRocket.pokemonandroidapp.trainer.login.contract;

import android.content.Context;

import com.teamRocket.pokemonandroidapp.beans.Trainer;

public interface MyLoginContract {

    interface View {
        void successLogin(Trainer trainer);
        void failureLogin(String message);
    }
    interface Presenter {
        void getTrainer(Context context, Trainer trainer);
    }
    interface Model {
        interface OnLoginListener {
            void onResolve(Trainer trainer);
            void onReject(String error);
        }
        void getTrainerService(Context context, OnLoginListener onLoginListener, Trainer trainer);
    }
}
