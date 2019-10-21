/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 3/17/19 5:24 AM                                              -                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.home;

import com.thunder.project.Utils;
import com.thunder.project.model.Locations;
import com.thunder.project.model.Places;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class HomePresenter {

    private HomeView view;

    // TODO 15 Create the constructor (View)

    void getMeals() {
        // TODO 16 do loading before making a request to the server

        // TODO 17 with the line you have made a request
        Call<Places> placesCall = Utils.getApi().getPlace();

        // TODO 19 waiting for Callback
        placesCall.enqueue(new Callback<Places>() {
            @Override
            public void onResponse(Call<Places> call, Response<Places> response) {
                // TODO 20 Close loading when you have received a response from the server

                // TODO 21 Non-empty results check & Non-empty results check
                if (response.isSuccessful() && response.body() != null) {
                    /*
                     * TODO 22 Receive the result
                     * input the results obtained into the setPlaces() behavior
                     * and enter response.body() to the parameter
                     */


                }
                else {
                    // TODO 23 Show an error message if the conditions are not met

                }
            }

            @Override
            public void onFailure(Call<Places> call, Throwable t) {
                /*
                 * Failure will be thrown here
                 * for this you must do
                 * 1. closes loading
                 * 2. displays an error message
                 */

                // TODO 24 Close loading
                // TODO 25 Show an error message
            }
        });
    }


    void getLocations() {
        // TODO 26 do loading before making a request to the server

        // TODO 27 create Call<Locations> locationsCall = ...
        Call<Locations> locationsCall = null;

        // TODO 28 waiting for enqueue Callback
        locationsCall.enqueue(new Callback<Locations>() {
            @Override
            public void onResponse(Call<Locations> call, Response<Locations> response) {
                // TODO 29 Non-empty results check & Non-empty results check
                if (response.isSuccessful() && response.body() != null) {
                    /*
                     * TODO 30 Receive the result
                     * input the results obtained into the setPlaces() behavior
                     * and enter response.body() to the parameter
                     */


                }
                else {
                    // TODO 31 Show an error message if the conditions are not met

                }
            }

            @Override
            public void onFailure(Call<Locations> call, Throwable t) {
                /*
                 * Failure will be thrown here
                 * for this you must do
                 * 1. closes loading
                 * 2. displays an error message
                 */

                // TODO 32 Close loading
                // TODO 33 Show an error message
            }
        });
    }
}
