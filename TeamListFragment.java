package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TeamListFragment extends Fragment {
    private RecyclerView recyclerView;
    private TeamAdapter adapter;
    private List<Team> fullList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fullList = GenericDataProvider.getDefaultTeams();
        adapter = new TeamAdapter(fullList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void search(String query) {
        List<Team> filtered = new GenericDataProvider<>(fullList).filterByName(query);
        adapter = new TeamAdapter(filtered);
        recyclerView.setAdapter(adapter);
    }
}