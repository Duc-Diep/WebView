package com.example.webview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentWebView extends Fragment {
    WebView webView;
    String url;
    public static FragmentWebView newInstance(String url) {

        Bundle bundle = new Bundle();
        bundle.putString("url",url);
        FragmentWebView fragment = new FragmentWebView();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container,false);
        webView = view.findViewById(R.id.webview);
        url = getArguments().getString("url");
        try {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
        }catch (Exception e){
            Toast.makeText(getContext(),"Unknow website",Toast.LENGTH_SHORT).show();
        }
        webView.setWebViewClient(new WebViewClient());
        return view;
    }
}
