package com.awesomecoding.androidweathersample.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.awesomecoding.androidweathersample.R;
import com.awesomecoding.androidweathersample.service.model.Weather;
import com.awesomecoding.androidweathersample.settings.WeatherConfiguration;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by everardo.salazar.vargas on 4/8/16.
 */
public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherListViewHolder> {

    private List<Weather> weatherList;
    private WeatherListListener listener;
    private Context context;
    private WeatherConfiguration configuration;

    public WeatherListAdapter(WeatherListListener listener, List<Weather> weatherList, Context context, WeatherConfiguration configuration) {
        this.listener = listener;
        this.weatherList = weatherList;
        this.context = context;
        this.configuration = configuration;
    }

    public interface WeatherListListener {
        void onListItemClicked(Weather weather);
    }

    @Override
    public WeatherListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext())
                                                         .inflate(R.layout.weather_list_item, parent, false);

        WeatherListViewHolder viewHolder = new WeatherListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListViewHolder holder, int position) {
        final Weather weather = weatherList.get(position);
        holder.textCity.setText(weather.getName());
        holder.textTemp.setText(weather.getMain().getTemp() + "");
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onListItemClicked(weather);
            }
        });

        Picasso.with(context)
               .load(configuration.getIconsBaseUrl() + weather.getIcons().get(0).getIcon() + ".png")
               .into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public static class WeatherListViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout itemLayout;
        private TextView textCity;
        private TextView textTemp;
        private ImageView icon;


        public WeatherListViewHolder(LinearLayout itemView) {
            super(itemView);
            itemLayout = itemView;
            textCity = (TextView) itemLayout.findViewById(R.id.txt_city);
            textTemp = (TextView) itemLayout.findViewById(R.id.txt_temperature);
            icon = (ImageView) itemLayout.findViewById(R.id.img_icon);
        }
    }

}
