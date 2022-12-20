package com.example.myapplication.Adapteur;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Recherche;

import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private List<Recherche> recherches;
    private Context context;
    private LayoutInflater mLayoutInflater;


    public CustomRecyclerViewAdapter(List<Recherche> recherches, Context context) {
        this.context = context;
        this.recherches = recherches;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View recyclerViewItem = mLayoutInflater.inflate(R.layout.recycleview_item_layout, parent, false);

        recyclerViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRecyclerItemClick((RecyclerView) parent, v);
            }
        });
        return new ArticleViewHolder(recyclerViewItem);
    }

    private void handleRecyclerItemClick(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        Recherche recherche = this.recherches.get(itemPosition);

        if (!this.recherches.isEmpty()) {

            Intent intent = new Intent(context, DetailActivity.class);
            Long id = recherche.getId();
            String nom = recherche.getNom();
            String phone = recherche.getPhone();
            String email = recherche.getEmail();
            String pays = recherche.getPays();
            String description = recherche.getDescription();
            intent.putExtra("id", id);
            intent.putExtra("nom", nom);
            intent.putExtra("phone", phone);
            intent.putExtra("email", email);
            intent.putExtra("pays", pays);
            intent.putExtra("description", description);

            context.startActivity(intent);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {

        Recherche recherches = this.recherches.get(position);


        holder.NameView.setText(recherches.getNom());
        holder.villelView.setText(recherches.getPays());
        holder.imageView.setImageResource(R.drawable.books);
    }


    @Override
    public int getItemCount() {
        return this.recherches.size();
    }
}

