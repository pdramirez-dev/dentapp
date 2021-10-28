package com.pdprogramer.dentapp.ui.home;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pdprogramer.dentapp.R;
import com.pdprogramer.dentapp.model.speak.ItemSpeakAdapter;

public class HomeFragment extends Fragment {


    private ListView lv;
    private ItemSpeakAdapter adapter;
    private String[] textG = {"Cepillar", "Lavar", "Limpiar", "Renovar", "Tener", "Mantener"};
    private String[] textP = {"Los dientes al menos tres veces al día",
            "La superficie externa de de los dientes, la interna y la lengua",
            "Los espacios entre los dientes con hilo dental",
            "El consumo de golosinas y liquidos azucarados. De hacerlo Cepillarse los dientes enseguida",
            "Una alimentacion Variada y equilibrada",
            "El enjuague bucal no reemplaza el cepillado. En caso de usarlo preferir uno sin alcohol y con fluor"};
    private int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        lv = root.findViewById(R.id.lis_card_speak);
        adapter = new ItemSpeakAdapter(getActivity(), textG, textP, images);
        lv.setAdapter(adapter);

        return root;


    }
}

