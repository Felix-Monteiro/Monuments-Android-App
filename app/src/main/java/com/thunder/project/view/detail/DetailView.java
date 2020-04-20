/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 26/10/19 10:47                                               -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.detail;

import com.thunder.project.model.Locations;
import com.thunder.project.model.Places;

import java.util.List;

//Displays the data and notifies the Presenter about user actions.
public interface DetailView {

    void showLoading();
    void hideLoading();
    void setPlace(Places.Place place);
    void onErrorLoading(String message);
}
