package com.divesh.rewardsconverter;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Home extends Fragment {
    Button Bd;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home,container,false);
        Bd = (Button) view.findViewById(R.id.paymentbutton);

        TextView txt = (TextView) view.findViewById(R.id.welcome);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Catamaran-Bold.ttf");
        txt.setTypeface(font);


        TextView txt1 = (TextView) view.findViewById(R.id.paymentbutton);
        Typeface fontb = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Raleway-Medium.ttf");
        txt1.setTypeface(fontb);

        TextView txt2 = (TextView) view.findViewById(R.id.bttext);
        Typeface fontc = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Raleway-Bold.ttf");
        txt2.setTypeface(fontc);


        Bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Information.class);
                startActivity(i);

            }
        });
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Rewards Converter");
    }
}
