package com.dietrich.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dietrich.R;
import com.dietrich.adapter.AdapterClubs;
import com.dietrich.model.Club;
import com.dietrich.model.Title;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewClubs;
    private List<Club> clubList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewClubs = findViewById(R.id.recyclerViewClubs);

        this.createClubs();

        AdapterClubs adapter = new AdapterClubs(clubList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewClubs.setLayoutManager(layoutManager);

        recyclerViewClubs.setHasFixedSize(true);

        recyclerViewClubs.addItemDecoration(
                new DividerItemDecoration(this, LinearLayout.VERTICAL)
        );

        recyclerViewClubs.setAdapter(adapter);
        MainActivity that = this;

        recyclerViewClubs.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewClubs,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Club club = clubList.get(position);
                                Intent intent = new Intent(that, DetailActivity.class);
                                intent.putExtra("club", club);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    private void createClubs() {
        List<Title> titles = Arrays.asList(
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021),
                new Title("titulo 1", 2021)
        );
        Club club = new Club(R.drawable.corinthians, "Corinthians", "São Paulo - SP", titles);
        clubList.add(club);
        titles = Arrays.asList(new Title("titulo 3", 2012), new Title("titulo 4", 2015));
        club = new Club(R.drawable.flamengo, "Flamengo", "Rio de janeiro - RJ", titles);
        clubList.add(club);
        titles = Arrays.asList(new Title("titulo 5", 2018), new Title("titulo 6", 2022));
        club = new Club(R.drawable.botafogo, "Botafogo", "Rio de Janeiro - RJ", titles);
        clubList.add(club);
    }
}