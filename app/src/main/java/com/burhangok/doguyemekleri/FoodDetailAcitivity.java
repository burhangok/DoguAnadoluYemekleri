package com.burhangok.doguyemekleri;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class FoodDetailAcitivity extends AppCompatActivity {

    TextView materialsTV,cookingTV;
    FloatingActionButton shareFAB;
    String title,materials,cooking;
    int photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail_acitivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title=getIntent().getStringExtra("TITLE");
        photo=getIntent().getIntExtra("PHOTO",0);
        materials=getIntent().getStringExtra("MATERIALS");
        cooking=getIntent().getStringExtra("COOKING");

        setTitle(title);

        AppBarLayout appBarLayout = findViewById(R.id.app_bar);

        appBarLayout.setBackgroundResource(photo);
        //Initialize
        init();


        materialsTV.setText(materials);
        cookingTV.setText(cooking);

        shareFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mesaj = title +"\n\nMalzemeler\n\n"
                        +materials+"\n\nYapılışı\n\n"
                        +cooking+"\n\n\n Bu Mesaj Doğu Anadolu Yemekleri Uygulamasından Gönderildi.";


                Intent shareI = new Intent(Intent.ACTION_SEND);
                shareI.setType("text/plain");
                shareI.putExtra(Intent.EXTRA_TEXT, mesaj);
                startActivity(shareI);


            }
        });
    }


    void init() {


        shareFAB =findViewById(R.id.fabShare);

        materialsTV=findViewById(R.id.textView2);
        cookingTV = findViewById(R.id.textView4);


    }
}
