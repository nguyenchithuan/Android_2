package edu.poly.assignment.gioithieu;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import edu.poly.assignment.R;

public class GioiThieuFragment extends Fragment {
    WebView mWebView;

    public static GioiThieuFragment newInstance() {
        GioiThieuFragment fragment = new GioiThieuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gioi_thieu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mWebView = view.findViewById(R.id.webView);

        mWebView.getSettings().setJavaScriptEnabled(true);


        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d("zzzzzzzzz", "onProgressChanged: " + newProgress); // xem log tiến trình load
                super.onProgressChanged(view, newProgress);
            }
        });

        mWebView.setWebViewClient( new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(getActivity(), error.getDescription() , Toast.LENGTH_SHORT).show();
            }
        });

        mWebView.loadUrl("https://www.google.com.vn/");
    }
}