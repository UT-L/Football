package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText searchBar;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.searchBar);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        TeamListFragment teamFragment = new TeamListFragment();
        PlayerListFragment playerFragment = new PlayerListFragment();
        MatchListFragment matchFragment = new MatchListFragment();

        adapter.addFragment(teamFragment, "Teams");
        adapter.addFragment(playerFragment, "Players");
        adapter.addFragment(matchFragment, "Matches");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString();
                int currentTab = tabLayout.getSelectedTabPosition();
                if (currentTab == 0) teamFragment.search(query);
                else if (currentTab == 1) playerFragment.search(query);
                else if (currentTab == 2) matchFragment.search(query);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}