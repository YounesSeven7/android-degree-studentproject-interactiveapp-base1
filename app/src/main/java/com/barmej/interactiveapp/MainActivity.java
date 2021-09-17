package com.barmej.interactiveapp;

import android.graphics.drawable.Drawable;
import android.os.PersistableBundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";

    ImageView imageView;
    TextView textView;

    Drawable drawable;
    int numberIndex = 0;
    Random random = new Random();



    PlaceActivity[] idAndNamePlace = {
            new PlaceActivity(R.drawable.park, R.string.park),
            new PlaceActivity(R.drawable.beach, R.string.beach),
            new PlaceActivity(R.drawable.bike, R.string.bike),
            new PlaceActivity(R.drawable.football, R.string.football),
            new PlaceActivity(R.drawable.museum, R.string.museum),
            new PlaceActivity(R.drawable.restaurant, R.string.restaurant),
            new PlaceActivity(R.drawable.running, R.string.running),
            new PlaceActivity(R.drawable.shop, R.string.shop),
            new PlaceActivity(R.drawable.swimming, R.string.swimming),
            new PlaceActivity(R.drawable.walking, R.string.walking),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView2);
    }


    void changeImage(){
        if (numberIndex < 10 && numberIndex >= 0) {
            drawable = ContextCompat.getDrawable(this, idAndNamePlace[numberIndex].getIdDrawable());
            imageView.setImageDrawable(drawable);
            textView.setText(idAndNamePlace[numberIndex].getIdNameDrawable());
        }
        else if (numberIndex >= 10){
            numberIndex = 9;
            Toast.makeText(this, "لقد إنتهت الصور", Toast.LENGTH_LONG).show();
        }
        else if (numberIndex < 0){
            numberIndex = 0;
            Toast.makeText(this, "لقد إنتهت الصور", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "لقد إنتهت الصور", Toast.LENGTH_LONG).show();
        }

    }

    public void nextImage(View view){
        numberIndex++;
        changeImage();
    }



    public void lestImage(View view){
        numberIndex--;
        changeImage();
    }
    public void randomImage(View view){
        numberIndex = random.nextInt(idAndNamePlace.length);
        changeImage();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        outState.putInt(BUNDLE_CURRENT_INDEX, numberIndex);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveRestoreInstanceState");
        numberIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);
        changeImage();

    }
}