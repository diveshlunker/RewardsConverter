package com.divesh.rewardsconverter;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class PaymentError extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_error);

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

        TextView txt = (TextView) findViewById(R.id.head);
        Typeface font = Typeface.createFromAsset(this.getAssets(), "Fonts/KoHo-Bold.ttf");
        txt.setTypeface(font);

        TextView txt1 = (TextView) findViewById(R.id.body);
        Typeface font1 = Typeface.createFromAsset(this.getAssets(), "Fonts/Raleway-Medium.ttf");
        txt1.setTypeface(font1);

        TextView txt2 = (TextView) findViewById(R.id.down);
        txt2.setTypeface(font1);
    }
}
