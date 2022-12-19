package com.example.myapplication.Adapteur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.fragment.Accueil;
import com.example.myapplication.fragment.Detail;
import com.example.myapplication.model.Recherche;
import com.example.myapplication.model.RechercheInterface;

import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<ArticleViewHolder>{

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
        // Inflater la vue de recyclerview_item_layout.xml
        View recyclerViewItem = mLayoutInflater.inflate(R.layout.recycleview_item_layout, parent, false);

        recyclerViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRecyclerItemClick( (RecyclerView)parent, v);
            }
        });
        return new ArticleViewHolder(recyclerViewItem);
    }

    // Gérer le clic sur un RecyclerView Item.
    private void handleRecyclerItemClick(RecyclerView recyclerView, View itemView) {
        int itemPosition = recyclerView.getChildLayoutPosition(itemView);
        Recherche recherche  = this.recherches.get(itemPosition);

        if(!this.recherches.isEmpty()){
            ((RechercheInterface) context).saveInformation(recherche);
            ((RechercheInterface) context).saveInt(itemPosition);
            //Intent intent = new Intent(context, Detail.class);
            //context.startActivity(intent);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        // Récupérer un fruit de fruits via sa position
        Recherche recherches = this.recherches.get(position);

        // Envoyer les données au viewholder
        holder.NameView.setText(recherches.getNom());
        holder.villelView.setText(recherches.getPays());
        holder.imageView.setImageResource(R.drawable.books);
    }



    @Override
    public int getItemCount() {
        return this.recherches.size();
    }
}

