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
import android.widget.Toast;


public class FragmentLogin extends Fragment {

    EditText et_name;
    EditText et_pwd;
    Button button ;
    DatabaseHelper myDb;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        et_name = getView().findViewById(R.id.et_name);
        et_pwd = getView().findViewById(R.id.et_pwd);
        button = getView().findViewById(R.id.button);
        return inflater.inflate(R.layout.fragment_fragment_login, container, false);


    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getActivity();
        myDb = new DatabaseHelper(context);

        button = getActivity().findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                long dev_id= myDb.insertDeveloper(et_name.getText().toString());
                if (dev_id != 0) {
                    Toast.makeText(context, "Data Inserted", Toast.LENGTH_LONG).show();
                    et_name.getText().clear();

                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_id, new FragmentVote());
                    transaction.commit();
                }
                else
                    Toast.makeText(context, "Data not Inserted", Toast.LENGTH_LONG).show();


            }
        });

    }
}

