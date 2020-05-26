package com.demo.weather_forcast.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.weather_forcast.R;
import com.demo.weather_forcast.model.OneClassdailyVo;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyAdapter extends BaseAdapter {
        public Context context;
        public List<OneClassdailyVo> oneClassdailyVos;

    public MyAdapter(Context context, List<OneClassdailyVo> oneClassdailyVos) {
        this.context = context;
        this.oneClassdailyVos = oneClassdailyVos;
    }

    @Override
        public int getCount() {
            return oneClassdailyVos.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View vview, ViewGroup viewGroup)
        {
            View view= LayoutInflater.from(context).inflate(R.layout.row_data,null);
            ImageView image_view_= view.findViewById(R.id.image_);
            TextView text_sunrise_temp=view.findViewById(R.id.sunrise_);
            //TextView text_max_temp=view.findViewById(R.id.max_temp);
           // TextView text_min_temp= view.findViewById(R.id.min_temp);

            Long sunrise=oneClassdailyVos.get(i).getSunrise();
            String sunrise_text =  new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date( sunrise* 1000));
            text_sunrise_temp.setText(sunrise_text);


            //text_sunrise_temp.setText(oneClassdailyVos.get(i).getSunrise().toString());
           // text_max_temp.setText(oneClassdailyVos.get(i).getWeather().get(i).toString()+"°C");


            return view;
        }
    }

