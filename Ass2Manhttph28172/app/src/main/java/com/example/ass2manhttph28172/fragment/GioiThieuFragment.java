package com.example.ass2manhttph28172.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import com.example.ass2manhttph28172.R;

public class GioiThieuFragment extends Fragment {
    private WebView webview;
    public GioiThieuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gioi_thieu, container, false);
        webview = (WebView) view.findViewById(R.id.webview);
        webview.loadUrl("file:///android_asset/gioithieu.html");
        return view;
    }
}
