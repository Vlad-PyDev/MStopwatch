package com.example.mstopwatch;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtProg;
    private CountDownTimer timer;
    private int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart   = findViewById(R.id.button_start);
        txtProg         = findViewById(R.id.text_progress);

        buttonStart.setOnClickListener(v -> startSevenSecondTimer());
    }

    private void startSevenSecondTimer() {
        if (timer != null) timer.cancel();

        txtProg.setText("");
        time = 0;

        timer = new CountDownTimer(7_000, 1_000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time++;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < time; i++) sb.append("\uD83D\uDE00");
                txtProg.setText(sb.toString());
            }

            @Override
            public void onFinish() {}
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) timer.cancel();
    }
}