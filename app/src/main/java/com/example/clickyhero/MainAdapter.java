package com.example.clickyhero;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.mainViewHolder> {
    private final ArrayList<String> data;
    public MainAdapter(ArrayList<String> data) { this.data = data; }
    @NonNull
    @Override
    public MainAdapter.mainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.mainViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class mainViewHolder extends RecyclerView.ViewHolder {
        public mainViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
