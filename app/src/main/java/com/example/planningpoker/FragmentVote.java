package com.example.planningpoker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class FragmentVote extends Fragment {


    TextView tv_vote, tv_task, tv_score;
    Button submit_btn;
    DatabaseHelper myDb;
    private ArrayList<String> mRatingTasks = new ArrayList<>();
    private ArrayList<Integer> mVote = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Context context = getActivity();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_vote, container, false);

        tv_task = v.findViewById(R.id.tv_task);
        tv_score = v.findViewById(R.id.tv_score);
        submit_btn = v.findViewById(R.id.submit_btn);

        myDb = new DatabaseHelper(context);

        initNames(inflater, container, context);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new FragmentResult();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_id, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        return v;
    }

    private void initNames(LayoutInflater inflater, ViewGroup container, Context context){


        Cursor res = myDb.getRatingTasks();
        if(res.getCount() == 0) {
            // show message
            Toast.makeText(context, "No list items!", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("Task :"+ res.getString(1)+"\n");
            buffer.append("Vote :"+ res.getInt(2)+"\n");
            mRatingTasks.add(res.getString(0));
            mVote.add(res.getInt(1));
        }
        initRecyclerView(inflater, container);
    }


    final Context context = getActivity();

    private void initRecyclerView(LayoutInflater inflater,ViewGroup container){


        View v = inflater.inflate(R.layout.fragment_fragment_vote, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context, mRatingTasks, mVote);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

}