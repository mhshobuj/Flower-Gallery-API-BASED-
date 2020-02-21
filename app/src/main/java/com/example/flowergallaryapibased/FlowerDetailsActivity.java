package com.example.flowergallaryapibased;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


public class FlowerDetailsActivity extends AppCompatActivity {


    private ImageView flowerIV;

    private TextView flowerIDTV, flowerNameTV,
                     flowerPriceTV, flowerCatagoryIV,
                     flowerInstructionIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_details);
        setTitle("Flower Details");
        flowerIV = findViewById(R.id.flowerImage);
        flowerIDTV = findViewById(R.id.flowerID);
        flowerNameTV = findViewById(R.id.flowerName);
        flowerPriceTV = findViewById(R.id.flowerPrice);
        flowerCatagoryIV = findViewById(R.id.flowerCategory);
        flowerInstructionIV = findViewById(R.id.flowerInstruction);

        String ImageUrl = getIntent().getStringExtra("Image");
        int id = getIntent().getIntExtra("ID",-1);
        String name = getIntent().getStringExtra("Name");
        double price = getIntent().getDoubleExtra("Price", -1);
        String category = getIntent().getStringExtra("Category");
        String instructions = getIntent().getStringExtra("Introductions");


        Picasso.get().load(ImageUrl).into(flowerIV);
        flowerIDTV.setText("Product ID - "+id);
        flowerNameTV.setText("Name - "+name);
        flowerPriceTV.setText("Price - "+price);
        flowerCatagoryIV.setText("Category - "+category);
        flowerInstructionIV.setText("Instructions - "+instructions);
    }
}
