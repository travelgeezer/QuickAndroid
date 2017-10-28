package com.example.geezer.quickandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // use lambda expressions
        findViewById(R.id.button).setOnClickListener(v ->
                Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show());
    }

}
