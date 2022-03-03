package com.dietrich.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dietrich.R;
import com.dietrich.model.Club;

import java.util.List;

public class AdapterClubs extends RecyclerView.Adapter<AdapterClubs.MyViewHolder> {
    private List<Club> clubList;

    public AdapterClubs(List<Club> clubList) {
        this.clubList = clubList;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_clubs, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Club club = clubList.get(position);
        holder.name.setText(club.getName());
        holder.city.setText(club.getCity());
        holder.image.setImageResource(club.getEmblem());
    }

    @Override
    public int getItemCount() {
        return clubList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, city;
        public ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            city = itemView.findViewById(R.id.textViewCity);
            image = itemView.findViewById(R.id.imageViewEmblem);
        }
    }


}
