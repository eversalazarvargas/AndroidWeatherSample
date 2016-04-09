package com.awesomecoding.androidweathersample.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awesomecoding.androidweathersample.R;
import com.awesomecoding.androidweathersample.WeatherApplication;
import com.awesomecoding.androidweathersample.service.model.Weather;
import com.awesomecoding.androidweathersample.settings.WeatherConfiguration;
import com.awesomecoding.androidweathersample.ui.adapter.WeatherListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by everardo.salazar.vargas on 4/8/16.
 */
public class WeatherListFragment extends BaseFragment {

    protected RecyclerView recyclerView;
    protected RecyclerView.Adapter adapter;
    protected RecyclerView.LayoutManager layoutManager;

    @Inject
    protected WeatherConfiguration weatherConfiguration;

    private List<Weather> weatherList = new ArrayList<>();
    private WeatherListAdapter.WeatherListListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((WeatherApplication) getActivity().getApplication()).getApplicationComponent().inject(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (WeatherListAdapter.WeatherListListener) activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString()
                    + " must implement WeatherListListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_cities_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new WeatherListAdapter(listener, weatherList, getActivity(), weatherConfiguration);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList.clear();
        this.weatherList.addAll(weatherList);
        adapter.notifyDataSetChanged();
    }
}
