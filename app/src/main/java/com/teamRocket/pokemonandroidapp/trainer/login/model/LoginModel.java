package com.teamRocket.pokemonandroidapp.trainer.login.model;

import android.content.Context;

import androidx.annotation.Nullable;

import com.teamRocket.pokemonandroidapp.beans.Trainer;
import com.teamRocket.pokemonandroidapp.retrofit.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.teamRocket.pokemonandroidapp.trainer.login.contract.MyLoginContract;

public class LoginModel implements MyLoginContract.Model {

    @Override
    public void getTrainerService(Context context, final MyLoginContract.Model.OnLoginListener onLoginListener, Trainer trainer) {
        ApiClient apiClient = new ApiClient(context);
        String name = trainer.getName();
        String password = trainer.getPassword();
        final Call<Trainer> request = apiClient.login(name, password);

        request.enqueue(new Callback<Trainer>() {
            @Override
            public void onResponse(@Nullable Call<Trainer> call, @Nullable Response<Trainer> response) {
                if (response != null && response.body() != null) {
                    onLoginListener.onResolve(response.body());
                }
            }

            @Override
            public void onFailure(@Nullable Call<Trainer> call, @Nullable Throwable t) {
                onLoginListener.onReject(t.getLocalizedMessage());
            }
        });
    }
}
