package com.example.daerahindonesia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   private ApiInterface apiInterface;
   private List<Daerah>daerahs;
   private SemuaProvinsi provinsinya;
   LinearLayoutManager linearLayoutManager;
   RecyclerView recyclerView;
   DaerahAdapter daerahAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<SemuaProvinsi>call = apiInterface.getdaerah();
        call.enqueue(new Callback<SemuaProvinsi>() {
            @Override
            public void onResponse(Call<SemuaProvinsi> call, Response<SemuaProvinsi> response) {
                provinsinya=response.body();
                daerahs=provinsinya.getSemuaprovinsi();
                daerahAdapter=new DaerahAdapter(daerahs,MainActivity.this);
                recyclerView.setAdapter(daerahAdapter);
            }

            @Override
            public void onFailure(Call<SemuaProvinsi> call, Throwable t) {

            }
        });


    }
}
