package com.test.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.customview.view.PlayAndPauseView;

public class MainActivity extends AppCompatActivity {
    private Button start, reverse;
    private PlayAndPauseView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        start =  findViewById(R.id.start);
//        reverse = findViewById(R.id.reverse);
//        animationView = findViewById(R.id.playAndPauseView);
//        start.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View param1View) {
//                animationView.animationStart();
//            }
//        });
//        reverse.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View param1View) {
//                animationView.animationReverse();
//            }
//        });
    }
}

