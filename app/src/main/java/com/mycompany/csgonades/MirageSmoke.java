package com.mycompany.csgonades;

import android.content.SharedPreferences;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MirageSmoke extends ActionBarActivity {
    int picNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirage_smoke);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        SharedPreferences sharedPref= getSharedPreferences("Mirage", 1);
        picNum = sharedPref.getInt("mirage", 0);

        TabHost tabHost =(TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("stand");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Stand");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("aim");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Aim");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("land");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Land");
        tabHost.addTab(tabSpec);
        ImageView img1 = (ImageView) findViewById(R.id.image1);
        ImageView img2 = (ImageView) findViewById(R.id.image2);
        ImageView img3 = (ImageView) findViewById(R.id.image3);

        TextView txt1 = (TextView) findViewById(R.id.txtStand);
        TextView txt2 = (TextView) findViewById(R.id.txtAim);
        TextView txt3 = (TextView) findViewById(R.id.txtLand);

        if (picNum == 1)
        {
            img1.setImageResource(R.drawable.windows);
            img2.setImageResource(R.drawable.windowa);
            img3.setImageResource(R.drawable.windowl);
            txt1.setText("Stand in the middle of the window that is furthest to the right of T spawn.");
            txt2.setText("Aim above where the right intersection of the wires is and to the left of the horizontal line on antenna. Run and throw just before you hit the fence.");
            txt3.setText("Lands in window.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.cttoramps);
            img2.setImageResource(R.drawable.cttorampa);
            img3.setImageResource(R.drawable.cttorampl);
            txt1.setText("Stand agains the right wall and at the top of CT stairs.");
            txt2.setText("Aim to the left of the wooden post and align the crosshair with the right edge of the left boxes.");
            txt3.setText("Lands at T ramp.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.kitchencats);
            img2.setImageResource(R.drawable.cata);
            img3.setImageResource(R.drawable.catl);
            txt1.setText("Stand in the middle of the barred door outside apartments.");
            txt2.setText("Aim slightly above the top wire and between the left and middle wooden posts.");
            txt3.setText("Lands in cat, but they can still see apartments if they move to the other side of cat.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.jungletoramps);
            img2.setImageResource(R.drawable.jungletorampa);
            img3.setImageResource(R.drawable.jungletorampl);
            txt1.setText("Stand by the white on the wall.");
            txt2.setText("Aim slightly to the right of the wooden post and align the crosshair with the corner on the left.");
            txt3.setText("Lands at T ramp.");
        }
        if (picNum == 5)
        {
            img1.setImageResource(R.drawable.bs);
            img2.setImageResource(R.drawable.ba);
            img3.setImageResource(R.drawable.bl);
            txt1.setText("Stand at the right edge of the window outside apartments.");
            txt2.setText("Aim above the middle wooden post and to the left of the further metal support for the AC unite.");
            txt3.setText("Lands in right side of B site.");
        }
        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.kitchencats);
            img2.setImageResource(R.drawable.kitchena);
            img3.setImageResource(R.drawable.kitchenl);
            txt1.setText("Stand in the middle of the barred door outside apartments.");
            txt2.setText("Aim slightly under the wires and align the crosshair with the left edge of the window on the wall.");
            txt3.setText("Lands blocking view from kitchen window.");
        }
        if (picNum == 7)
        {
            img1.setImageResource(R.drawable.benchs);
            img2.setImageResource(R.drawable.bencha);
            img3.setImageResource(R.drawable.benchl);
            txt1.setText("Stand next to the second wooden post for underpass stairs.");
            txt2.setText("Aim to the right of the corner on the left wall and above the left wooden post from the wall.");
            txt3.setText("Lands at bench next to van.");
        }
        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.stairss);
            img2.setImageResource(R.drawable.stairsa);
            img3.setImageResource(R.drawable.stairsl);
            txt1.setText("Stand at the corner of the wooden post on T roof outside of T ramp.");
            txt2.setText("Aim the crosshair above the top right corner on the wall and make the tip of the thumb (if using default view model) with the start of small wooden railing.");
            txt3.setText("Lands on A stairs.");
        }
        if (picNum == 9)
        {
            img1.setImageResource(R.drawable.cts);
            img2.setImageResource(R.drawable.cta);
            img3.setImageResource(R.drawable.ctl);
            txt1.setText("Stand on the corner of T roof.");
            txt2.setText("Aim slightly to the right of the wooden post. Run and immediately throw.");
            txt3.setText("Lands at CT stairs.");
        }
        if (picNum == 10)
        {
            img1.setImageResource(R.drawable.as);
            img2.setImageResource(R.drawable.aa);
            img3.setImageResource(R.drawable.al);
            txt1.setText("Stand at the edge of T roof.");
            txt2.setText("Aim above the top left corner of the hump on the wall and align the crosshair with the bottom of the skinny window.");
            txt3.setText("Lands in the middle of sight.");
        }
        if (picNum == 11)
        {
            img1.setImageResource(R.drawable.jungles);
            img2.setImageResource(R.drawable.junglea);
            img3.setImageResource(R.drawable.junglel);
            txt1.setText("Stand between the 2 windows on T roof.");
            txt2.setText("Aim above the bottom left corner of the middle hump on the wall and slightly bellow the top of the hump.");
            txt3.setText("Lands in jungle.");
        }
    }
}
