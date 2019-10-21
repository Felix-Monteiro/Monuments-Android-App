/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                              -
 - Last modified 3/17/19 5:24 AM                                              -                        -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.api;

import com.thunder.project.model.Places;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MonumentApi {

    @GET("")
    Call<Places> getPlace();

    // TODO 12 also make the Call like getPlace() method for category

    /*
     * @GET (" url ") -->
     *     this is the request annotation with REQUEST METHOD [GET]
     *
     * Call <Object> methodName(); -->
     *     we will make the getCategoris () method with the Call <Location> || method meaning
     *     that the result of the request [GET] will be accommodated into Object (Location)
     *
     */
}
