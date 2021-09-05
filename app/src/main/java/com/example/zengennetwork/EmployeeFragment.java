package com.example.zengennetwork;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zengennetwork.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EmployeeFragment extends Fragment {

    private static final String url="https://zengen.network/simple_Api/Employee.php";
    RecyclerView recview;
    public EmployeeFragment() {}


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_employee, container, false);
        recview=(RecyclerView) view.findViewById(R.id.emp_frag);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recview.setLayoutManager(gridLayoutManager);


        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                GsonBuilder gsonBuilder=new GsonBuilder();
                Gson gson=gsonBuilder.create();
                Datum[] data=gson.fromJson(response,Datum[].class);
                recview.setAdapter(new employee_adapter(data,getActivity().getApplicationContext()));
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