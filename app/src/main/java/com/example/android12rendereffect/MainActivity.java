package com.example.android12rendereffect;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {

    ImageView imageView;

    SeekBar[] seekBars;
    int[] seekBarsIDs = {R.id.seekBar_x,R.id.seekBar_y};

    int x = 1;
    int y = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        
        seekBars = new SeekBar[seekBarsIDs.length];
        for(int i = 0;i < seekBarsIDs.length; i++){
            seekBars[i] = findViewById(seekBarsIDs[i]);
            seekBars[i].setMin(1);
            seekBars[i].setMax(150);
            seekBars[i].setOnSeekBarChangeListener(this);

        }
    }

    @RequiresApi(api = 31)
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.seekBar_x:
                x = i;
                imageView.setRenderEffect(RenderEffect.createBlurEffect(x, y, Shader.TileMode.CLAMP));
                break;
            case R.id.seekBar_y:
                y = i;
                imageView.setRenderEffect(RenderEffect.createBlurEffect(x, y, Shader.TileMode.CLAMP));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}