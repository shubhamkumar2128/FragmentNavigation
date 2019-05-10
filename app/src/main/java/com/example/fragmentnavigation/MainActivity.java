package com.example.fragmentnavigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity implements FragmentTran {
    Fragment fragment;
    FragmentManager fragmentManager;
    //FragmentTransaction fragmentTransaction;
    Toolbar toolbar;
    Button btn;
    private String currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.click);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new FOne();
                toolbar.setTitle("Fragment one");

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framecontainer, fragment, "Fragment_one");
                fragmentTransaction.addToBackStack("Fragment_one");
                fragmentTransaction.commit();
            }
        });

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                List<Fragment> f = fragmentManager.getFragments();
                Fragment frag = f.get(0);
                currentFragment = frag.getClass().getSimpleName();

                Toast.makeText(MainActivity.this, currentFragment, Toast.LENGTH_SHORT).show();
                show(currentFragment);
            }
        });
    }

    private void show(String currentFragment) {

        switch (currentFragment) {
            case "FOne":
                toolbar.setTitle(currentFragment);
                return;
            case "FTwo":
                toolbar.setTitle(currentFragment);
                return;
            case "FThree":
                toolbar.setTitle(currentFragment);
        }
    }


    @Override
    public void change(Fragment fragment, String text) {
        this.fragment = fragment;
        toolbar.setTitle(text);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framecontainer, fragment);
        fragmentTransaction.addToBackStack(text);
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        switch (currentFragment) {
            case "FOned":
                toolbar.setTitle(currentFragment);
                return;
            case "FTwod":
                toolbar.setTitle(currentFragment);
                return;
            case "FThreed":
                toolbar.setTitle(currentFragment);
                return;
            default:
                fragmentManager.popBackStack();

        }
    }
}



