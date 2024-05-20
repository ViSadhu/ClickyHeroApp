package com.example.clickyhero;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ComboAdapter extends RecyclerView.Adapter<ComboAdapter.comboViewHolder> {
    private final RecyclerViewClickListener recyclerViewClickListener;
    private final ArrayList<Combo> comboList;
    ArrowAdapter arrowAdapter;

    public ComboAdapter(ArrayList<Combo> comboList, RecyclerViewClickListener recyclerViewClickListener) {
        this.comboList = comboList;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @NonNull
    @Override
    public comboViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.combo_item, parent, false);
        return new comboViewHolder(view, recyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull comboViewHolder holder, int position) {
        holder.tvComboName.setText(comboList.get(position).getComboName());

        ArrayList<Integer> sequenceImages = comboList.get(position).getSequenceImages();

        this.arrowAdapter = new ArrowAdapter(sequenceImages);
        holder.rvArrows.setAdapter(arrowAdapter);

    }

    @Override
    public int getItemCount() {
        return comboList.size();
    }

    public static class comboViewHolder extends RecyclerView.ViewHolder {

        TextView tvComboName = itemView.findViewById(R.id.tvComboName);
        RecyclerView rvArrows = itemView.findViewById(R.id.rvArrows);

        public comboViewHolder(@NonNull View itemView, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                if (recyclerViewClickListener != null) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        recyclerViewClickListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
