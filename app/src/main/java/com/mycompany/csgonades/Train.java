package com.mycompany.csgonades;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class Train extends ActionBarActivity {
    InterstitialAd mInterstitialAd;
    int toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        if (!BuildConfig.PAID_VERSION) {
            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-6033901903111612/4555317685");
            requestNewInterstitial();
        }
        SharedPreferences sharedPref= getSharedPreferences("switch", 2);
        toggle = sharedPref.getInt("switch", 0);
        Button button1 = (Button) findViewById(R.id.tsmoke1);
        Button button2 = (Button) findViewById(R.id.tsmoke2);
        Button button3 = (Button) findViewById(R.id.tsmoke3);
        Button button4 = (Button) findViewById(R.id.tsmoke4);
        Button button5 = (Button) findViewById(R.id.tsmoke5);
        Button button6 = (Button) findViewById(R.id.tsmoke6);
        Button button7 = (Button) findViewById(R.id.tsmoke7);
        Button button8 = (Button) findViewById(R.id.tsmoke8);

        if (toggle == 1)
        {
            // red = #fff20008  green = #ff14b317  orange = #ffff8600
            button1.setTextColor(Color.parseColor("#ff14b317"));
            button2.setTextColor(Color.parseColor("#ff14b317"));
            button3.setTextColor(Color.parseColor("#ff14b317"));
            button4.setTextColor(Color.parseColor("#ff14b317"));
            button5.setTextColor(Color.parseColor("#ff14b317"));
            button6.setTextColor(Color.parseColor("#ff14b317"));
            button7.setTextColor(Color.parseColor("#ff14b317"));
            button8.setTextColor(Color.parseColor("#ff14b317"));
        }
        else if(toggle == 0)
        {
            button1.setTextColor(Color.BLACK);
            button2.setTextColor(Color.BLACK);
            button3.setTextColor(Color.BLACK);
            button4.setTextColor(Color.BLACK);
            button5.setTextColor(Color.BLACK);
            button6.setTextColor(Color.BLACK);
            button7.setTextColor(Color.BLACK);
            button8.setTextColor(Color.BLACK);
        }
    }
    public void smoke1(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Train", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("train", 1);
        //commits your edits
        editor1.commit();
        Intent intent = new Intent(this, FullscreenTrainNades.class);
        startActivity(intent);
    }
    public void smoke2(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Train", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("train", 2);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenTrainNades.class);
        startActivity(i);
    }
    public void smoke3(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Train", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("train", 3);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenTrainNades.class);
        startActivity(i);
    }
    public void smoke4(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Train", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("train", 4);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenTrainNades.class);
        startActivity(i);
    }
    public void smoke5(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Train", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("train", 5);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenTrainNades.class);
        startActivity(i);
    }
    public void smoke6(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Train", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("train", 6);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenTrainNades.class);
        startActivity(i);
    }
    public void smoke7(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Train", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("train", 7);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenTrainNades.class);
        startActivity(i);
    }
    public void smoke8(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Train", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("train", 8);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenTrainNades.class);
        startActivity(i);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (!BuildConfig.PAID_VERSION) {

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                finish();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        requestNewInterstitial();
                        finish();
                    }

                });
                finish();
            }
            finish();
        }
        else
        {
            finish();
        }
            return true;

    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("YOUR_DEVICE_HASH")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}
