package com.pdprogramer.dentapp.model.media;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.pdprogramer.dentapp.PlayerMediaActivity;
import com.pdprogramer.dentapp.R;

import java.util.List;

public class ItemMediaAdapter extends ArrayAdapter<ItemMedia> {

    public ItemMediaAdapter(@NonNull Context context, List<ItemMedia> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemMedia=convertView;

        if(null==convertView){
            listItemMedia=inflater.inflate(R.layout.item_media,parent,false);

        }
        final ItemMedia media = getItem(position);
        ImageView contenido= listItemMedia.findViewById(R.id.imageDetall);
//        Button  play=(Button)listItemMedia.findViewById(R.id.play);
        String value_video="android.resource://"+getContext().getPackageName()+"/"+media.resource;
        Glide.with(getContext()).load(value_video).into(contenido);
        contenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), PlayerMediaActivity.class);
                intent.putExtra("video",media.resource);
                getContext().startActivity(intent);
            }
        });





        return listItemMedia;
    }
}
