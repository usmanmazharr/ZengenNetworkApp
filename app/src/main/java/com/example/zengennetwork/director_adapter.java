package com.example.zengennetwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class director_adapter extends RecyclerView.Adapter<director_adapter.myviewholder>
{
    DirDatum []data;
    Context context;

    public director_adapter(DirDatum[] data, Context context)
    {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.director_design,parent,false);
        return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
         DirDatum datum=data[position];
         holder.tv.setText(datum.getBODName());
         holder.tv1.setText(datum.getBodTagline());
         Glide.with(holder.img.getContext()).load("https://zengen.network/images/"+datum.getBodPic()).into(holder.img);
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
