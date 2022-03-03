package com.dietrich.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dietrich.R;
import com.dietrich.model.Title;

import java.util.List;

public class AdapterTitles extends RecyclerView.Adapter<AdapterTitles.MyViewHolder> {
    private List<Title> titleList;

    public AdapterTitles(List<Title> titleList) {
        this.titleList = titleList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_titles, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Title title = titleList.get(position);
        holder.name.setText(title.getName());
        holder.year.setText(title.getYear().toString());
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, year;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            year = itemView.findViewById(R.id.textViewYear);
        }
    }

    public List<Title> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }
}
