package com.example.apppracme7.UI.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.apppracme7.R;
import com.example.apppracme7.UI.StateHolder.ViewModels.MediaViewModel;


public class AddMediaFragment extends Fragment {

    private EditText titleEditText;
    private EditText authorEditText;
    private Button addButton;
    private MediaViewModel mediaViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_media, container, false);

        titleEditText = view.findViewById(R.id.title_edit_text);
        authorEditText = view.findViewById(R.id.author_edit_text);
        addButton = view.findViewById(R.id.add_button);

        mediaViewModel = new ViewModelProvider(requireActivity()).get(MediaViewModel.class);

        addButton.setOnClickListener(v -> {
            String title = titleEditText.getText().toString();
            String author = authorEditText.getText().toString();

            String imageFilePath = "/path/to/image";
            mediaViewModel.insert(title, author, imageFilePath);

        });

        return view;
    }
}