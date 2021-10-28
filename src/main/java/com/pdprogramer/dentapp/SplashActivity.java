package com.pdprogramer.dentapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.pdprogramer.dentapp.model.splash.ItemSplash;
import com.pdprogramer.dentapp.model.splash.SplashViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private static  final int FULLSCREEN= WindowManager.LayoutParams.FLAG_FULLSCREEN;

    private ViewPager screenPager;
    private SplashViewPagerAdapter adapter;
    private TabLayout tabIndicator;
    private Button btnNext;
    private Button btngetStarted;
    int position=0;
    Animation btnAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(FULLSCREEN,FULLSCREEN);
        if(restorePrefData()){
            Intent mainActivity=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivity);
            finish();
        }

        setContentView(R.layout.activity_splash);
//        getSupportActionBar().hide();
        btnAnimation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btn_animation);

        tabIndicator=findViewById(R.id.tab_indicator);
        screenPager=findViewById(R.id.screen_viewpager);
        btnNext=findViewById(R.id.button_next);
        btngetStarted=findViewById(R.id.button_getstarted);
        final List<ItemSplash>items=getListItem();
        adapter=new SplashViewPagerAdapter(this,getListItem());
        screenPager.setAdapter(adapter);

        tabIndicator.setupWithViewPager(screenPager);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=screenPager.getCurrentItem();
                if(position<items.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }
                if(position==items.size()-1){
                    loadLastScreen();
                }

            }
        });
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==items.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        btngetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);

                savedState();
                finish();

            }
        });

    }

    private boolean restorePrefData() {
        SharedPreferences pref=getApplicationContext().getSharedPreferences(
          "myprefe",MODE_PRIVATE
        );
        Boolean isIntrAct=pref.getBoolean("isItroOpenend",false);
        return  isIntrAct;
    }

    private void savedState() {
        SharedPreferences preferences=
                getApplicationContext().getSharedPreferences(
                  "myprefe",MODE_PRIVATE
                );
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("isItroOpenend",true);
        editor.commit();

    }

    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btngetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btngetStarted.setAnimation(btnAnimation);


    }


    private List<ItemSplash> getListItem() {
        List<ItemSplash> list = new ArrayList<>();
        list.add(new ItemSplash("Item1", "Utiliza un Cepillo dental de Celadas Suaves", R.drawable.higiene));
        list.add(new ItemSplash("Item2", "Usa Pasta con Flúor", R.drawable.cepillad));
        list.add(new ItemSplash("Item3", "Remplaza el Cepillo Cada Cuatro Meses", R.drawable.enjuague1));
        list.add(new ItemSplash("Item3", "A Partir de los Dos Años Visita Anualmente al Odontólogo", R.drawable.flossing));
        return list;
    }
}
