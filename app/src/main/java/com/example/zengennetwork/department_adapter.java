package com.example.zengennetwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class department_adapter extends RecyclerView.Adapter<department_adapter.myviewholder>
{
    DepDatum []data;
    Context context;

    public department_adapter(DepDatum[] data, Context context)
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
         holder.tv.setText(datum.getDeptName());
         holder.tv1.setText("Members: "  + datum.getNoOfMembers());
        //Glide.with(holder.img.getContext()).load("http://10.0.2.2/android_db_pool/images/"+datum.getImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class myviewholder extends RecyclerView.ViewHolder
   {
        ImageView img;
        TextView tv;
        TextView tv1;
       public myviewholder(@NonNull View itemView)
       {
           super(itemView);
           tv=(TextView)itemView.findViewById(R.id.dep_name);
           tv1=(TextView)itemView.findViewById(R.id.member_no);
       }
   }
}
