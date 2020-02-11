package com.example.daerahindonesia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DesaAdapter extends RecyclerView.Adapter<DesaAdapter.DesaHolder> {

    List<Desa> desas;
    Activity activity;

    public DesaAdapter(List<Desa> desas, Activity activity) {
        this.desas = desas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DesaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_desa, parent, false);
        return new DesaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DesaHolder holder, int position) {

        holder.txtiddesa.setText(desas.get(position).getId());
        holder.txtidkecamatan.setText(desas.get(position).getId_kecamatan());
        holder.txtnamadesa.setText(desas.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        return desas.size();
    }

    static class DesaHolder extends RecyclerView.ViewHolder{

        TextView txtiddesa,txtidkecamatan,txtnamadesa;

        public DesaHolder(@NonNull View itemView) {
            super(itemView);

            txtiddesa=(TextView)itemView.findViewById(R.id.id_desa);
            txtidkecamatan=(TextView)itemView.findViewById(R.id.id_kec);
            txtnamadesa=(TextView)itemView.findViewById(R.id.nama_desa);
        }
    }
}
