package com.example.apppracme7.UI.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apppracme7.R;
import com.example.apppracme7.UI.StateHolder.ViewModels.UserDataViewModel;


public class RegisterFragment extends Fragment {

    final public static String TAG = RegisterFragment.class.getSimpleName();

    public RegisterFragment() {

    }

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    private UserDataViewModel userDataViewModel;

    private EditText nickname;
    private EditText fname;
    private EditText sname;
    private EditText email;
    private TextView logIn;
    private EditText password;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDataViewModel = new ViewModelProvider(requireActivity()).get(UserDataViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nickname = (EditText) view.findViewById(R.id.nickname);
        fname = (EditText) view.findViewById(R.id.name);
        sname = (EditText) view.findViewById(R.id.surname);
        email = (EditText) view.findViewById(R.id.email);
        logIn = (TextView) view.findViewById(R.id.logNow);
        password = (EditText) view.findViewById(R.id.etPassword);

        TextView loadTitle = (TextView) view.findViewById(R.id.regscrn);
        loadTitle.setText(R.string.title);
        ImageView loadPicture = (ImageView) view.findViewById(R.id.catgif);
        loadPicture.setImageResource(R.drawable.catgif);
        Button btnReg = (Button) view.findViewById(R.id.btnreg);


        btnReg.setOnClickListener(vie -> {
            String sNickname = nickname.getText().toString();
            String fName = fname.getText().toString();
            String sName = sname.getText().toString();
            String sEmail = email.getText().toString();
            String sPassword = password.getText().toString();

            userDataViewModel.saveUserData(sNickname, fName, sName, sEmail, sPassword);

            Bundle userData = new Bundle();
            userData.putString("Nickname", sNickname);
            userData.putString("FName", fName);
            userData.putString("SName", sName);
            userData.putString("Email", sEmail);

            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_mainPageFragment, userData);
        });

        logIn.setOnClickListener(vie -> {
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment);
        });
    }
}