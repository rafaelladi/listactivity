package com.dietrich.controller;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dietrich.R;
import com.dietrich.adapter.AdapterTitles;
import com.dietrich.model.Club;

public class DetailActivity extends AppCompatActivity {
    private RecyclerView recyclerViewTitles;
    private Club club;
    private TextView name;
    private TextView city;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.textViewTeamName);
        city = findViewById(R.id.textViewTeamCity);
        image = findViewById(R.id.imageViewTeamEmblem);

        club = (Club) getIntent().getSerializableExtra("club");
        recyclerViewTitles = findViewById(R.id.recyclerViewTitles);

        name.setText(club.getName());
        city.setText(club.getCity());
        image.setImageResource(club.getEmblem());

        AdapterTitles adapter = new AdapterTitles(club.getTitles());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewTitles.setLayoutManager(layoutManager);
        recyclerViewTitles.setHasFixedSize(true);
        recyclerViewTitles.addItemDecoration(
                new DividerItemDecoration(this, LinearLayout.VERTICAL)
        );

        recyclerViewTitles.setAdapter(adapter);
    }
}