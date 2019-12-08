package com.example.firebase;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    EditText emailId,password;
    TextView register;
    Button login;

    public LoginFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailId =view.findViewById(R.id.emailId);
        password = view.findViewById(R.id.password);
        register = view.findViewById(R.id.text_register);
        login = view.findViewById(R.id.login);

        register.setOnClickListener(this);
        login.setOnClickListener(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id==R.id.login){

            if (TextUtils.isEmpty(emailId.getText().toString())){
                emailId.setError("Email cannot be empty!");
                emailId.requestFocus();
            }
            else if (TextUtils.isEmpty(password.getText().toString())){
                password.setError("Password cannot be empty!");
                password.requestFocus();
            }
            else {
                String email = emailId.getText().toString();
                String Password = password.getText().toString();

                loginUser(email,Password);
            }
        }

        else if (id==R.id.text_register){
            NavController navController = Navigation.findNavController(getActivity(),R.id.hostfragment);
            navController.navigate(R.id.registerFragment);


        }

    }

    @Override
    public void onStart() {
        super.onStart();

        firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser!=null){
            Toast.makeText(getActivity().getApplicationContext(),"User Already Signing",Toast.LENGTH_LONG).show();
        }
    }

    public void loginUser(String email, String password){

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            firebaseUser = firebaseAuth.getCurrentUser();
                            Toast.makeText(getActivity().getApplicationContext(),"Login successfull",Toast.LENGTH_LONG).show();
                        }





                    }
                }).addOnFailureListener(getActivity(), new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
             Toast.makeText(getActivity().getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}

