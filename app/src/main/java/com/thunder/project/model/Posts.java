/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 03/03/20 11:28                                               -
 - Copyright (c) 2020. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.model;

import com.google.firebase.database.Exclude;

//Responsible for handling the Memories logic and communication with the network and database layers.
public class Posts {

    private String name;
    private String imageURL;
    private String key;
    private String description;
    private int position;

    public Posts(){}

    public Posts(int position){
        this.position= position;
    }

    public Posts(String name, String imageURL, String Des){
        if (name.trim().equals("")){
            name="No name";
        }
        this.name=name ;
        this.imageURL=imageURL;
        this.description=Des;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getImageURL(){
        return imageURL;
    }

    public void setImageURL(String imageURL){
        this.imageURL= imageURL;
    }

    @Exclude
    public String getKey(){
        return key;
    }

    @Exclude
    public void setKey(String key){
        this.key=key;
    }
}
