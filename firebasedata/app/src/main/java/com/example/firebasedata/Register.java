package com.example.firebasedata;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register extends Fragment {
  EditText edt_remail,edt_rname,edt_rpass,edt_cpass;
  Button btn_reg;
  private FirebaseAuth fauth;


    public Register() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fauth = FirebaseAuth.getInstance();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edt_remail = view.findViewById(R.id.edit_reemail);
        edt_rname = view.findViewById(R.id.edit_name);
        edt_rpass= view.findViewById(R.id.edit_password);
        edt_cpass = view.findViewById(R.id.edit_confirmpassword);
        btn_reg=view.findViewById(R.id.button);
btn_reg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(!checkEmptyFields())
        {
            if(edt_rpass.getText().length()<6)
            {
                edt_rpass.setError("invalid password,passwordshould be at least ");
                edt_rpass.requestFocus();
            }else
            {
                if(edt_rpass.getText().toString().equals(edt_cpass.getText().toString()))
                {
                    edt_cpass.setError("password not match");
                    edt_cpass.requestFocus();
                }else{
                    String email=edt_remail.getText().toString();
                    String pass=edt_rpass.getText().toString();

                    String name=edt_rname.getText().toString();

                    createUser(email,pass,name);
                }
            }
        }
    }
});
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_register, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        }
        public boolean checkEmptyFields() {
            if (TextUtils.isEmpty(edt_remail.getText().toString())) {
                edt_remail.setError("email can not be blank");
                edt_remail.requestFocus();
                return true;
            } else if (TextUtils.isEmpty(edt_rname.getText().toString())) {
                edt_rname.setError("name can not be blank");
                edt_rname.requestFocus();
                return true;

            } else if (TextUtils.isEmpty(edt_rpass.getText().toString())) {
                edt_rpass.setError("password can not be blank");
                edt_rpass.requestFocus();
                return true;

            } else if (TextUtils.isEmpty(edt_cpass.getText().toString())) {
                edt_cpass.setError("password can not be blank");
                edt_cpass.requestFocus();
                return true;
            }

        return false;

    }
    public void createUser(String email,String pass,String name)
    {
        fauth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getActivity().getApplicationContext(),"registration",Toast.LENGTH_LONG).show();
                            FirebaseAuth.getInstance().signOut();
                    NavController navController= Navigation.findNavController(getActivity(),R.id.host_frag);
                    navController.navigate(R.id.login);
                }
            }
        }).addOnFailureListener(getActivity(), new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }
}
