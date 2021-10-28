package com.pdprogramer.dentapp.ui.media;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pdprogramer.dentapp.R;
import com.pdprogramer.dentapp.model.media.ItemMedia;
import com.pdprogramer.dentapp.model.media.ItemMediaAdapter;

import java.util.ArrayList;
import java.util.List;

public class MediaFragment extends Fragment {

    private ListView listaMedia;
     @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_media,container,false);
        ItemMediaAdapter mediaItemAdap=new ItemMediaAdapter(getContext(),getItemMedias());
        listaMedia=root.findViewById(R.id.listaReproductor);
        listaMedia.setAdapter(mediaItemAdap);
        return root;


    }

    public   List<ItemMedia> getItemMedias(){

        List<ItemMedia>list=new ArrayList<ItemMedia>();
        list.add(new ItemMedia("historia1",R.raw.video1));
        list.add(new ItemMedia("historia2",R.raw.video2));
        list.add(new ItemMedia("historia3",R.raw.video3));
        list.add(new ItemMedia("historia4",R.raw.video4));


       return list;
    }
}
