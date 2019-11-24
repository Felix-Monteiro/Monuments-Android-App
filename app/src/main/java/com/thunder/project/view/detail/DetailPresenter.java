/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 24/11/19 14:52                                               -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.detail;

import android.support.annotation.NonNull;

import com.thunder.project.Utils;
import com.thunder.project.model.Places;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {
    private DetailView view;

    public DetailPresenter(DetailView view){ this.view = view; }

    void getPlaceById(String placeName){

        view.showLoading();

        Utils.getApi().getPlacesByName(placeName).enqueue(new Callback<Places>() {
            @Override
            public void onResponse(@NonNull Call<Places> call,@NonNull Response<Places> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() !=null){
                    view.setPlace(response.body().getPlaces().get(0));
                }else{
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Places> call,@NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }
}
