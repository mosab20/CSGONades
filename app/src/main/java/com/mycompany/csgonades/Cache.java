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


public class Cache extends ActionBarActivity {
    InterstitialAd mInterstitialAd;
    int toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
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
        Button button1 = (Button) findViewById(R.id.ctsmoke5);
        Button button2 = (Button) findViewById(R.id.ctsmoke2);
        Button button3 = (Button) findViewById(R.id.ctsmoke3);
        Button button4 = (Button) findViewById(R.id.ctsmoke4);
        Button button5 = (Button) findViewById(R.id.tsmoke1);
        Button button6 = (Button) findViewById(R.id.tsmoke2);
        Button button7 = (Button) findViewById(R.id.tsmoke3);
        Button button8 = (Button) findViewById(R.id.tsmoke5);
        Button button9 = (Button) findViewById(R.id.tsmoke4);
        Button button10 = (Button) findViewById(R.id.tsmoke6);
        Button button11 = (Button) findViewById(R.id.tsmoke7);
        Button button12 = (Button) findViewById(R.id.tsmoke8);
        Button button13 = (Button) findViewById(R.id.tsmoke9);
        Button button14 = (Button) findViewById(R.id.tsmoke10);

        if (toggle == 1)
        {
            // red = #fff20008  green = #ff14b317  orange = #ffff8600
            button1.setTextColor(Color.parseColor("#fff20008"));
            button2.setTextColor(Color.parseColor("#ff14b317"));
            button3.setTextColor(Color.parseColor("#ff14b317"));
            button4.setTextColor(Color.parseColor("#ff14b317"));
            button5.setTextColor(Color.parseColor("#ff14b317"));
            button6.setTextColor(Color.parseColor("#ff14b317"));
            button7.setTextColor(Color.parseColor("#ff14b317"));
            button8.setTextColor(Color.parseColor("#ff14b317"));
            button9.setTextColor(Color.parseColor("#ffff8600"));
            button10.setTextColor(Color.parseColor("#ffff8600"));
            button11.setTextColor(Color.parseColor("#ff14b317"));
            button12.setTextColor(Color.parseColor("#ff14b317"));
            button13.setTextColor(Color.parseColor("#ff14b317"));
            button14.setTextColor(Color.parseColor("#ffff8600"));
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
            button9.setTextColor(Color.BLACK);
            button10.setTextColor(Color.BLACK);
            button11.setTextColor(Color.BLACK);
            button12.setTextColor(Color.BLACK);
            button13.setTextColor(Color.BLACK);
            button14.setTextColor(Color.BLACK);
        }
    }
    public void smoke1(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache", 1);
        //commits your edits
        editor1.commit();
        Intent intent = new Intent(this, FullscreenCacheNades.class);
        startActivity(intent);
    }
    public void smoke2(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache", 2);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke3(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache", 3);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke4(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache", 4);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke5(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",5 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke6(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache", 6);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke7(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",7 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke8(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache", 8);
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke9(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",9 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke10(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",10 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke11(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",11 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke12(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",12 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke13(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",13 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke14(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",14 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke15(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",15 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
        startActivity(i);
    }
    public void smoke16(View view)
    {
        SharedPreferences guessString = getSharedPreferences("Cache", 1);
        //now get Editor
        SharedPreferences.Editor editor1 = guessString.edit();
        //put your value
        editor1.putInt("cache",16 );
        //commits your edits
        editor1.commit();
        Intent i = new Intent(this, FullscreenCacheNades.class);
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