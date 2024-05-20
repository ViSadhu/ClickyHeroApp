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

        holder.ivArrow0.setImageResource(getImgResource(comboList.get(position).getSequence(), 0));
        holder.ivArrow1.setImageResource(getImgResource(comboList.get(position).getSequence(), 1));
        holder.ivArrow2.setImageResource(getImgResource(comboList.get(position).getSequence(), 2));
        holder.ivArrow3.setImageResource(getImgResource(comboList.get(position).getSequence(), 3));
        holder.ivArrow4.setImageResource(getImgResource(comboList.get(position).getSequence(), 4));
        holder.ivArrow5.setImageResource(getImgResource(comboList.get(position).getSequence(), 5));
        holder.ivArrow6.setImageResource(getImgResource(comboList.get(position).getSequence(), 6));
        holder.ivArrow7.setImageResource(getImgResource(comboList.get(position).getSequence(), 7));
    }

    @Override
    public int getItemCount() {
        return comboList.size();
    }

    public static int getImgResource(String sequence, int position) {
        if (position <= sequence.length() - 1) {
            switch (sequence.charAt(position)) {
                case 'U':
                    return R.drawable.up;
                case 'D':
                    return R.drawable.down;
                case 'L':
                    return R.drawable.left;
                case 'R':
                    return R.drawable.right;
                default:
                    return 0;
            }
        }
        return 0;
    }

    public static class comboViewHolder extends RecyclerView.ViewHolder {

        TextView tvComboName = itemView.findViewById(R.id.tvComboName);
        ImageView ivArrow0 = itemView.findViewById(R.id.ivArrow0);
        ImageView ivArrow1 = itemView.findViewById(R.id.ivArrow1);
        ImageView ivArrow2 = itemView.findViewById(R.id.ivArrow2);
        ImageView ivArrow3 = itemView.findViewById(R.id.ivArrow3);
        ImageView ivArrow4 = itemView.findViewById(R.id.ivArrow4);
        ImageView ivArrow5 = itemView.findViewById(R.id.ivArrow5);
        ImageView ivArrow6 = itemView.findViewById(R.id.ivArrow6);
        ImageView ivArrow7 = itemView.findViewById(R.id.ivArrow7);

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
