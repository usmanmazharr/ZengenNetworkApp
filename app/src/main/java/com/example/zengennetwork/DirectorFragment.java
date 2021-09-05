package com.example.zengennetwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DirectorFragment extends Fragment {
    private static final String url="https://zengen.network/simple_Api/BoardOfDirector.php";
    RecyclerView recview;

    public DirectorFragment() {}


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_director, container, false);
        recview=(RecyclerView) view.findViewById(R.id.dir_frag);
        recview.setLayoutManager(new LinearLayoutManager(getActivity()));


          GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
            //recview.setLayoutManager(gridLayoutManager);
        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson=gsonBuilder.create();
                DirDatum[] data=gson.fromJson(response,DirDatum[].class);
                recview.setAdapter(new director_adapter(data,getActivity().getApplicationContext()));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        RequestQueue queue= Volley.newRequestQueue(getActivity());
        queue.add(request);
        return view;

    }

}