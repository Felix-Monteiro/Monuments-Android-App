/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 09/11/19 11:26                                               -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thunder.project.R;
import com.thunder.project.model.Places;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewPlaceByLocation extends RecyclerView.Adapter<RecyclerViewPlaceByLocation.RecyclerViewHolder> {

    private List<Places.Place> places;
    private Context context;
    private static ClickListener clickListener;


    public RecyclerViewPlaceByLocation(Context context, List<Places.Place> places) {
        this.places = places;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerViewPlaceByLocation.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_place,
                viewGroup, false);
        return new RecyclerViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerViewPlaceByLocation.RecyclerViewHolder viewHolder, int i) {

        String strPlaceThumb = places.get(i).getStrPlaceThumb();
        Picasso.get().load(strPlaceThumb).placeholder(R.drawable.shadow_bottom_to_top).into(viewHolder.placeThumb);

        String strPlaceName = places.get(i).getStrPlace();
        viewHolder.placeName.setText(strPlaceName);
    }


    @Override
    public int getItemCount() {
        return places.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.placeThumb)
        ImageView placeThumb;
        @BindView(R.id.placeName)
        TextView placeName;
        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }


    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerViewPlaceByLocation.clickListener = clickListener;
    }


    public interface ClickListener {
        void onClick(View view, int position);
    }
}