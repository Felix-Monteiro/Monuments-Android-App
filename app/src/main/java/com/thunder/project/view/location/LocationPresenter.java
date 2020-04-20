/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 28/10/19 11:20                                               -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.location;

import androidx.annotation.NonNull;



import com.thunder.project.Utils;
import com.thunder.project.model.Places;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationPresenter {

    private LocationView view;
    public LocationPresenter(LocationView view) {
        this.view = view;
    }

    void getPlaceByLocation(String location) {
        //Gets the Monuments List based on the selected Country
        view.showLoading();
        Call<Places> placesCall = Utils.getApi().getPlaceByLocation(location+".json");
        placesCall.enqueue(new Callback<Places>() {
            @Override
            public void onResponse(@NonNull Call<Places> call,@NonNull Response<Places> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.setPlaces(response.body().getPlaces());
                } else {
                    view.onErrorLoading(response.message());
                }
            }

            //Error Handling
            @Override
            public void onFailure(@NonNull Call<Places> call,@NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}