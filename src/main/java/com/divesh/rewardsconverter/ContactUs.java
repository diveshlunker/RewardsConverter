package com.divesh.rewardsconverter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import com.divesh.rewardsconverter.R;
import com.firebase.client.Firebase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ContactUs extends Fragment {

    Button Bd;
    public AdView mAdView;
    TextView msubmission;
    EditText mname;
    EditText memail;
    EditText mquery;
    ImageView insta;
    ImageView whatsapp;
    private Firebase mRootRef;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.contact_us, container, false);

        mAdView = (AdView)view.findViewById(R.id.adview3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Random r = new Random();
        int random = r.nextInt(2);


        mRootRef = new Firebase("https://rewards-converter-6b2a1.firebaseio.com/query/");

        mname = (EditText) view.findViewById(R.id.namef);
        memail = (EditText) view.findViewById(R.id.emailf);
        mquery = (EditText) view.findViewById(R.id.query);
        Bd = (Button) view.findViewById(R.id.submit);

        insta = (ImageView)view.findViewById(R.id.Insta);
        whatsapp = (ImageView)view.findViewById(R.id.whatsapp);


        Bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mname.getText().toString();
                String query = mquery.getText().toString();
                String email = memail.getText().toString();

                Firebase childref = mRootRef.push();

                Firebase fname = childref.child("name");
                fname.setValue(name);

                Firebase femail = childref.child("email");
                femail.setValue(email);

                Firebase fquery = childref.child("query");
                fquery.setValue(query);


                mname.setText("");
                memail.setText("");
                mquery.setText("");

                Toast.makeText(getActivity(), "Query Submitted, We Will Contact You Soon", Toast.LENGTH_LONG).show();

            }


        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/Rewards_Converter/")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com")));
                }
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://wa.me/916359431935")));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.whatsapp.com")));
                }
            }
        });

        return view;


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Query");
    }
}
