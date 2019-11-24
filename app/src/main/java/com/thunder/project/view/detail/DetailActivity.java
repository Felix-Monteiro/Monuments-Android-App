/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 24/11/19 14:52                                               -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.view.detail;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thunder.project.R;
import com.thunder.project.Utils;
import com.thunder.project.model.Places;
import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;

import static com.thunder.project.view.home.HomeActivity.EXTRA_DETAIL;

public class DetailActivity extends AppCompatActivity implements DetailView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.placeThumb)
    ImageView placeThumb;

    @BindView(R.id.location)
    TextView location;

    @BindView(R.id.country)
    TextView country;

    @BindView(R.id.instructions)
    TextView instructions;

    @BindView(R.id.characteristics)
    TextView characteristics;

    @BindView(R.id.measure)
    TextView measures;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.youtube)
    TextView youtube;

    @BindView(R.id.source)
    TextView source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setupActionBar();

        Intent intent = getIntent();
        String placeName = intent.getStringExtra(EXTRA_DETAIL);

        DetailPresenter presenter = new DetailPresenter(this);
        presenter.getPlaceById(placeName);

    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.colorWhite));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorWhite));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void setupColorActionBarIcon(Drawable favoriteItemColor) {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if ((collapsingToolbarLayout.getHeight() + verticalOffset) < (2 * ViewCompat.getMinimumHeight(collapsingToolbarLayout))) {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_ATOP);

            } else {
                if (toolbar.getNavigationIcon() != null)
                    toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
                favoriteItemColor.mutate().setColorFilter(getResources().getColor(R.color.colorWhite),
                        PorterDuff.Mode.SRC_ATOP);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem favoriteItem = menu.findItem(R.id.favorite);
        Drawable favoriteItemColor = favoriteItem.getIcon();
        setupColorActionBarIcon(favoriteItemColor);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setPlace(Places.Place place) {
        Picasso.get().load(place.getStrPlaceThumb()).into(placeThumb);
        collapsingToolbarLayout.setTitle(place.getStrPlace());
        location.setText(place.getStrArea());
        country.setText(place.getStrLocation());
        instructions.setText(place.getStrHistory());
        setupActionBar();

        //===

        if (!place.getStrProperty1().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty1());
        }
        if (!place.getStrProperty2().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty2());
        }
        if (!place.getStrProperty3().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty3());
        }
        if (!place.getStrProperty4().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty4());
        }
        if (!place.getStrProperty5().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty5());
        }
        if (!place.getStrProperty6().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty6());
        }
        if (!place.getStrProperty7().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty7());
        }
        if (!place.getStrProperty8().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty8());
        }
        if (!place.getStrProperty9().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty9());
        }
        if (!place.getStrProperty10().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty10());
        }
        if (!place.getStrProperty11().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty11());
        }
        if (!place.getStrProperty12().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty12());
        }
        if (!place.getStrProperty13().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty13());
        }
        if (!place.getStrProperty14().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty14());
        }
        if (!place.getStrProperty15().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty15());
        }
        if (!place.getStrProperty16().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty16());
        }
        if (!place.getStrProperty17().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty17());
        }
        if (!place.getStrProperty18().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty18());
        }
        if (!place.getStrProperty19().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty19());
        }
        if (!place.getStrProperty20().isEmpty()) {
            characteristics.append("\n \u2022 " + place.getStrProperty20());
        }

        if (!place.getStrMeasure1().isEmpty() && !Character.isWhitespace(place.getStrMeasure1().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure1());
        }
        if (!place.getStrMeasure2().isEmpty() && !Character.isWhitespace(place.getStrMeasure2().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure2());
        }
        if (!place.getStrMeasure3().isEmpty() && !Character.isWhitespace(place.getStrMeasure3().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure3());
        }
        if (!place.getStrMeasure4().isEmpty() && !Character.isWhitespace(place.getStrMeasure4().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure4());
        }
        if (!place.getStrMeasure5().isEmpty() && !Character.isWhitespace(place.getStrMeasure5().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure5());
        }
        if (!place.getStrMeasure6().isEmpty() && !Character.isWhitespace(place.getStrMeasure6().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure6());
        }
        if (!place.getStrMeasure7().isEmpty() && !Character.isWhitespace(place.getStrMeasure7().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure7());
        }
        if (!place.getStrMeasure8().isEmpty() && !Character.isWhitespace(place.getStrMeasure8().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure8());
        }
        if (!place.getStrMeasure9().isEmpty() && !Character.isWhitespace(place.getStrMeasure9().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure9());
        }
        if (!place.getStrMeasure10().isEmpty() && !Character.isWhitespace(place.getStrMeasure10().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure10());
        }
        if (!place.getStrMeasure11().isEmpty() && !Character.isWhitespace(place.getStrMeasure11().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure11());
        }
        if (!place.getStrMeasure12().isEmpty() && !Character.isWhitespace(place.getStrMeasure12().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure12());
        }
        if (!place.getStrMeasure13().isEmpty() && !Character.isWhitespace(place.getStrMeasure13().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure13());
        }
        if (!place.getStrMeasure14().isEmpty() && !Character.isWhitespace(place.getStrMeasure14().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure14());
        }
        if (!place.getStrMeasure15().isEmpty() && !Character.isWhitespace(place.getStrMeasure15().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure15());
        }
        if (!place.getStrMeasure16().isEmpty() && !Character.isWhitespace(place.getStrMeasure16().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure16());
        }
        if (!place.getStrMeasure17().isEmpty() && !Character.isWhitespace(place.getStrMeasure17().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure17());
        }
        if (!place.getStrMeasure18().isEmpty() && !Character.isWhitespace(place.getStrMeasure18().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure18());
        }
        if (!place.getStrMeasure19().isEmpty() && !Character.isWhitespace(place.getStrMeasure19().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure19());
        }
        if (!place.getStrMeasure20().isEmpty() && !Character.isWhitespace(place.getStrMeasure20().charAt(0))) {
            measures.append("\n : " + place.getStrMeasure20());
        }


        youtube.setOnClickListener(v -> {
            Intent intentYoutube = new Intent(Intent.ACTION_VIEW);
            intentYoutube.setData(Uri.parse(place.getStrYoutube()));
            startActivity(intentYoutube);
        });

        source.setOnClickListener(v -> {
            Intent intentSource = new Intent(Intent.ACTION_VIEW);
            intentSource.setData(Uri.parse(place.getStrSource()));
            startActivity(intentSource);
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this,"Error",message);

    }
}