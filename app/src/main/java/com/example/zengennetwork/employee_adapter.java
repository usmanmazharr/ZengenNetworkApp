package com.example.zengennetwork;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class employee_adapter extends RecyclerView.Adapter<employee_adapter.myviewholder>
{
    public ProgressBar progressBar;
    Datum []data;
    Context context;

    public employee_adapter(Datum[] data, Context context)
    {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.employee_design,parent,false);
        return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
         Datum datum=data[position];
         holder.tv.setText(datum.getEmpName());
         holder.tv1.setText(datum.getDesignation());
         Glide.with(holder.img.getContext()).load("https://zengen.network/images/"+datum.getEmpPic()).into(holder.img);
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
           img=(ImageView)itemView.findViewById(R.id.imageholder);
           tv=(TextView)itemView.findViewById(R.id.theader);
           tv1=(TextView)itemView.findViewById(R.id.role);

       }

   }

}
