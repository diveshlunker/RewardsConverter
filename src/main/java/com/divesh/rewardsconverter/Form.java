package com.divesh.rewardsconverter;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Form extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AdView mAdView;
    Spinner spinner;
    Button mmbutton;
    String platform;
    EditText mmname;
    EditText mmemail;
    EditText mmnumber;
    EditText mmcountry;
    private Firebase mRootRef;
    String name;
    String email;
    String number;
    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        spinner = (Spinner) findViewById(R.id.platformfu);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.PlatformArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        mmname = (EditText) findViewById(R.id.namef);
        mmcountry = (EditText) findViewById(R.id.countryf);
        mmemail = (EditText) findViewById(R.id.emailf);
        mmnumber = (EditText) findViewById(R.id.numberf);

//        text = (TextView) findViewById(R.id.t0);


        Typeface font5 = Typeface.createFromAsset(this.getAssets(), "Fonts/Raleway-Medium.ttf");
        mmname.setTypeface(font5);
        mmemail.setTypeface(font5);
        mmcountry.setTypeface(font5);
        mmnumber.setTypeface(font5);


        mRootRef = new Firebase("https://rewards-converter-6b2a1.firebaseio.com/Draws");




        mmbutton = (Button)findViewById(R.id.Submitfff);

        mmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                name = mmname.getText().toString();
                email = mmemail.getText().toString();
                number = mmnumber.getText().toString();
                country = mmcountry.getText().toString();

                if(name.equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Please Fill Name Field To Proceed",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
                else if(email.equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Please Fill Email Field To Proceed",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
                else if(number.equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Please Enter The Phone Number To Proceed",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
                else if(country.equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Please Enter The Country Name To Proceed",
                            Toast.LENGTH_SHORT);

                    toast.show();
                }
                else{
                    LuckyForm();
                }

            }

            private void LuckyForm() {

                Date currentTime = Calendar.getInstance().getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm.ss aa");
                String output = dateFormat.format(currentTime);

                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String s = df.format(c);

                mRootRef = new Firebase("https://rewards-converter-6b2a1.firebaseio.com/Draws");
                Firebase childref = mRootRef.push();

                NotificationCompat.Builder nb = (NotificationCompat.Builder) new NotificationCompat.Builder(Form.this).
                        setDefaults(NotificationCompat.DEFAULT_ALL).
                        setSmallIcon(R.drawable.ic_launcher).
                        setContentTitle("Successfully Applied")
                        .setContentText("You have successfully applied for lucky draw. If you win, the amount will reach you.");
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(1,nb.build());

                Firebase fname = childref.child("name");
                fname.setValue(name);

                Firebase femail = childref.child("email");
                femail.setValue(email);

                Firebase fplatform = childref.child("Platform");
                fplatform.setValue(platform);

                Firebase fnumber = childref.child("Number");
                fnumber.setValue(number);

                Firebase ftime = childref.child("Time");
                ftime.setValue(output);

                Firebase fdate = childref.child("Date");
                fdate.setValue(s);

                Firebase fcountry = childref.child("Country");
                fcountry.setValue(country);

                Toast.makeText(getApplicationContext(),"Your Information Is Submitted And You Are Now Eligible For Lucky Draw!!",Toast.LENGTH_LONG).show();
                finish();


            }
        });

        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        platform=spinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
