package com.mycompany.csgonades;

import android.content.SharedPreferences;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.io.InputStream;


public class D2smoke extends ActionBarActivity {
    int picNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d2smoke);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        SharedPreferences sharedPref= getSharedPreferences("Number1", 1);
        picNum = sharedPref.getInt("number1", 0);
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
            img1.setImageResource(R.drawable.xboxs);
            img2.setImageResource(R.drawable.xboxa);
            img3.setImageResource(R.drawable.xboxl);
            txt1.setText("Stand on the boxes by the car near T spawn. Hug the wall and move until the further 2 wires intersect at the begining.");
            txt2.setText("Aim at the begining of the intersecting wires.");
            txt3.setText("Lands on xbox.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.bcars);
            img2.setImageResource(R.drawable.bcara);
            img3.setImageResource(R.drawable.bcarl);
            txt1.setText("Stand at the metal frame.");
            txt2.setText("Aim to the right of the light bulb and above the center of the sun.");
            txt3.setText("Lands at car at B.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.alongcrosss);
            img2.setImageResource(R.drawable.alongcrossa);
            img3.setImageResource(R.drawable.alongcrossl);
            txt1.setText("Stand at the edge of pit.");
            txt2.setText("Aim at the top of the red sign.");
            txt3.setText("Lands at the cross to A site.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.bplats);
            img2.setImageResource(R.drawable.bplata);
            img3.setImageResource(R.drawable.bplatl);
            txt1.setText("Stand at the corner in CT mid.");
            txt2.setText("Aim at the wire crossing mid and to the left of where the wire on the pole crosses it.");
            txt3.setText("Lands at B plat.");
        }
        if (picNum == 5)
        {
            img1.setImageResource(R.drawable.longcorners);
            img2.setImageResource(R.drawable.longcornera);
            img3.setImageResource(R.drawable.longcornerl);
            txt1.setText("Stand at the blue car at T spawn.");
            txt2.setText("Aim below the bottom corner of the light post and at the wire.");
            txt3.setText("Lands at the corner at long.");
        }
        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.tunsretakes);
            img2.setImageResource(R.drawable.tunsretakea);
            img3.setImageResource(R.drawable.tunsretakel);
            txt1.setText("Stand at the humvee in mid.");
            txt2.setText("Aim at the dent on the light post.");
            txt3.setText("Lands at the enterance from tuns to B.");
        }

        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.longdoorss);
            img2.setImageResource(R.drawable.longdoorsa);
            img3.setImageResource(R.drawable.longdoorsl);
            txt1.setText("Stand at long car.");
            txt2.setText("Aim where the left wire crosses the wall.");
            txt3.setText("Lands at long doors.");

        }


    }
}
