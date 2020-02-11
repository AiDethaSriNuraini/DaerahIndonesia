package com.example.daerahindonesia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DesaActivity extends AppCompatActivity {

    RecyclerView rvDesa;
    List<Desa>desaList;
    RecyclerView.LayoutManager layoutManager;
    ApiInterface apiInterface;
    DesaAdapter desaAdapter;
    SemuaDesa semuaDesa;
    String desa;
    DesaActivity desaActivity=DesaActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desa);
        rvDesa=(RecyclerView)findViewById(R.id.rv_desa);
        layoutManager=new LinearLayoutManager(this);
        rvDesa.setLayoutManager(layoutManager);

        Intent intent=getIntent();
        desa=intent.getStringExtra("desanya");
        ambilData();


    }

    private void ambilData() {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<SemuaDesa>call3=apiInterface.getDesa(desa);
        call3.enqueue(new Callback<SemuaDesa>() {
            @Override
            public void onResponse(Call<SemuaDesa> call, Response<SemuaDesa> response) {
                semuaDesa=response.body();
                desaList=semuaDesa.getDesas();
                desaAdapter=new DesaAdapter(desaList,desaActivity);
                rvDesa.setAdapter(desaAdapter);
            }

            @Override
            public void onFailure(Call<SemuaDesa> call, Throwable t) {

            }
        });
    }
}
