package com.example.apppracme7.UI.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apppracme7.R;


public class MainPageFragment extends Fragment {
    final public static String TAG = MainPageFragment.class.getSimpleName();

    public MainPageFragment() {

    }

    public static MainPageFragment newInstance() {
        return new MainPageFragment();
    }


    private TextView Nick;
    private TextView Names;
    private TextView Surnames;
    private TextView Emails;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Nick = (TextView) view.findViewById(R.id.getNick);
        Names = (TextView) view.findViewById(R.id.getName);
        Surnames = (TextView) view.findViewById(R.id.getSurname);
        Emails = (TextView) view.findViewById(R.id.getEmail);

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            Nick.setText(bundle.getString("Nickname"));
            Names.setText(bundle.getString("FName"));
            Surnames.setText(bundle.getString("SName"));
            Emails.setText(bundle.getString("Email"));
        }

    }

}