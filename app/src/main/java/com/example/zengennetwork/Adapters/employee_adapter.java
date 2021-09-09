package com.example.zengennetwork.Adapters;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zengennetwork.data.Datum;
import com.example.zengennetwork.R;

public class employee_adapter extends RecyclerView.Adapter<employee_adapter.myviewholder>
{
    Datum[]data;
    Context context;
    String name;
    public employee_adapter(Datum[] data,  Context context)
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

        TextView address;

        public ImageView getImg() {
            return img;
        }

        public void setImg(ImageView img) {
            this.img = img;
        }

        public TextView getAddress() {
            return address;
        }

        public void setAddress(TextView address) {
            this.address = address;
        }

        public TextView getTv() {
            return tv;
        }

        public void setTv(TextView tv) {
            this.tv = tv;
        }

        public TextView getTv1() {
            return tv1;
        }

        public void setTv1(TextView tv1) {
            this.tv1 = tv1;
        }

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageholder);
            tv=(TextView)itemView.findViewById(R.id.theader);
            tv1=(TextView)itemView.findViewById(R.id.role);
          //  address = (TextView) itemView.findViewById(R.id.pop_address);

            img.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    showPopupWindow(v);

                }
            });

        }

        public void showPopupWindow(final View view) {

            LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.employee_popup, null);
            int width = LinearLayout.LayoutParams.MATCH_PARENT;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;

            //Make Inactive Items Outside Of PopupWindow
            boolean focusable = true;

            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            ImageView imageView = popupView.findViewById(R.id.pop_image);
            imageView.setVisibility(View.VISIBLE);

            TextView name = popupView.findViewById(R.id.pop_name);
            name.setText(tv.getText());

            TextView role = popupView.findViewById(R.id.pop_role);
            role.setText("Designation: " + tv1.getText());

            TextView address = popupView.findViewById(R.id.pop_address);
            address.setText("Address: " + address.getText());

            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    //Close the window when clicked
                    popupWindow.dismiss();
                    return true;
                }
            });
        }
    }


}