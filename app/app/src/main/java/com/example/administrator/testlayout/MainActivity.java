package com.example.administrator.testlayout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    BottomBar bottomBar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);*/

        //actionBar.hide();

        bottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        //BottomBar bottomBar = findViewById(R.id.bottom_bar);
        //bottomBar.setTitleBeforeAndAfterColor("#adaeb2","#d1a08f");
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#adaeb2","#d1a08f")
                .addItem(Fragment1.class,
                        "",
                        R.drawable.discoverybb,
                        R.drawable.discover)
                .addItem(Fragment2.class,
                        "",
                        R.drawable.searchbbb,
                        R.drawable.searcha)
                .addItem(FragmentUserPersonal.class,
                        "",
                        R.drawable.minebb,
                        R.drawable.minefillf)
                .addItem(Fragment4.class,
                        "",
                        R.drawable.homepagefillbb,
                        R.drawable.homepagefill)
                .addItem(Fragment4.class,
                        "",
                        R.drawable.albumcover3,
                        R.drawable.square)
                .setTitleSize(0)
                .build();
    }
}
