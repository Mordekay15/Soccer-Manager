package com.example.week11.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week11.R;

public class RepositoryViewHolder extends RecyclerView.ViewHolder  {
    TextView t_name, t_category, t_info, t_more_info;
    public RepositoryViewHolder(@NonNull View itemView) {
        super(itemView);
        t_name = itemView.findViewById(R.id.name);
        t_category = itemView.findViewById(R.id.category);
        t_info = itemView.findViewById(R.id.info);
        t_more_info = itemView.findViewById(R.id.more_info);
    }
}
