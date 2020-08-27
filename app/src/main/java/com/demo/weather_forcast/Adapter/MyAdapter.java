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
            TextView text_max_temp=view.findViewById(R.id.temp_max_);
            TextView text_min_temp= view.findViewById(R.id.temp_min_);

            Long sunrise=oneClassdailyVos.get(i).getSunrise();
            String sunrise_text =  new SimpleDateFormat("dd/MM/yy hh:mm a", Locale.ENGLISH).format(new Date( sunrise* 1000));
            text_sunrise_temp.setText(sunrise_text);


            //text_sunrise_temp.setText(oneClassdailyVos.get(i).getSunrise().toString());

            Double temp1=oneClassdailyVos.get(i).getTemp().getMax();
            Double cal_temp1=temp1-273.15;
            DecimalFormat precision1 = new DecimalFormat("0.0");

            text_max_temp.setText("Temp Max: "+precision1.format(cal_temp1)+"°C");

            Double temp=oneClassdailyVos.get(i).getTemp().getMin();
            Double cal_temp=temp-273.15;
            DecimalFormat precision = new DecimalFormat("0.0");

            text_min_temp.setText("Temp Min: "+precision.format(cal_temp)+"°C");

            return view;
        }
    }

