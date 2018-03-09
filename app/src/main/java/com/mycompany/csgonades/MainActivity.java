package com.mycompany.csgonades;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


public class MainActivity extends ActionBarActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!BuildConfig.PAID_VERSION)
        {
            mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }

    }
    public void nuke(View view)
    {
        Intent i = new Intent(this, Nuke.class);
        startActivity(i);
    }
    public void dust2(View view)
    {
        Intent i = new Intent(this, Dust2.class);
        startActivity(i);
    }
    public void inferno(View view)
    {
        Intent i = new Intent(this, Inferno.class);
        startActivity(i);
    }
    public void mirage(View view)
    {
        Intent i = new Intent(this, Mirage.class);
        startActivity(i);
    }
    public void cobblestone(View view)
    {
        Intent i = new Intent(this, Cobblestone.class);
        startActivity(i);
    }
    public void train(View view)
    {
        Intent i = new Intent(this, Train.class);
        startActivity(i);
    }
    public void cache(View view)
    {
        Intent i = new Intent(this, Cache.class);
        startActivity(i);
    }
    public void overpass(View view)
    {
        Intent i = new Intent(this, Overpass.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void openSettings()
    {
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }
}
