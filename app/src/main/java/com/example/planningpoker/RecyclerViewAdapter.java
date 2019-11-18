package com.example.planningpoker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mTaskNames;
    private ArrayList<Integer> mVote;

    private Context mContext;


    public RecyclerViewAdapter(Context context, ArrayList<String> TaskNames ,ArrayList<Integer> VoteName ) {
        mTaskNames = TaskNames;
        mVote = VoteName;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.tv_item.setText(mTaskNames.get(position));
        holder.numberPicker.setValue(mVote.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mTaskNames.get(position));
                Log.d(TAG, "onClick: clicked on: " + mVote.get(position));

                Toast.makeText(mContext, mTaskNames.get(position), Toast.LENGTH_SHORT).show();
                Toast.makeText(mContext, mVote.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTaskNames.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_item;
        NumberPicker numberPicker;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_item = itemView.findViewById(R.id.tv_item);
            numberPicker = itemView.findViewById(R.id.numberPicker);
            parentLayout = itemView.findViewById(R.id.linear_id);
        }
    }


}
