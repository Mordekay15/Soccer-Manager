package com.example.week11.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week11.R;
import com.example.week11.model.Match;
import com.example.week11.model.Player;
import com.example.week11.model.SoccerEntity;
import com.example.week11.model.Team;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryViewHolder> {
    private List<SoccerEntity> entities;
    private Context context;
    private OnItemClickListener listener;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public interface OnItemClickListener{
        void onItemClick(SoccerEntity entity, int position);
    }
    public RepositoryAdapter(Context context, List<SoccerEntity> entities, OnItemClickListener listener) {
        this.context = context;
        this.entities = entities;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.soccer_item, parent, false);
        return new RepositoryViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        SoccerEntity entity = entities.get(position);
        if (entity instanceof Match) {
            holder.t_name.setText(((Match) entity).getHomeTeam() + " - " + ((Match) entity).getAwayTeam());
            holder.t_category.setText("Match");
            holder.t_info.setText(((Match) entity).getScore());
            holder.t_more_info.setText(((Match) entity).getDate().format(formatter));

        }
        if (entity instanceof Player) {
            holder.t_name.setText(entity.getName());
            holder.t_category.setText("Player");
            holder.t_info.setText(((Player) entity).getTeam());
            holder.t_more_info.setText(((Player) entity).getPosition());

        }
        if (entity instanceof Team) {
            holder.t_name.setText(entity.getName());
            holder.t_category.setText("Team");
            holder.t_info.setText("League: " + ((Team) entity).getLeague());
            holder.t_more_info.setText(((Team) entity).getCountry());
        }
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(entity, holder.getAdapterPosition());
            }
        });

    }

    public void updateItems(List<SoccerEntity> newEntities) {
        this.entities = newEntities;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return entities.size();
    }
}
