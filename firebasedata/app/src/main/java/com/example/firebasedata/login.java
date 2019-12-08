package com.example.firebasedata;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class login extends Fragment {

   private FirebaseAuth fAutth;
   FirebaseUser curUser;

   EditText edt_email,edt_pass;
   TextView txt_reg;
   Button btn_log;
    public login() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fAutth=FirebaseAuth.getInstance();}
        @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState)
        {

        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View,@NonNull Bundle_)
        super



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }



    }
