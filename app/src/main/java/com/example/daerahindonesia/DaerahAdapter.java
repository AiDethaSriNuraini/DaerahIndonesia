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

public class DaerahAdapter extends RecyclerView.Adapter<DaerahAdapter.DaerahHolder>{

    List<Daerah>daerahs;
    Activity activity;

    public DaerahAdapter(List<Daerah>daerahs,Activity activity){
        this.daerahs=daerahs;
        this.activity=activity;
    }

    @NonNull
    @Override
    public DaerahHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new DaerahHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaerahHolder holder, final int position) {
        holder.txtnama.setText(daerahs.get(position).getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id = daerahs.get(position).getId();
                Intent pindah = new Intent(activity,KabupatenActivity.class);
                pindah.putExtra("datanya",Id);
                v.getContext().startActivity(pindah);

            }
        });
    }

    @Override
    public int getItemCount() {
        return daerahs.size();
    }

    static class DaerahHolder extends RecyclerView.ViewHolder{

        TextView txtnama;

        public DaerahHolder(@NonNull View itemView) {
            super(itemView);

            txtnama=(TextView)itemView.findViewById(R.id.nama);


        }
    }
}
