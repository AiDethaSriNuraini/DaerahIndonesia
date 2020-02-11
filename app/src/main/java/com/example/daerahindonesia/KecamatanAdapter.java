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

public class KecamatanAdapter extends RecyclerView.Adapter<KecamatanAdapter.KecamatanHolder>{

    List<Kecamatan>kecamatans;
    Activity activity;

    public KecamatanAdapter(List<Kecamatan> kecamatans, Activity activity) {
        this.kecamatans = kecamatans;
        this.activity = activity;
    }

    @NonNull
    @Override
    public KecamatanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_kec,parent,false);
        return new KecamatanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KecamatanHolder holder, final int position) {
        holder.IDkec.setText(kecamatans.get(position).getId());
        holder.IDKab.setText(kecamatans.get(position).getId_kabupaten());
        holder.NamaKec.setText(kecamatans.get(position).getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idkec = kecamatans.get(position).getId();
                Intent move = new Intent(activity,DesaActivity.class);
                move.putExtra("desanya",idkec);
                v.getContext().startActivity(move);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kecamatans.size();
    }

    static class KecamatanHolder extends RecyclerView.ViewHolder{

        TextView IDkec, IDKab, NamaKec;

        public KecamatanHolder(@NonNull View itemView) {
            super(itemView);

            IDkec = (TextView)itemView.findViewById(R.id.id_kec_item);
            IDKab = (TextView)itemView.findViewById(R.id.id_kab);
            NamaKec = (TextView)itemView.findViewById(R.id.nama_kec_item);
        }
    }
}
