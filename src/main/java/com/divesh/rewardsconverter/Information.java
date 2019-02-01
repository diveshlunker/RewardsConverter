package com.divesh.rewardsconverter;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.firebase.client.Firebase;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Information extends AppCompatActivity implements AdapterView.OnItemSelectedListener,BillingProcessor.IBillingHandler{

    Button Bd;

    PopupWindow popUp;

    LinearLayout layout;
    LinearLayout.LayoutParams params;
    LinearLayout mainLayout;
    private Firebase mRootRef;
    EditText mname;
    EditText memail;
    EditText mnumber;
    EditText mcountry;
    TextView text;
    String amount;
    String name;
    String email;
    String number;
    String country;
    String platform;
    TextView tv;
    boolean click = true;
    Button but;

    private InterstitialAd minterstitial;
    public Spinner spinner;
    public Spinner spinner2;
    BillingProcessor bp;

    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);







        mRootRef = new Firebase("https://rewards-converter-6b2a1.firebaseio.com/Users");


//        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
//
//        minterstitial = new InterstitialAd(this);
//        minterstitial.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
//        minterstitial.loadAd(new AdRequest.Builder().build());
//
//        minterstitial.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                // Load the next interstitial.
//                minterstitial.loadAd(new AdRequest.Builder().build());
//            }

//        });


        bp = new BillingProcessor(this,null,this);
        //"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAufb0rYy+blCqqvb1LLSFd0woaM9qMdtwhtX+4ufQ/m0WmPrgDb6aT+zI0QQiXPEVTJhn8YM6MKQTJ2H/PvHVnucjwfsSdtGIo40tT2YpvOCHgeH1F4lAThwsTxYj1RMh0iVbMBMBjtb/dx4cCsZI8vzFPlCHiVKsS/6Ah3dk65ORvCllK0TqNtXdlJD6+42Xceu8BCh92vSR758BDW74RCIDwiCi4JWGpp9XX/izTyPn9KEzFUvQWkIBlm+Lr3spF3aNr2Et76oq4oKebzEEqTI7IwnS6ZSxueLZK+0fHnv2bAmWCyGr/ZGrEp+p+kRXeIXGpGpYlp4tH0+0qnp+iwIDAQAB", this);
        bp.initialize();

        mname = (EditText) findViewById(R.id.namef);
        mcountry = (EditText) findViewById(R.id.countryf);
        memail = (EditText) findViewById(R.id.emailf);
        mnumber = (EditText) findViewById(R.id.numberf);

//        text = (TextView) findViewById(R.id.t0);


        Typeface font5 = Typeface.createFromAsset(this.getAssets(), "Fonts/Raleway-Medium.ttf");
        mname.setTypeface(font5);
        memail.setTypeface(font5);
        mcountry.setTypeface(font5);
        mnumber.setTypeface(font5);





        Typeface font = Typeface.createFromAsset(this.getAssets(), "Fonts/KoHo-Bold.ttf");
