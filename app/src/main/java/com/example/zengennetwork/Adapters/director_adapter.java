package com.example.zengennetwork.Adapters;

import static com.example.zengennetwork.R.*;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zengennetwork.data.DirDatum;
import com.example.zengennetwork.R;

import org.w3c.dom.Text;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class director_adapter extends RecyclerView.Adapter<director_adapter.myviewholder>
{
    DirDatum[]data;
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
        View view=inflater.inflate(layout.director_design,parent,false);
        return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
         DirDatum datum=data[position];
         holder.tv.setText(datum.getBODName());
         holder.tv1.setText(datum.getBodTagline());
         holder.tv2.setText(datum.getBodQuote());
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
        TextView tv2;
       public myviewholder(@NonNull View itemView)
       {
           super(itemView);
           img=(ImageView)itemView.findViewById(id.imageholder);
           tv=(TextView)itemView.findViewById(id.theader);
           tv1=(TextView)itemView.findViewById(id.role);
           tv2 = (TextView) itemView.findViewById(id.quote);

           img.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {
                   showPopupWindow(v);
               }
           });

       }


       public void showPopupWindow(final View view)  {


           DirDatum datum = data[getLayoutPosition()];
           //Create a View object yourself through inflater
           LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);

           View popupView = inflater.inflate(layout.director_popup, null);

           //Specify the length and width through constants
           int width = LinearLayout.LayoutParams.MATCH_PARENT;
           int height = LinearLayout.LayoutParams.MATCH_PARENT;

           //Make Inactive Items Outside Of PopupWindow
           boolean focusable = true;

           //Create a window with our parameters
           final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
           popupWindow.setAnimationStyle(style.AnimationForPopup);
           popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);


           popupWindow.setBackgroundDrawable(null);
           popupWindow.showAsDropDown(view);

           View container = (View) popupWindow.getContentView().getParent();
           WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
           WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();
           p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
           p.dimAmount = 0.8f;
           wm.updateViewLayout(container, p);


           TextView test2 = popupView.findViewById(id.titleText);
           test2.setText(tv.getText());

           TextView test3 = popupView.findViewById(id.tagline);
           test3.setText("Tagline: " + tv1.getText());

           TextView test4 = popupView.findViewById(id.quote);
           test4.setText("Quote: " + tv2.getText() );

           Button buttonEdit = popupView.findViewById(id.messageButton);
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
