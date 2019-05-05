package com.burhangok.doguyemekleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView foodRV;
    FoodsAdapter foodsAdapter;
    LinearLayoutManager linearLayoutManager;
    List<FoodItem> foodItemList;

    SessionManagement sessionManagement;

    LocalDatabase localDatabase;
    public AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodRV =findViewById(R.id.foods);

        MobileAds.initialize(this, "ca-app-pub-5903218970036631~3343513051");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        foodItemList = new ArrayList<>();

        localDatabase = new LocalDatabase(this);

        sessionManagement= new SessionManagement(this);

        if(sessionManagement.checkLogin()==true) {

           // Toast.makeText(this, "Giriş VAR", Toast.LENGTH_LONG).show();

        }

        else {
           // Toast.makeText(this, "Giriş YOK", Toast.LENGTH_LONG).show();
            sessionManagement.createSession();
            saveFoods();
        }


        foodsAdapter = new FoodsAdapter(this,localDatabase.getFoods());
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        foodRV.setLayoutManager(linearLayoutManager);

        foodRV.setAdapter(foodsAdapter);


    }


    void saveFoods() {


        FoodItem food1 =  new FoodItem(getResources().getString(R.string.food1),
                R.drawable.food1,getResources().getString(R.string.food1M),
                getResources().getString(R.string.food1C));


        FoodItem food2 =  new FoodItem(getResources().getString(R.string.food2),
                R.drawable.food2,getResources().getString(R.string.food2M),
                getResources().getString(R.string.food2C));


        FoodItem food3 =  new FoodItem(getResources().getString(R.string.food3),
                R.drawable.food3,getResources().getString(R.string.food3M),
                getResources().getString(R.string.food3C));

        FoodItem food4 = new FoodItem(getResources().getString(R.string.food4),
                R.drawable.food4,getResources().getString(R.string.food4M),
                getResources().getString(R.string.food4C));

        FoodItem food5 = new FoodItem(getResources().getString(R.string.food5),
                R.drawable.food5,getResources().getString(R.string.food5M),
                getResources().getString(R.string.food5C));

        FoodItem food6 = new FoodItem(getResources().getString(R.string.food6),
                R.drawable.food6,getResources().getString(R.string.food6M),
                getResources().getString(R.string.food6C));

        FoodItem food7 = new FoodItem(getResources().getString(R.string.food7),
                R.drawable.food7,getResources().getString(R.string.food7M),
                getResources().getString(R.string.food7C));

        FoodItem food8 = new FoodItem(getResources().getString(R.string.food8),
                R.drawable.food8,getResources().getString(R.string.food8M),
                getResources().getString(R.string.food8C));


        FoodItem food9 = new FoodItem(getResources().getString(R.string.food9),
                R.drawable.food9,getResources().getString(R.string.food9M),
                getResources().getString(R.string.food9C));


        FoodItem food10 = new FoodItem(getResources().getString(R.string.food10),
                R.drawable.food10,getResources().getString(R.string.food10M),
                getResources().getString(R.string.food10C));

        localDatabase.addFood(food1);
        localDatabase.addFood(food2);
        localDatabase.addFood(food3);
        localDatabase.addFood(food4);
        localDatabase.addFood(food5);
        localDatabase.addFood(food6);
        localDatabase.addFood(food7);
        localDatabase.addFood(food8);
        localDatabase.addFood(food9);
        localDatabase.addFood(food10);


    }
}
