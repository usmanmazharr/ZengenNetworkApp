package com.example.zengennetwork.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zengennetwork.data.Datum;
import com.example.zengennetwork.R;

public class employee_adapter extends RecyclerView.Adapter<employee_adapter.myviewholder>
{
    Datum[]data;
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
        TextView tv2;


        @SuppressLint("ResourceType")
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imageholder);
            tv=(TextView)itemView.findViewById(R.id.theader);
            tv1=(TextView)itemView.findViewById(R.id.role);
            img.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    showPopupWindow(v);
                }
            });

        }

        public void showPopupWindow(final View view)  {

            Datum datum=data[getLayoutPosition()];
            //Create a View object yourself through inflater
            LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.employee_popup, null);

            //Specify the length and width through constants
            int width = LinearLayout.LayoutParams.MATCH_PARENT;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;

            //Make Inactive Items Outside Of PopupWindow
            boolean focusable = true;


            //Create a window with our parameters
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
            popupWindow.setAnimationStyle(R.style.AnimationForPopup);
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);


            popupWindow.setBackgroundDrawable(null);
            popupWindow.showAsDropDown(view);


            View container = (View) popupWindow.getContentView().getParent();
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
            p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            p.dimAmount = 0.8f;
            wm.updateViewLayout(container, p);
            ImageView image = popupView.findViewById(R.id.imageView);
            Glide.with(img.getContext()).load("https://zengen.network/images/"+datum.getEmpPic()).into(image);

            TextView test2 = popupView.findViewById(R.id.titleText);
            test2.setText(tv.getText());

            TextView test3 = popupView.findViewById(R.id.tagline);
            test3.setText(tv1.getText());

            Button buttonEdit = popupView.findViewById(R.id.messageButton);
            buttonEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //As an example, display the message
                    Toast.makeText(view.getContext(), "Coming soon", Toast.LENGTH_SHORT).show();

                }
            });

            //Handler for clicking on the inactive zone of the window

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