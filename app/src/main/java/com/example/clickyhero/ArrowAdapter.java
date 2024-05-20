package com.example.clickyhero;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArrowAdapter extends RecyclerView.Adapter<ArrowAdapter.ArrowViewHolder> {

    private ArrayList<Integer> sequenceImages;

    public ArrowAdapter(ArrayList<Integer> sequenceImages) {
        this.sequenceImages = sequenceImages;
    }
    @NonNull
    @Override
    public ArrowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.arrows_item, parent, false);
        return new ArrowAdapter.ArrowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArrowViewHolder holder, int position) {
        holder.ivArrow.setImageResource(sequenceImages.get(position));
    }

    @Override
    public int getItemCount() {
        return sequenceImages.size();
    }
    public static class ArrowViewHolder extends RecyclerView.ViewHolder {
        ImageView ivArrow = itemView.findViewById(R.id.ivArrow);
        public ArrowViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
