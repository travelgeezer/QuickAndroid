package com.example.geezer.quickandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.geezer.quickandroid.managers.glide.GlideApp;
import com.example.geezer.quickandroid.network.SampleService;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // use lambda expressions
        findViewById(R.id.button).setOnClickListener(v ->
                Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show());

        // use rx and retrofit2
        Flowable.fromCallable(() -> SampleService.getContributors("square", "retrofit"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::printContributor, Throwable::printStackTrace);

        // use glide load image
        ImageView image = findViewById(R.id.imageView3);
        GlideApp.with(this)
                .load("https://b-ssl.duitang.com/uploads/item/201503/27/20150327200628_3Sxtv.jpeg")
                .into(image);

    }

    public void printContributor(List<SampleService.Contributor> contributors) {
        for (SampleService.Contributor contributor : contributors) {
            System.out.println(contributor);
        }
    }

}
