package com.example.daerahindonesia;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KabupatenAdapter extends RecyclerView.Adapter<KabupatenAdapter.KabupatenHolder> {

    List<Kabupaten> kabupatens;
    Activity activity;

    public KabupatenAdapter(List<Kabupaten>kabupatens,Activity activity){
        this.kabupatens = kabupatens;
        this.activity = activity;
    }
    @NonNull
    @Override
    public KabupatenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.rv_kab,parent,false);
        return new KabupatenHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KabupatenHolder holder, final int position) {

        holder.IdKabDetail.setText(kabupatens.get(position).getId());
        holder.NamaKab.setText(kabupatens.get(position).getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idkab = kabupatens.get(position).getId();
                Intent pindahkec = new Intent(activity,KecamatanActivity.class);
                pindahkec.putExtra("kecamatannya",idkab);
                v.getContext().startActivity(pindahkec);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kabupatens.size();
    }

    static class KabupatenHolder extends RecyclerView.ViewHolder{

        TextView IdKabDetail, IdProvDetail, NamaKab;

        public KabupatenHolder(@NonNull View itemView) {
            super(itemView);

            IdKabDetail=(TextView)itemView.findViewById(R.id.id_kab_item);
            NamaKab=(TextView)itemView.findViewById(R.id.nama_kab_item);
        }
    }
}
