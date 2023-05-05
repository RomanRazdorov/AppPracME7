package com.example.apppracme7.UI.StateHolder.Holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apppracme7.R;

public class MediaHolder extends RecyclerView.ViewHolder{
    public TextView textView;
    public ImageView imageView;

    public MediaHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
