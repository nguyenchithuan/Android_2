package edu.poly.slideimageauto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import edu.poly.slideimageauto.adapter.PhotoAdapter;
import edu.poly.slideimageauto.objects.Photo;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter adapter;
    private List<Photo> list;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager2);
        circleIndicator = findViewById(R.id.circleIndicator);

        dataPhoto();
        adapter = new PhotoAdapter(this, list);

        viewPager.setAdapter(adapter);

        circleIndicator.setViewPager(viewPager);
        adapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        
        slideImageAutoRun();
    }

    private void slideImageAutoRun() {
        if(timer == null) {
            timer = new Timer();
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = list.size();

                        if(currentItem < totalItem) {
                            currentItem ++;
                            viewPager.setCurrentItem(currentItem);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 2000, 2000);
    }

    private void dataPhoto() {
        list = new ArrayList<>();
        list.add(new Photo(R.drawable.anhasm));
        list.add(new Photo(R.drawable.argentina));
        list.add(new Photo(R.drawable.hanquoc));
        list.add(new Photo(R.drawable.italia));
        list.add(new Photo(R.drawable.student));
        list.add(new Photo(R.drawable.truong));
    }
}