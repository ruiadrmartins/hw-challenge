package com.example.ruimartins.propertyworld.ui;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ruimartins.propertyworld.R;
import com.example.ruimartins.propertyworld.adapter.PropertyAdapter;
import com.example.ruimartins.propertyworld.data.Location;
import com.example.ruimartins.propertyworld.data.Property;
import com.vlonjatg.progressactivity.ProgressConstraintLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PropertyActivityFragment extends Fragment implements PropertyViewInterface {

    RecyclerView.Adapter adapter;

    @BindView(R.id.properties) RecyclerView properties;

    @BindView(R.id.progressActivity) ProgressConstraintLayout progressLayout;

    PropertyPresenter presenter;

    public PropertyActivityFragment() {
    }

    @SuppressLint("CheckResult")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_property, container, false);

        ButterKnife.bind(this, root);
        presenter = new PropertyPresenter(this);
        setupView();
        presenter.getProperties();

        return root;
    }

    @Override
    public void setLocation(Location location) {
        getActivity().setTitle(String.format(getString(R.string.location_text), location.getCity().getName(), location.getCity().getCountry()));
    }

    @Override
    public void setupView() {
        properties.setLayoutManager(new LinearLayoutManager(getContext()));
        properties.setAdapter(adapter);
        progressLayout.showEmpty(R.mipmap.ic_sad_face, getString(R.string.state_not_found_title),
                getString(R.string.state_not_found_desc));
    }

    @Override
    public void showLoading() {
        progressLayout.showLoading();
    }

    @Override
    public void displayProperties(List<Property> result) {
        if(result!=null) {
            adapter = new PropertyAdapter(getActivity(), result, getContext());
            properties.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            if(adapter.getItemCount()==0) {
                progressLayout.showEmpty(R.mipmap.ic_sad_face, getString(R.string.state_not_found_title),
                        getString(R.string.state_not_found_desc));
            } else {
                progressLayout.showContent();
            }
        }
    }
}
