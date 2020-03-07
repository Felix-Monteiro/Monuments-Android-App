/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 3/17/19 5:24 AM                                              -                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.home;

import androidx.annotation.NonNull;

import com.thunder.project.Utils;
import com.thunder.project.model.Locations;
import com.thunder.project.model.Places;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HomePresenter {

    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getPlaces() {
        view.showLoading();
        Call<Places> placesCall = Utils.getApi().getPlace();
        placesCall.enqueue(new Callback<Places>() {
            @Override
            public void onResponse( @NonNull Call<Places> call, @NonNull Response<Places> response) {
                view.hideLoading();


                if (response.isSuccessful() && response.body() != null) {

                    view.setPlace(response.body().getPlaces());

                }
                else {

                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<Places> call, Throwable t) {


                view.hideLoading();

                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }


    void getLocations() {
        view.showLoading();


        Call<Locations> locationsCall = Utils.getApi().getLocations();
        locationsCall.enqueue(new Callback<Locations>() {
            @Override
            public void onResponse(@NonNull Call<Locations> call,@NonNull Response<Locations> response) {

                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {

                    view.setLocation(response.body().getLocations());

                }
                else {
                    view.onErrorLoading(response.message());

                }
            }

            @Override
            public void onFailure(@NonNull Call<Locations> call,@NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
