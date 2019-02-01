package com.divesh.rewardsconverter;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdRequest;

public class PaymentSuccess extends AppCompatActivity {

    Random random;

    Button button;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        random = new Random();
        int randomnum = random.nextInt(3);

        if (randomnum==1){
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-2146945573240609/2926775425");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    // Load the next interstitial.
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }

            });

        }
        else{
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-7403621248230876/1367782838");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    // Load the next interstitial.
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }

            });
        }


        Intent i = getIntent();
        String str = i.getStringExtra("Amount");
        String str1 = i.getStringExtra("Name");
        String str2 = i.getStringExtra("Platform");



        button = (Button)findViewById(R.id.Finish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mInterstitialAd.isLoaded()){
                    mInterstitialAd.show();
                }
                finish();
            }
        });

        TextView mname = (TextView)findViewById(R.id.nameop);
        mname.setText(str1);

        TextView mamount = (TextView)findViewById(R.id.amountop);
        mamount.setText(str);

        TextView mplatform = (TextView)findViewById(R.id.platformop);
        mplatform.setText(str2);

        TextView name = (TextView)findViewById(R.id.name);
        TextView amount = (TextView)findViewById(R.id.amount);
        TextView platform = (TextView)findViewById(R.id.platform);

        Typeface font = Typeface.createFromAsset(this.getAssets(), "Fonts/KoHo-Regular.ttf");
        mname.setTypeface(font);
        mamount.setTypeface(font);
        mplatform.setTypeface(font);
        name.setTypeface(font);
        amount.setTypeface(font);
        platform.setTypeface(font);
        button.setTypeface(font);


        TextView txt1 = (TextView) findViewById(R.id.body);
        Typeface font1 = Typeface.createFromAsset(this.getAssets(), "Fonts/Raleway-Medium.ttf");
        txt1.setTypeface(font1);


    }
}
