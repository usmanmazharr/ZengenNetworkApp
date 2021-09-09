package com.example.zengennetwork;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.zengennetwork.Fragments.DepartmentFragment;
import com.example.zengennetwork.Fragments.DirectorFragment;
import com.example.zengennetwork.Fragments.EmployeeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



      //  requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);


        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#6A287E")));
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame , new EmployeeFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.employee:
                        replace(new EmployeeFragment());
                        break;

                    case R.id.department:
                        replace(new DepartmentFragment());
                        break;
                    case R.id.director:
                        replace(new DirectorFragment());
                        break;
                }
                return true;
            }
        });
    }



    private void replace(Fragment frag) {
        FragmentTransaction fragtrans = getSupportFragmentManager().beginTransaction();
        fragtrans.replace(R.id.frame , frag);
        fragtrans.commit();
    }


}