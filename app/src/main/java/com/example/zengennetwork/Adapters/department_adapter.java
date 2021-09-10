package com.example.zengennetwork.Adapters;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zengennetwork.data.DepDatum;
import com.example.zengennetwork.R;

public class department_adapter extends RecyclerView.Adapter<department_adapter.myviewholder>
{
    DepDatum[]data;
    Context context;


    public department_adapter(DepDatum[] data, Context context )
    {
        this.data = data;
        this.context = context;


    }



    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.department_design,parent,false);
        return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        DepDatum datum = data[position];
        holder.dep_name.setText(datum.getDeptName());
        holder.dep_members.setText("Members: "  + datum.getNoOfMembers());

        holder.name.setText("Deparment : " + datum.getDeptName());
        holder.member.setText("Members : " + datum.getNoOfMembers());
        holder.projects.setText("Project Assigned : " +datum.getProjectAssigned());
        holder.location.setText("Location : " +datum.getDeptLocation());

       
        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.expandable.getVisibility() == View.GONE)
                {
                    holder.show.setText("︿");
                    TransitionManager.beginDelayedTransition(holder.cardView , new AutoTransition());
                    holder.expandable.setVisibility(View.VISIBLE);
                }
                else
                {
                    holder.show.setText("﹀");
                    TransitionManager.beginDelayedTransition(holder.cardView , new AutoTransition());
                    holder.expandable.setVisibility(View.GONE);
                }
            }
        });

        //Glide.with(holder.img.getContext()).load("http://10.0.2.2/android_db_pool/images/"+datum.getImage()).into(holder.img);
    }



    @Override
    public int getItemCount() {
        return data.length;
    }



    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView dep_name;
        TextView dep_members;
        TextView name;
        TextView member;
        TextView projects;
        CardView cardView;
        TextView location;

        LinearLayout expandable;
        TextView show;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardview);

            dep_name=(TextView)itemView.findViewById(R.id.dep_name);
            dep_members=(TextView)itemView.findViewById(R.id.member_no);

            expandable = (LinearLayout) itemView.findViewById(R.id.expandable);
            show = (TextView) itemView.findViewById(R.id.showmore);

            name=(TextView) itemView.findViewById(R.id.exp_dep_name);
            member=(TextView)itemView.findViewById(R.id.exp_no_mem);
            projects = (TextView) itemView.findViewById(R.id.projects);
            location = (TextView) itemView.findViewById(R.id.Location);


        }
    }
}
