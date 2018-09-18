package com.example.ruimartins.propertyworld.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruimartins.propertyworld.ui.PropertyDetails;
import com.example.ruimartins.propertyworld.util.Const;
import com.example.ruimartins.propertyworld.R;
import com.example.ruimartins.propertyworld.data.Property;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyHolder> {

    public static final String PROPERTY_NAME = "property-name";
    public static final String LOWEST_PRICE_PER_NIGHT = "lowest-price";
    public static final String OVERVIEW = "overview";
    public static final String RATING = "rating";
    public static final String PHOTO_PREFIX = "photo-prefix";
    public static final String PHOTO_SUFFIX = "photo-suffix";

    private List<Property> propertyList;
    private Context context;
    private Activity activity;

    public PropertyAdapter(Activity activity, List<Property> propertyList, Context context) {
        this.propertyList = propertyList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PropertyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.property_item, viewGroup,false);
        return new PropertyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyHolder propertyHolder, int i) {
        propertyHolder.name.setText(propertyList.get(i).getName());
        if(propertyList.get(i).getIsFeatured()) {
            propertyHolder.isFeatured.setText(activity.getString(R.string.featured));
            propertyHolder.isFeatured.setBackground(ContextCompat.getDrawable(context, R.drawable.gradient_featured));
        }
        if (propertyList.get(i).getOverallRating() != null) {
            int rating = propertyList.get(i).getOverallRating().getOverall();
            double ratingDouble = rating / 10.0;
            propertyHolder.rating.setText(String.valueOf(ratingDouble));

            if(ratingDouble >= 8) {
                propertyHolder.rating.setBackgroundColor(Color.GREEN);
                propertyHolder.rating.setTextColor(Color.BLACK);
            } else if (ratingDouble < 8 && ratingDouble >= 5) {
                propertyHolder.rating.setBackgroundColor(Color.YELLOW);
                propertyHolder.rating.setTextColor(Color.GRAY);
            } else if (ratingDouble > 0){
                propertyHolder.rating.setBackgroundColor(Color.RED);
                propertyHolder.rating.setTextColor(Color.WHITE);
            } else {
                propertyHolder.rating.setBackgroundColor(Color.GRAY);
                propertyHolder.rating.setTextColor(Color.WHITE);
                propertyHolder.rating.setText(activity.getString(R.string.not_available));
            }
        }
        Double value = Double.valueOf(propertyList.get(i).getLowestPricePerNight().getValue());
        value /= Const.VEF_TO_EUR;
        String price = String.format("%.2f",value);
        propertyHolder.lowestPricePerNight.setText(String.format(context.getString(R.string.price_text), price));
        if (!propertyList.get(i).getImages().isEmpty()) {
            String path = activity.getString(R.string.http_prefix) + propertyList.get(i).getImages().get(0).getPrefix() + propertyList.get(i).getImages().get(0).getSuffix();
            Picasso.get()
                    .load(path)
                    .placeholder(R.drawable.ic_photo_black_24dp)
                    .error(R.drawable.ic_sentiment_dissatisfied_black_24dp)
                    .fit()
                    .centerCrop(Gravity.TOP)
                    .into(propertyHolder.propertyPhoto);
        }
        propertyHolder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, PropertyDetails.class);
            intent.putExtra(PROPERTY_NAME, propertyList.get(i).getName());
            intent.putExtra(LOWEST_PRICE_PER_NIGHT, price);
            intent.putExtra(OVERVIEW, propertyList.get(i).getOverview());
            if (propertyList.get(i).getOverallRating() != null) {
                intent.putExtra(RATING, propertyList.get(i).getOverallRating().getOverall());
            }
            if (!propertyList.get(i).getImages().isEmpty()) {
                intent.putExtra(PHOTO_PREFIX, propertyList.get(i).getImages().get(0).getPrefix());
                intent.putExtra(PHOTO_SUFFIX, propertyList.get(i).getImages().get(0).getSuffix());
            }

            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(activity, (View) propertyHolder.propertyPhoto, "property_photo");
            context.startActivity(intent, options.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return propertyList.size();
    }

    class PropertyHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView name;
        private TextView isFeatured;
        private TextView rating;
        private TextView lowestPricePerNight;
        private ImageView propertyPhoto;

        PropertyHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            name = (TextView) v.findViewById(R.id.property_item_name);
            isFeatured = (TextView) v.findViewById(R.id.property_item_is_featured);
            rating = (TextView) v.findViewById(R.id.property_item_rating);
            lowestPricePerNight = (TextView) v.findViewById(R.id.property_item_lowest_price_per_night);
            propertyPhoto = (ImageView) v.findViewById(R.id.property_photo);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
