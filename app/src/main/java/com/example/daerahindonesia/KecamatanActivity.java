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

public class KecamatanActivity extends AppCompatActivity {

    RecyclerView rvKecamatan;
    List<Kecamatan>kecamatanList;
    RecyclerView.LayoutManager layoutManager;
    KecamatanAdapter kecamatanAdapter;
    ApiInterface apiInterface;
    SemuaKecamatan semuaKecamatannya;
    String kec;
    KecamatanActivity kecamatanActivity=KecamatanActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kecamatan);

        rvKecamatan = (RecyclerView)findViewById(R.id.rv_kec_ac);
        layoutManager = new LinearLayoutManager(this);
        rvKecamatan.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        kec = intent.getStringExtra("kecamatannya");
        ambilData();
    }

    private void ambilData(){
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<SemuaKecamatan>call3=apiInterface.getkecamatan(kec);
        call3.enqueue(new Callback<SemuaKecamatan>() {
            @Override
            public void onResponse(Call<SemuaKecamatan> call, Response<SemuaKecamatan> response) {
                semuaKecamatannya=response.body();
                kecamatanList=semuaKecamatannya.getKecamatans();
                kecamatanAdapter = new KecamatanAdapter(kecamatanList,kecamatanActivity);
                rvKecamatan.setAdapter(kecamatanAdapter);
            }

            @Override
            public void onFailure(Call<SemuaKecamatan> call, Throwable t) {

            }
        });
    }
}