//        text.setTypeface(font);


        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.AmountArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(2);

        spinner2 = (Spinner) findViewById(R.id.platformfu);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.PlatformArray, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);




        Bd = (Button) findViewById(R.id.proceed);
        Bd.setTypeface(font5);
        Bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                if(minterstitial.isLoaded()){
//                    minterstitial.show();
//                }
//                else{
//                    Log.d("TAG","intertestial add not loaded");
//                }




                name = mname.getText().toString();
                email = memail.getText().toString();
                number = mnumber.getText().toString();
                country = mcountry.getText().toString();



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

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "You Get 60% Of The Converted Amount",
                            Toast.LENGTH_LONG);

                    toast.show();

                    amountCollect();


                    Bd.setText("Finish Conversion");
                }
           }


        });







    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        amount=spinner.getSelectedItem().toString();
        platform=spinner2.getSelectedItem().toString();


        Toast toast = Toast.makeText(getApplicationContext(),
                amount,
                Toast.LENGTH_SHORT);

        toast.show();

        Toast toast1 = Toast.makeText(getApplicationContext(),
                "You Get 60% Of The Converted Amount",
                Toast.LENGTH_LONG);

        toast1.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void amountCollect() {
        if(amount.equals("Rs. 10")){
            bp.purchase(Information.this,"card10");
        }
        else if(amount.equals("Rs. 20")){
            bp.purchase(Information.this,"card20");
        }
        else if(amount.equals("Rs. 50")){
            bp.purchase(Information.this,"card50");
        }
        else if(amount.equals("Rs. 100")){
            bp.purchase(Information.this,"card100");
        }
        else if(amount.equals("Rs. 500")){
            bp.purchase(Information.this,"card500");
        }
        else if(amount.equals("Rs. 1000")){
            bp.purchase(Information.this,"card1000");
        }
        else if(amount.equals("Rs. 200")){
            bp.purchase(Information.this,"card200");
        }
        else if(amount.equals("Rs. 300")){
            bp.purchase(Information.this,"card300");
        }
        else if(amount.equals("Rs. 400")){
            bp.purchase(Information.this,"card400");
        }
        else if(amount.equals("Rs. 1250")){
            bp.purchase(Information.this,"card1250");

        }
        else if(amount.equals("Rs. 1500")){
            bp.purchase(Information.this,"card1500");
        }
        else if(amount.equals("Rs. 2000")){
            bp.purchase(Information.this,"card2000");
        }
        else if(amount.equals("Rs. 2500")){
            bp.purchase(Information.this,"card2500");
        }
        else if(amount.equals("Rs. 3000")){
            bp.purchase(Information.this,"card3000");
        }
        else if(amount.equals("Rs. 5000")){
            bp.purchase(Information.this,"card5000");
        }
        else if(amount.equals("Rs. 10000")){
            bp.purchase(Information.this,"card10000");
        }


    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {




        Toast.makeText(this, "You Purchased!!", Toast.LENGTH_SHORT).show();

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm.ss aa");
        String output = dateFormat.format(currentTime);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String s = df.format(c);

        mRootRef = new Firebase("https://rewards-converter-6b2a1.firebaseio.com/Users");
        Firebase childref = mRootRef.push();

        NotificationCompat.Builder nb = (NotificationCompat.Builder) new NotificationCompat.Builder(this).
                setDefaults(NotificationCompat.DEFAULT_ALL).
                setSmallIcon(R.drawable.ic_launcher).
                setContentTitle("Conversion Successful")
                .setContentText("Your converted amount will reach you within Ten Days in your desired platform.Have Patience. Thank You");
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, nb.build());

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

        Firebase famount = childref.child("Amount");
        famount.setValue(amount);

        Firebase fdate = childref.child("Date");
        fdate.setValue(s);

        Firebase fcountry = childref.child("Country");
        fcountry.setValue(country);


        bp.consumePurchase("card10");
        bp.consumePurchase("card50");
        bp.consumePurchase("card100");
        bp.consumePurchase("card20");
        bp.consumePurchase("card500");
        bp.consumePurchase("card200");
        bp.consumePurchase("card300");
        bp.consumePurchase("card400");
        bp.consumePurchase("card1000");
        bp.consumePurchase("card5000");
        bp.consumePurchase("card10000");
        bp.consumePurchase("card1250");
        bp.consumePurchase("card1500");
        bp.consumePurchase("card2500");
        bp.consumePurchase("card3000");
        bp.consumePurchase("card50000");
        bp.consumePurchase("card2000");


        Intent i2 = new Intent(Information.this, PaymentSuccess.class);
        i2.putExtra("Name", name);
        i2.putExtra("Amount", amount);
        i2.putExtra("Platform", platform);
        startActivity(i2);
        finish();



    }





    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {

        Intent i3 = new Intent(Information.this,PaymentError.class);
        startActivity(i3);
        finish();

    }

    @Override
    public void onBillingInitialized() {
    }

    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
    }




}
