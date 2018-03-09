package com.mycompany.csgonades;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class CacheNades extends ActionBarActivity {
    int picNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache_nades);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        SharedPreferences sharedPref = getSharedPreferences("Cache", 1);
        picNum = sharedPref.getInt("cache", 0);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
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

        TextView txt1 = (TextView) findViewById(R.id.txtStand);
        TextView txt2 = (TextView) findViewById(R.id.txtAim);
        TextView txt3 = (TextView) findViewById(R.id.txtLand);
        ImageView img1 = (ImageView) findViewById(R.id.image1);
        ImageView img2 = (ImageView) findViewById(R.id.image2);
        ImageView img3 = (ImageView) findViewById(R.id.image3);


        if (picNum == 1) {
            img1.setImageResource(R.drawable.trees);
//            img2.setImageResource(R.drawable.treea);
//            img3.setImageResource(R.drawable.treel);
            txt1.setText("Jump onto the ledge and stand at the corner of the white box.");
            txt2.setText("Aim at the middle brown stain on the wall.");
            txt3.setText("Lands at entrance of tree room.");
        }
        if (picNum == 2) {
            img1.setImageResource(R.drawable.boosts);
            img2.setImageResource(R.drawable.boosta);
            img3.setImageResource(R.drawable.boostl);
            txt1.setText("Stand in the corner of mid near sandbags.");
            txt2.setText("Aim at the highest corner of the beilding behind the boost spot.");
            txt3.setText("Lands on wood piece at the boost area.  They can still see, but they will have to push up more at boost.");
        }
        if (picNum == 3) {
            img1.setImageResource(R.drawable.mmids);
            img2.setImageResource(R.drawable.mmida);
            img3.setImageResource(R.drawable.mmidl);
            txt1.setText("Stand at the edge of the side doorway at garage.");
            txt2.setText("Aim towards the bottom end of the thicker piece of wood at the middle.");
            txt3.setText("Lands at the left side of mid. This smoke is good with the other mid smokes to completely block enemy vision while heading into vents.");
        }
        if (picNum == 4) {
            img1.setImageResource(R.drawable.doorandmains);
            img2.setImageResource(R.drawable.amaina);
            img3.setImageResource(R.drawable.amainl);
            txt1.setText("Stand at the wheel of the truck.");
            txt2.setText("Aim at the middle of the handle of the red hammer.");
            txt3.setText("Lands blocking a main completely.");
        }
        if (picNum == 5) {
            img1.setImageResource(R.drawable.rmids);
            img2.setImageResource(R.drawable.rmida);
            img3.setImageResource(R.drawable.rmidl);
            txt1.setText("Stand at the left side of the t side doorway.");
            txt2.setText("Aim at the top and towards the right side of the blocked window.");
            txt3.setText("Lands at the right side of mid. This smoke is good with the other mid smokes to completely block enemy vision while heading into vents.");

        }
        if (picNum == 6) {
            img1.setImageResource(R.drawable.doorandmains);
            img2.setImageResource(R.drawable.squa);
            img3.setImageResource(R.drawable.squl);
            txt1.setText("Stand at the wheel of the truck.");
            txt2.setText("Aim above the brown box and to the right of the crack on the left corner wall.");
            txt3.setText("Lands at the door of squeaky.");
        }
        if (picNum == 7) {
            img1.setImageResource(R.drawable.generators);
            img2.setImageResource(R.drawable.generatora);
            img3.setImageResource(R.drawable.generatorl);
            txt1.setText("Stand at the corner where the box and fence intersect in toxic.");
            txt2.setText("aim at the bottom of the railing pole.");
            txt3.setText("Lands at generator.");
        }
        if (picNum == 8) {
            img1.setImageResource(R.drawable.bmains);
            img2.setImageResource(R.drawable.bmaina);
            img3.setImageResource(R.drawable.bmainl);
            txt1.setText("Stand at the corner close to generator at the boxes closest to heaven on B site.");
            txt2.setText("Aim at the top corner of the left side of the B main doorway");
            txt3.setText("Lands completely blocking sight from B main to site or checkers.  They will have to jump on the box or run through smoke.");
        }
        if (picNum == 9) {
            img1.setImageResource(R.drawable.trucks);
            img2.setImageResource(R.drawable.trucka);
            img3.setImageResource(R.drawable.truckl);
            txt1.setText("Stand at the left side of the left fenced door in b main.");
            txt2.setText("Lightly tap w just before you throw.");
            txt3.setText("Lands between forklift and the red crate blocking view from truck.");
        }
        if (picNum == 10) {
            img1.setImageResource(R.drawable.midconnectors);
            img2.setImageResource(R.drawable.midconnectora);
            img3.setImageResource(R.drawable.midconnectorl);
            txt1.setText("Run towards the white stripes from spawn.");
            txt2.setText("While running, keep the crosshair just below the bottom of the lowest branch on the tree while being vertically aligned with the vertical wooden frame on the wall. Once You reach the white stripes, jump and throw.");
            txt3.setText("Lands at the mid entrance to ct connector.");
        }
        if (picNum == 11) {
            img1.setImageResource(R.drawable.quads);
            img2.setImageResource(R.drawable.quada);
            img3.setImageResource(R.drawable.quadl);
            txt1.setText("Stand on the white line against the wall.");
            txt2.setText("Align the crosshair with the antenna pole and with the corner on the right that the blue railings make with the building.");
            txt3.setText("Lands on the right of the red box on A site.");
        }

    }
}