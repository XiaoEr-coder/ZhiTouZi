package com.wujincheng.zhishaizi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button button;
    private ImageView img;
    private TextView textView;
    private int lastNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    private void initView() {
        button = findViewById(R.id.button);
        img = findViewById(R.id.imageView);
        textView = findViewById(R.id.number);
        img.setImageDrawable(getBaseContext().getResources().getDrawable(R.drawable.empty_dice));
        button.setOnClickListener(v -> {
            int random = new Random().nextInt(6) + 1;
            Log.e(TAG, "initView:  random : " + random);
            String str = "";
            if (lastNum != random) {
                int sourceID = 0;
                switch (random) {
                    case 1:
                        sourceID = R.drawable.dice_1;
                        break;
                    case 2:
                        sourceID = R.drawable.dice_2;
                        break;
                    case 3:
                        sourceID = R.drawable.dice_3;
                        break;
                    case 4:
                        sourceID = R.drawable.dice_4;
                        break;
                    case 5:
                        sourceID = R.drawable.dice_5;
                        break;
                    case 6:
                        sourceID = R.drawable.dice_6;
                        break;
                    default:
                        button.setText("error ,please try again");
                }
                str = "当前数字为: " + random;
                lastNum = random;
                Drawable drawable = getBaseContext().getResources().getDrawable(sourceID);
                img.setImageDrawable(drawable);
            } else {
                str = "恭喜你 再次掷出和上次一样的数:" + lastNum;
            }

            textView.setText(str);
        });
    }
}