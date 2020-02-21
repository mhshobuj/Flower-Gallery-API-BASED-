package com.example.flowergallaryapibased;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowergallaryapibased.flower.FlowerResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>{
     private final String IMAGE_URL = "http://services.hanselandpetal.com/photos/";
     private Context context;
     private List<FlowerResponse> flowerResponseList;

    public FlowerAdapter(Context context, List<FlowerResponse> flowerResponseList) {
        this.context = context;
        this.flowerResponseList = flowerResponseList;
    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(context)
                .inflate(R.layout.flower_row, parent, false);
        return new FlowerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {
                holder.flowerNameTV.setText(flowerResponseList.get(position).getName());
                holder.flowerPriceTV.setText(String.valueOf(flowerResponseList.get(position).getPrice()));
                String imageFullPath = IMAGE_URL+flowerResponseList.get(position).getPhoto();
                Picasso.get().load(imageFullPath).into(holder.flowerIV);

                FlowerResponse fl = flowerResponseList.get(position);

            holder.flowerIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FlowerDetailsActivity.class);
                intent.putExtra("Image",imageFullPath);
                intent.putExtra("ID",fl.getProductId());
                intent.putExtra("Name",fl.getName());
                intent.putExtra("Price",fl.getPrice());
                intent.putExtra("Category",fl.getCategory());
                intent.putExtra("Introductions",fl.getInstructions());
                context.startActivity(intent);
            }
        });

        holder.flowerNameTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FlowerDetailsActivity.class);
                intent.putExtra("Image",imageFullPath);
                intent.putExtra("ID",fl.getProductId());
                intent.putExtra("Name",fl.getName());
                intent.putExtra("Price",fl.getPrice());
                intent.putExtra("Category",fl.getCategory());
                intent.putExtra("Introductions",fl.getInstructions());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return flowerResponseList.size();
    }

    class FlowerViewHolder extends RecyclerView.ViewHolder {

        ImageView flowerIV;
        TextView flowerNameTV, flowerPriceTV;

        public FlowerViewHolder(@NonNull View itemView) {
            super(itemView);
            flowerIV = itemView.findViewById(R.id.row_flowerIV);
            flowerNameTV = itemView.findViewById(R.id.row_flowerName);
            flowerPriceTV = itemView.findViewById(R.id.row_flowerPrice);

        }
    }
}
