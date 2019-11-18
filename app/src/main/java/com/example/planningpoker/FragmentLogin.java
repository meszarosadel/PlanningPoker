package com.example.planningpoker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentLogin extends Fragment {

    EditText et_name;
    EditText et_pwd;
    Button button;
    TextView tv_login;

    DatabaseHelper myDb;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_login, container, false);
        // Inflate the layout for this fragment
        et_name = v.findViewById(R.id.et_name);
        et_pwd = v.findViewById(R.id.et_pwd);
        button = v.findViewById(R.id.button);

        final Context context = getActivity();
        myDb = new DatabaseHelper(context);


        button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        long dev = myDb.insertDeveloper(et_name.getText().toString(), et_pwd.getText().toString());

                        if (dev != 0) {
                            Toast.makeText(context, "Data Inserted", Toast.LENGTH_LONG).show();
                            et_name.getText().clear();
                            et_pwd.getText().clear();


                            Fragment fragment = new FragmentVote();
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frame_id, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();


                        }

                        else
                            Toast.makeText(context, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                });
        return v;
    }


}

