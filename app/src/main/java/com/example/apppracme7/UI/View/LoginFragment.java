package com.example.apppracme7.UI.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.apppracme7.R;
import com.example.apppracme7.UI.StateHolder.ViewModels.ViewModel;


public class LoginFragment extends Fragment {

    public LoginFragment(){
    }
    EditText email;
    EditText password;

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
        Button btnReg = (Button) view.findViewById(R.id.btnLogin);

        btnReg.setOnClickListener(vie -> {
            Bundle userData = new Bundle();
            userData.putString("Email", email.getText().toString());
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_mainPageFragment,userData);

        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel userViewModel = new ViewModelProvider(this).get(ViewModel.class);


    }
}