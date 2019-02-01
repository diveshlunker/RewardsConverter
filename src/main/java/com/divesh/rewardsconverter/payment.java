package com.divesh.rewardsconverter;

import android.app.Activity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.ImageButton;

import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.NotificationManager;

import android.support.v4.app.NotificationCompat;


public class payment extends Activity  {

    BillingProcessor bp;
    String name;
    String platform;
    String mtext;
    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    private Firebase mRootRef;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
//
//
//        NotificationManager notificationManager = (NotificationManager)
//                getSystemService(NOTIFICATION_SERVICE);
//
//
//        TextView txt = (TextView) findViewById(R.id.head);
//        TextView txt1 = (TextView) findViewById(R.id.body);
//        Typeface font2 = Typeface.createFromAsset(this.getAssets(), "Fonts/KoHo-Regular.ttf");
//        txt1.setTypeface(font2);
//        txt.setTypeface(font2);
//
//
//
//
//
//
//
//
//        bp = new BillingProcessor(this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhfz61/UdPc6IPdsNn35lOndhn8mulo3uCjvgxtyOAyZEEW9gt+b4sJsYhrG/FPM7kADhjeIc6lmHZA8aBOsvQJdYdCIh8/p/2dR3AMnyRttAFDrkHxQR0HUI6JfPtNwlCliGadlO1m0M5HzRxb6RgWewk9w3fT0JZMmNpZdNTMrqOdi0jWFSRsnPGJy9KD0AS6x3axqf8vxld78HHbLvckUGllk3oICRsGHOyrKWGKQ+/bjOOXFrhRjmSY2pwCQqKgV+nzxrYLOWisGu6P30Z5Yv7gbsQK3D72aAflou2SQCQlu8MVxj6+sPN4BaR/0lIsg3OWcrNVuz/e1hjKRMhwIDAQAB", this);
//        bp.initialize();
//
//        b1 = (ImageButton)findViewById(R.id.card10);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mtext = "10";
//                bp.purchase(payment.this,"card10");
//
//
//            }
//        });
//
//        b2 = (ImageButton)findViewById(R.id.card50);
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mtext = "50";
//                bp.purchase(payment.this,"card50");
//
//
//            }
//        });
//
//        b3 = (ImageButton)findViewById(R.id.card100);
//        b3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mtext = "100";
//                bp.purchase(payment.this,"card100");
//
//
//            }
//        });
//
//        b4 = (ImageButton)findViewById(R.id.card250);
//        b4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mtext = "250";
//                bp.purchase(payment.this,"card250");
//
//
//            }
//        });
//
//        b5 = (ImageButton)findViewById(R.id.card500);
//        b5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mtext = "500";
//                bp.purchase(payment.this,"card500");
//
//
//
//            }
//        });
//
//
//    }
//
//    @Override
//    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {
//        Toast.makeText(this,"You Purchased!!",Toast.LENGTH_SHORT).show();
//
//
//
//
//        Date currentTime = Calendar.getInstance().getTime();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm.ss aa");
//        String output = dateFormat.format(currentTime);
//
//        Date c = Calendar.getInstance().getTime();
//        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
//        String s = df.format(c);
//
//
//
//        Intent i = getIntent();
//        name = i.getStringExtra("name");
//        String email = i.getStringExtra("email");
//        platform = i.getStringExtra("platform");
//        String number = i.getStringExtra("number");
//        String Days = i.getStringExtra("Days");
//        String Country = i.getStringExtra("Country");
//
//        mRootRef = new Firebase("https://rewards-converter.firebaseio.com/Users");
//
//
//        Firebase childref = mRootRef.push();
//
//        NotificationCompat.Builder nb = (NotificationCompat.Builder) new NotificationCompat.Builder(this).
//                setDefaults(NotificationCompat.DEFAULT_ALL).
//                setSmallIcon(R.drawable.ic_launcher).
//                setContentTitle("Conversion Successful")
//                .setContentText("Your converted amount will reach you within a week in your desired platform.Have Patience. Thank You");
//        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        nm.notify(1,nb.build());
//
//        Firebase fname = childref.child("name");
//        fname.setValue(name);
//
//        Firebase femail = childref.child("email");
//        femail.setValue(email);
//
//        Firebase fplatform = childref.child("Platform");
//        fplatform.setValue(platform);
//
//        Firebase fnumber = childref.child("Number");
//        fnumber.setValue(number);
//
//        Firebase ftime = childref.child("Time");
//        ftime.setValue(output);
//
//        Firebase famount = childref.child("Amount");
//        famount.setValue(mtext);
//
//        Firebase fdate = childref.child("Date");
//        fdate.setValue(s);
//
//        Firebase fdays = childref.child("Days");
//        fdays.setValue(Days);
//
//        Firebase fcountry = childref.child("Country");
//        fcountry.setValue(Country);
//
//
//        bp.consumePurchase("card10");
//        bp.consumePurchase("card50");
//        bp.consumePurchase("card100");
//        bp.consumePurchase("card250");
//        bp.consumePurchase("card500");
//
//
//
//        Intent i2 = new Intent(payment.this,PaymentSuccess.class);
//        i2.putExtra("Amount", mtext);
//        i2.putExtra("Platform",platform);
//        i2.putExtra("Name",name);
//        startActivity(i2);
//        finish();
//
//    }
//
//
//    @Override
//    public void onPurchaseHistoryRestored() {
//
//
//    }
//
//    @Override
//    public void onBillingError(int errorCode, @Nullable Throwable error) {
//
//        Intent i3 = new Intent(payment.this,PaymentError.class);
//        startActivity(i3);
//        finish();
//
//    }
//
//    @Override
//    public void onBillingInitialized() {
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }
//
//    @Override
//    public void onDestroy() {
//        if (bp != null) {
//            bp.release();
//        }
//        super.onDestroy();
//    }
//
//
//}
    }
}