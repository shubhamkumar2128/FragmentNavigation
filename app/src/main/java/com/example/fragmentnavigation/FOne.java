package com.example.fragmentnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FOne extends Fragment {

    View r;
    Button b;
    FragmentTran fragmentTran;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        r = inflater.inflate(R.layout.fone, container, false);

        return r;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        b = getActivity().findViewById(R.id.f1but);
        fragmentTran= (FragmentTran) getActivity();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTran.change(new FTwo(),"Fragment_two");
            }
        });
    }
}
