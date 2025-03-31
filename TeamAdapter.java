package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private final List<Team> teams;

    public TeamAdapter(List<Team> teams) {
        this.teams = teams;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.name.setText(team.getName());
        holder.city.setText(team.getCity());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView name, city;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teamName);
            city = itemView.findViewById(R.id.teamCity);
        }
    }
}