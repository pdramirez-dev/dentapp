package com.pdprogramer.dentapp.model.speak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pdprogramer.dentapp.R;

public class ItemSpeakAdapter extends ArrayAdapter {

    private int[] imageArray;
    private String[] textGArray;
    private String[] textPArray;
    private TTSManager TTSm = null;


    public ItemSpeakAdapter(Context context, String[] txtGArray, String[] txtPArray, int[] imageArray) {
        super(context, R.layout.info_home_card, R.id.txt_grande_card, txtGArray);
        this.imageArray = imageArray;
        this.textGArray = txtGArray;
        this.textPArray = txtPArray;


    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.info_home_card, null);
        }


        ImageView imageView = convertView.findViewById(R.id.img_card);
        final TextView txtG = convertView.findViewById(R.id.txt_grande_card);
        TextView txtP = convertView.findViewById(R.id.txt_pequenho_card);

        imageView.setImageResource(imageArray[position]);
        txtG.setText(textGArray[position]);
        txtP.setText(textPArray[position]);


        TTSm = new TTSManager();
        TTSm.init(convertView.getContext());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (textGArray[position] + textPArray[position]);
                TTSm.initQueue(text);
            }
        });

        return convertView;
    }

}
