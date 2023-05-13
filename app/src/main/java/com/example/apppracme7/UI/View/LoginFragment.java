package com.example.apppracme7.UI.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.apppracme7.R;
import com.example.apppracme7.UI.StateHolder.ViewModels.MediaViewModel;
import com.example.apppracme7.UI.StateHolder.ViewModels.UserDataViewModel;


public class LoginFragment extends Fragment {

    private UserDataViewModel userDataViewModel;

    private EditText email;
    private EditText password;

    public LoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDataViewModel = new ViewModelProvider(requireActivity()).get(UserDataViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        email = (EditText) view.findViewById(R.id.etEmail);
        password = (EditText) view.findViewById(R.id.etPassword);
        Button btnLogin = (Button) view.findViewById(R.id.btnLogin);

        userDataViewModel.getUserDataLiveData().observe(getViewLifecycleOwner(), (value) -> {
            if (value != null) {
                    email.setText(value.getEmail());
                    password.setText(value.getPassword());
            }

        });

        btnLogin.setOnClickListener(vie -> {
            Bundle userData = new Bundle();
            userData.putString("Email", email.getText().toString());
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainPageFragment, userData);

        });
    }
}