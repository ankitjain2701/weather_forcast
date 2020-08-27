package com.demo.weather_forcast.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {
    public Context context;
    public List<OneClassdailyVo> oneClassdailyVos;

    public HorizontalAdapter(Context applicationContext, List<OneClassdailyVo> daily) {
        this.context = applicationContext;
        this.oneClassdailyVos = daily;
    }


    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        //View view=inflater.inflate(R.layout.row_data,parent,false);
        View view= LayoutInflater.from(context).inflate(R.layout.row_data,null);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {

        Long sunrise=oneClassdailyVos.get(position).getSunrise();
        String sunrise_text =  new SimpleDateFormat("dd/MM/yy hh:mm a", Locale.ENGLISH).format(new Date( sunrise* 1000));
        holder.text_sunrise_temp.setText(sunrise_text);

        Double temp1=oneClassdailyVos.get(position).getTemp().getMax();
        Double cal_temp1=temp1-273.15;
        DecimalFormat precision1 = new DecimalFormat("0.0");

        holder.text_max_temp.setText("Temp Max: "+precision1.format(cal_temp1)+"°C");

        Double temp=oneClassdailyVos.get(position).getTemp().getMin();
        Double cal_temp=temp-273.15;
        DecimalFormat precision = new DecimalFormat("0.0");

        holder.text_min_temp.setText("Temp Min: "+precision.format(cal_temp)+"°C");

    }

    @Override
    public int getItemCount() {
        return oneClassdailyVos.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        TextView text_sunrise_temp,text_max_temp,text_min_temp;
        ImageView image_view_;
        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view_= (ImageView) itemView.findViewById(R.id.image_);
            text_sunrise_temp=(TextView) itemView.findViewById(R.id.sunrise_);
            text_max_temp=(TextView) itemView.findViewById(R.id.temp_max_);
            text_min_temp= (TextView) itemView.findViewById(R.id.temp_min_);

        }
    }


}
