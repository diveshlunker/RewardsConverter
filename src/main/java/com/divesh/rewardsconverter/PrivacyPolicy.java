package com.divesh.rewardsconverter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class PrivacyPolicy extends Fragment {

    WebView WebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.privacy_policy,container,false);

//        WebView = (WebView) view.findViewById(R.id.webview);
//
//        WebView.setWebViewClient(new MyWebViewClient());
//        String url = "https://ajdjgroupsnco.ml/rewards-convertor-privacy-policy";
//        WebView.getSettings().setJavaScriptEnabled(true);
//        WebView.loadUrl(url); // load a web page in a web view

        return view;

    }

//    private class MyWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
//            return true;
//        }
//    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Privacy Policy");
    }
}


