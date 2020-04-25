package com.shubham.mahalkar.scratchcarddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ScratchCard mScratchCard;
    TextView codeTxt;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScratchCard = findViewById(R.id.scratchCard);
        codeTxt = findViewById(R.id.codeTxt);
        number = codeTxt.getText().toString();
        codeTxt.setText(number);
        codeTxt.setText(Utils.generateNewCode());

        findViewById(R.id.btnScratchAgain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void scratch(boolean isScratched) {
        if (isScratched) {
            mScratchCard.setVisibility(View.INVISIBLE);
        } else {
            mScratchCard.setVisibility(View.VISIBLE);
        }
    }

    private void handleListeners() {
        mScratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {
            @Override
            public void onScratch(ScratchCard scratchCard, float visiblePercent) {
                if (visiblePercent > 0.8) {
                    scratch(true);
                }
            }
        });
    }
}
