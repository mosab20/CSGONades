package com.mycompany.csgonades;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class CobblestoneNades extends ActionBarActivity {
    int picNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobblestone_nades);
        SharedPreferences sharedPref= getSharedPreferences("Cobble", 1);
        picNum = sharedPref.getInt("cobble", 0);
        TabHost tabHost =(TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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
            img1.setImageResource(R.drawable.bandhuts);
            img2.setImageResource(R.drawable.bsitea);
            img3.setImageResource(R.drawable.bsitel);
            txt1.setText("Stand at the corner of the double stacked brown crates.");
            txt2.setText("Aim so that the crosshair is above the top left corner of the wooden post sticking out of the wall and align it horizontally flat with the roof on the right.");
            txt3.setText("Lands on B site blocking view from doors. It makes it easier to get a plant without getting shot.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.blongs);
            img2.setImageResource(R.drawable.blonga);
            img3.setImageResource(R.drawable.blongl);
            txt1.setText("Stand in the corner of the platform in connector.");
            txt2.setText("Aim towards the bottom right corner of the white shaded square on the wall. Then jump and throw.");
            txt3.setText("Lands in B long.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.bandhuts);
            img2.setImageResource(R.drawable.bhuta);
            img3.setImageResource(R.drawable.bhutl);
            txt1.setText("Stand at the corner of the double stacked brown crates.");
            txt2.setText("Aim at the top right corner of the wooden post sticking out of the wall.");
            txt3.setText("Lands inside of B hut. It completely fills hut.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.blongs2);
            img2.setImageResource(R.drawable.blonga2);
            img3.setImageResource(R.drawable.blongl2);
            txt1.setText("Stand next to the stairs leading from drop area to B site.");
            txt2.setText("Aim above the middle line on the box and have the crosshair be on the arch behind the box.");
            txt3.setText("Lands in B long.");
        }
        if (picNum == 5)
        {

            img1.setImageResource(R.drawable.walls);
            img2.setImageResource(R.drawable.walla);
            img3.setImageResource(R.drawable.walll);
            txt1.setText("Stand in the corner of the double stacked crates.");
            txt2.setText("Aim at the top of the edge of the broken wall.");
            txt3.setText("Lands blocking sight from drop area to broken wall.");
        }
        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.alongs);
            img2.setImageResource(R.drawable.alonga);
            img3.setImageResource(R.drawable.alongl);
            txt1.setText("Stand on the far edge of the wooden railing.");
            txt2.setText("Aim at the top of the wooden support, where it connects to the roof.");
            txt3.setText("Lands at the stairs of A long.");
        }
        if (picNum == 7)
        {
            img1.setImageResource(R.drawable.adoors);
            img2.setImageResource(R.drawable.adoora);
            img3.setImageResource(R.drawable.adoorl);
            txt1.setText("Stand in front of the small barred window.");
            txt2.setText("Aim slightly above the right side of the middle wall. Align the edge of the crosshair so that it intersects the top right corner of the wall to the left.");
            txt3.setText("Lands in front of the A connector doors.");
        }
        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.amids);
            img2.setImageResource(R.drawable.amida);
            img3.setImageResource(R.drawable.amidl);
            txt1.setText("Stand on the double stacked wooden barrels in the back of A site.");
            txt2.setText("Aim above the right edge of the electric post and on the highest wire.");
            txt3.setText("Lands down at the bottom of A ramp.");
        }
        if (picNum == 9)
        {
            img1.setImageResource(R.drawable.aarchs);
            img2.setImageResource(R.drawable.aarcha);
            img3.setImageResource(R.drawable.aarchl);
            txt1.setText("Stand between the two windows that are next to the arch");
            txt2.setText("Aim above the left side of the window on the right most wall. Align the edge of the crosshair so that it intersects the top right corner of the wall to the left.");
            txt3.setText("Lands in front of storage at A.");
        }
        if (picNum == 10)
        {
            img1.setImageResource(R.drawable.awindows);
            img2.setImageResource(R.drawable.awindowa);
            img3.setImageResource(R.drawable.awindowl);
            txt1.setText("Stand on the left side of the door in ");
            txt2.setText("Aim to slightly to the left of the middle wooden post at window and put the crosshair between the two bottom electric cords.");
            txt3.setText("Lands in balcony.");
        }


    }

}
