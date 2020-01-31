package com.example.flowergallaryapibased;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.flowergallaryapibased.flower.FlowerResponse;
import com.example.flowergallaryapibased.flower.FlowerServiceApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String BASE_URL = "http://services.hanselandpetal.com/";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.flowerRV);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final FlowerServiceApi serviceApi = retrofit.create(FlowerServiceApi.class);
        serviceApi.getAllFlower().enqueue(new Callback<List<FlowerResponse>>() {
            @Override
            public void onResponse(Call<List<FlowerResponse>> call, Response<List<FlowerResponse>> response) {
                if (response.isSuccessful()){
                    List<FlowerResponse> flowerList = response.body();
                    Log.e("flower", "onResponse: "+flowerList.size() );
                    FlowerAdapter adapter = new FlowerAdapter(MainActivity.this, flowerList);
                    //LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
                    GridLayoutManager glm = new GridLayoutManager(MainActivity.this, 2);
                    recyclerView.setLayoutManager(glm);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<FlowerResponse>> call, Throwable t) {
                Log.e("flower", "onFailure: "+t.getLocalizedMessage() );
            }
        });
    }
}
