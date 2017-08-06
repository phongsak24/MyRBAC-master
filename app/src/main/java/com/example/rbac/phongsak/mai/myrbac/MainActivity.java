package com.example.rbac.phongsak.mai.myrbac;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rbac.phongsak.mai.myrbac.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.mainContainer, mainFragment)
                    .commit();
        }
        //add Fragment
    } //Main Method
}// Main Class
