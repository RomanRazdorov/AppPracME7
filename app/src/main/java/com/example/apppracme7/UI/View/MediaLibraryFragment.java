package com.example.apppracme7.UI.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.apppracme7.Data.Source.Media;
import com.example.apppracme7.R;
import com.example.apppracme7.UI.View.Adapters.RecyclerViewAdapter;
import com.example.apppracme7.UI.ViewModel.ViewModel;

import java.util.ArrayList;
import java.util.List;


public class MediaLibraryFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_media_library, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
        ViewModel model = new ViewModelProvider(this).get(ViewModel.class);
        List<Media> mediaContent = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);


        RecyclerViewAdapter.MyOnItemClickListener listener = (media, position) -> {
            Log.i("RecyclerView", "Selected item " + position);
            Toast.makeText(getContext(), "Selected item " + position, Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();
            bundle.putString("Title", media.getTitle());
            bundle.putString("Artist", media.getArtistName());
            bundle.putInt("imageResource", media.getImageResourceId());
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        for (int i = 0; i < 10; i++) {
            mediaContent.add(new Media("Linkin park","NUM",  R.drawable.linkin_park));
        }
        model.addMedia("name", "titile", 0);
        model.getMediaUI().observe(this, mediaUI -> {
            mediaContent.add(mediaUI.getMedia());
        });

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mediaContent, listener);
        recyclerView.setAdapter(adapter);

    }
}