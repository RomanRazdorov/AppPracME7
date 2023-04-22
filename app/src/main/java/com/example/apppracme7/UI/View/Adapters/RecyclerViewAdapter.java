package com.example.apppracme7.UI.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apppracme7.Data.Source.Media;
import com.example.apppracme7.R;
import com.example.apppracme7.UI.View.Holders.MediaHolder;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MediaHolder> {
    private List<Media> media;

    public interface MyOnItemClickListener{
        void onClick(Media media, int position);
    }
    private final MyOnItemClickListener myOnItemClickListener;
    public RecyclerViewAdapter(List<Media> media, MyOnItemClickListener myOnItemClickListener) {
        this.media = media;
        this.myOnItemClickListener = myOnItemClickListener;
    }

    @NonNull
    @Override
    public MediaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.media_layout, parent, false);
        MediaHolder viewHolder = new MediaHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MediaHolder holder, int position) {
        Media media = this.media.get(position);
        holder.textView.setText(media.getArtistName());
        holder.imageView.setImageResource(media.getImageResourceId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnItemClickListener.onClick(media,holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return media.size();
    }
}
