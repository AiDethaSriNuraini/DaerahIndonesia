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

public class KabupatenActivity extends AppCompatActivity {

    RecyclerView rvKab;
    List<Kabupaten>kabupatenList;
    RecyclerView.LayoutManager layoutManager;
    KabupatenAdapter kabupatenAdapter;
    ApiInterface apiInterface;
    SemuaKabupaten kabupatennya1;
    String a;
    KabupatenActivity kabupatenActivity=KabupatenActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabupaten);

        rvKab = (RecyclerView) findViewById(R.id.rv_kab);
        layoutManager = new LinearLayoutManager(this);
        rvKab.setLayoutManager(layoutManager);

        Intent intent = getIntent();
        a = intent.getStringExtra("datanya");
        ambilData();
    }

    private void ambilData() {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<SemuaKabupaten>call2=apiInterface.getkabupaten(a);
        call2.enqueue(new Callback<SemuaKabupaten>() {
            @Override
            public void onResponse(Call<SemuaKabupaten> call, Response<SemuaKabupaten> response) {
                kabupatennya1=response.body();
                kabupatenList=kabupatennya1.getKabupatens();
                kabupatenAdapter=new KabupatenAdapter(kabupatenList,kabupatenActivity);
                rvKab.setAdapter(kabupatenAdapter);

            }

            @Override
            public void onFailure(Call<SemuaKabupaten> call, Throwable t) {

            }
        });
    }





    }

