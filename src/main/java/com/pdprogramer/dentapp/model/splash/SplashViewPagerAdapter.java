package com.pdprogramer.dentapp.model.splash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.pdprogramer.dentapp.R;

import java.util.List;

public class SplashViewPagerAdapter extends PagerAdapter {

    Context context;
    List<ItemSplash> list;
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout=inflater.inflate(R.layout.layout_splash,null);
        ImageView imgeSplash=viewLayout.findViewById(R.id.imageSplash);

        TextView descriptionSplash=viewLayout.findViewById(R.id.description_splash);
        Glide.with(context).load(list.get(position).getImage_itm()).override(500,500).fitCenter().into(imgeSplash);

//        imgeSplash.setImageResource(list.get(position).getImage_itm());

        descriptionSplash.setText(list.get(position).getDescription());
        container.addView(viewLayout);

        return viewLayout;
    }

    public SplashViewPagerAdapter(Context context, List<ItemSplash> list) {
        this.context = context;
        this.list = list;
    }
}
