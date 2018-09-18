package com.example.ruimartins.propertyworld.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruimartins.propertyworld.R;
import com.example.ruimartins.propertyworld.adapter.PropertyAdapter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class PropertyDetailsFragment extends Fragment {


    @BindView(R.id.property_item_rating)
    TextView rating;

    @BindView(R.id.property_item_lowest_price_per_night)
    TextView lowestPricePerNight;

    @BindView(R.id.property_photo)
    ImageView propertyPhoto;

    @BindView(R.id.property_overview)
    TextView overview;

    public PropertyDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_property_details, container, false);
        ButterKnife.bind(this, root);

        Intent intent = getActivity().getIntent();

        String propertyNameText = intent.getStringExtra(PropertyAdapter.PROPERTY_NAME);
        int ratingText = intent.getIntExtra(PropertyAdapter.RATING, 0);
        String lowestPricePerNightText = intent.getStringExtra(PropertyAdapter.LOWEST_PRICE_PER_NIGHT);
        String propertyPhotoPrefix = intent.getStringExtra(PropertyAdapter.PHOTO_PREFIX);
        String propertyPhotoSuffix = intent.getStringExtra(PropertyAdapter.PHOTO_SUFFIX);
        String overviewText = intent.getStringExtra(PropertyAdapter.OVERVIEW);

        getActivity().setTitle(propertyNameText);
        Picasso.get()
                .load(getString(R.string.http_prefix) + propertyPhotoPrefix + propertyPhotoSuffix)
                .placeholder(R.drawable.ic_photo_black_24dp)
                .error(R.mipmap.ic_sad_face)
                .fit()
                .centerCrop(Gravity.TOP)
                .into(propertyPhoto);

        double ratingDouble = ratingText / 10.0;
        rating.setText(String.valueOf(ratingDouble));

        if(ratingDouble >= 8) {
            rating.setBackgroundColor(Color.GREEN);
            rating.setTextColor(Color.BLACK);
        } else if (ratingDouble < 8 && ratingDouble >= 5) {
            rating.setBackgroundColor(Color.YELLOW);
            rating.setTextColor(Color.GRAY);
        } else if (ratingDouble > 0){
            rating.setBackgroundColor(Color.RED);
            rating.setTextColor(Color.WHITE);
        } else {
            rating.setBackgroundColor(Color.GRAY);
            rating.setTextColor(Color.WHITE);
            rating.setText(getString(R.string.not_available));
        }

        lowestPricePerNight.setText(String.format(getString(R.string.price_text), lowestPricePerNightText));
        overview.setText(overviewText);

        return root;
    }
}
