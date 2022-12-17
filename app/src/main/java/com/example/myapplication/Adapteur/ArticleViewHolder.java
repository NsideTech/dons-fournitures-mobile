package com.example.myapplication.Adapteur;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;


public class ArticleViewHolder extends RecyclerView.ViewHolder {

    TextView NameView;
    TextView villelView;
    ImageView imageView;


    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);

        this.NameView = (TextView) itemView.findViewById(R.id.textView_Name);
        this.villelView = (TextView) itemView.findViewById(R.id.textView_ville);
        this.imageView = (ImageView) itemView.findViewById(R.id.imageItems);

    }
}
