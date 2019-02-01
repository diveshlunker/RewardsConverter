package com.divesh.rewardsconverter;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.Random;

public class Lucky extends Fragment implements RewardedVideoAdListener{

    private AdView mAdView;
    private RewardedVideoAd mRewardedVideoAd;
    Button mbutton;
    Random random;
    Random random1;
    public int randonum;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.lucky,container,false);
        random = new Random();
        randonum= random.nextInt(3);
        MobileAds.initialize(getActivity(),"ca-app-pub-2146945573240609~7141352607");


        AdView adView = new AdView(getContext());
        adView.setAdSize(AdSize.BANNER);
        if(randonum==2){
            adView.setAdUnitId("ca-app-pub-2146945573240609/9672857611");
        }
        else{
            adView.setAdUnitId("ca-app-pub-7403621248230876/2281138126");
        }


        Typeface font5 = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Raleway-Medium.ttf");
        Typeface fontc = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Raleway-Bold.ttf");
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Fonts/Catamaran-Bold.ttf");

        TextView head = view.findViewById(R.id.Head);
        TextView steps = view.findViewById(R.id.steps);
        TextView p1 = view.findViewById(R.id.p1);
        TextView p2 = view.findViewById(R.id.p2);
        TextView p3 = view.findViewById(R.id.p3);
        TextView p4 = view.findViewById(R.id.p4);
        TextView bt = view.findViewById(R.id.apply);



        head.setTypeface(font);
        steps.setTypeface(fontc);
        p1.setTypeface(font5);
        p2.setTypeface(font5);
        p3.setTypeface(font5);
        p4.setTypeface(font5);
        bt.setTypeface(fontc);

        mbutton = (Button)view.findViewById(R.id.apply);


        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getContext());
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadRewardedVideoAd();
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }
            }
        });





        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        return view;


    }

    private void loadRewardedVideoAd() {

        mRewardedVideoAd.loadAd("ca-app-pub-2146945573240609/3207521612",
                new AdRequest.Builder().build());


    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Lucky Draw");


    }




    @Override
    public void onRewardedVideoAdLoaded() {

        mRewardedVideoAd.show();

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

        Intent i = new Intent(getActivity(),Form.class);
        startActivity(i);

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }

    @Override
    public void onResume() {
        mRewardedVideoAd.resume(getContext());
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(getContext());
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(getContext());
        super.onDestroy();
    }

}
