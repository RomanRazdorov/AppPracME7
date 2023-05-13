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

import com.example.apppracme7.Data.Models.Media;
import com.example.apppracme7.R;
import com.example.apppracme7.UI.StateHolder.Adapters.RecyclerViewAdapter;
import com.example.apppracme7.UI.StateHolder.ViewModels.MediaViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MediaLibraryFragment extends Fragment {
    View view;
    MediaViewModel viewModel;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_media_library, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Media> mediaContent = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter.MyOnItemClickListener listener = (media, position) -> {
            Log.i("RecyclerView", "Selected item " + position);
            Toast.makeText(getContext(), "Selected item " + position, Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();
            bundle.putString("Title", media.getTitle());
            bundle.putString("Artist", media.getArtistName());
            bundle.putString("imageResource", media.getImageFilePath());
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mediaContent, listener);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel = new ViewModelProvider(this).get(MediaViewModel.class);
        viewModel.getMedia().observe(getViewLifecycleOwner(), (value) -> {
            ((RecyclerViewAdapter) Objects.requireNonNull(recyclerView.getAdapter())).updateData(value);
        });
    }
}