package com.burhangok.doguyemekleri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.FoodsHolder>  {


    LayoutInflater layoutInflater;
    Context context;
    List<FoodItem> foodItemList=new ArrayList<FoodItem>();


    public FoodsAdapter(Context context, List<FoodItem> foodItemList) {

        this.foodItemList = foodItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.row_layout, viewGroup, false);
        FoodsHolder vh = new FoodsHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodsHolder foodsHolder, int i) {
       final FoodItem foodItem= foodItemList.get(i);

        foodsHolder.titleTV.setText(foodItem.getTitle());

        foodsHolder.photoIV.setImageResource(foodItem.getPhoto());


        foodsHolder.rowCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent toDetail = new Intent(context,FoodDetailAcitivity.class);
                toDetail.putExtra("TITLE",foodItem.getTitle());
                toDetail.putExtra("PHOTO",foodItem.getPhoto());
                toDetail.putExtra("MATERIALS",foodItem.getMaterials());
                toDetail.putExtra("COOKING",foodItem.getCooking());

                context.startActivity(toDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }


    class FoodsHolder extends RecyclerView.ViewHolder{
        TextView titleTV;
        ImageView photoIV;
        CardView rowCV;

        public FoodsHolder(@NonNull View itemView) {
            super(itemView);

             titleTV= itemView.findViewById(R.id.foodTitle);
             photoIV = itemView.findViewById(R.id.foodPhoto);
             rowCV=itemView.findViewById(R.id.rowLayout);
        }
    }
}
