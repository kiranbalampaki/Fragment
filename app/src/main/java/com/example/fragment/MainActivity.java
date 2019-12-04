package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.fragment.fragments.FirstFragment;
import com.example.fragment.fragments.SecondFragment;
import com.example.fragment.fragments.SumFragment;

public class MainActivity extends AppCompatActivity {
    private Button btnFragment;
    private Boolean status = true;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment = findViewById(R.id.btnFragment);

        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (status){
                    FirstFragment firstFragment = new FirstFragment();
                    fragmentTransaction.replace(R.id.fragmentContainer, firstFragment);
                    fragmentTransaction.commit();
                    btnFragment.setText("Load Second Fragment");
                    status = false;
                }
                else {
                    SumFragment sumFragment = new SumFragment();
                    fragmentTransaction.replace(R.id.fragmentContainer, sumFragment);
                    fragmentTransaction.commit();
                    btnFragment.setText("Load First Fragment");
                    status = true;
                }
            }
        });
    }
}
