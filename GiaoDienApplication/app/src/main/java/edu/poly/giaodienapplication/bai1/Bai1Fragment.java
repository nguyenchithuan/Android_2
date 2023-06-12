package edu.poly.giaodienapplication.bai1;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.navigation.NavigationView;

import edu.poly.giaodienapplication.R;

public class Bai1Fragment extends Fragment {

    public static Bai1Fragment newInstance() {
        Bai1Fragment fragment = new Bai1Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bai1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvName = view.findViewById(R.id.tvName);
        ToggleButton toggleButton = view.findViewById(R.id.btnToggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    // set font chữ ở đây
                    Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "blazed.ttf");
                    tvName.setTypeface(typeface);
                } else {
                    tvName.setTypeface(null);
                }
            }
        });


     NavigationView a = getActivity().findViewById(R.id.id_NavView); // getActivity dùng để thao tác với Activity chua nó

    }
}