package com.mycompany.csgonades;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class OverpassNades extends ActionBarActivity {
    int picNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overpass_nades);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        SharedPreferences sharedPref = getSharedPreferences("Overpass", 1);
        picNum = sharedPref.getInt("overpass", 0);

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
        ImageView img1 = (ImageView) findViewById(R.id.image1);
        ImageView img2 = (ImageView) findViewById(R.id.image2);
        ImageView img3 = (ImageView) findViewById(R.id.image3);

        TextView txt1 = (TextView) findViewById(R.id.txtStand);
        TextView txt2 = (TextView) findViewById(R.id.txtAim);
        TextView txt3 = (TextView) findViewById(R.id.txtLand);

        if (picNum == 1) {
            img1.setImageResource(R.drawable.jumps);
            img2.setImageResource(R.drawable.jumpa);
            img3.setImageResource(R.drawable.jumpl);
            txt1.setText("Stand at the post on the wall.");
            txt2.setText("Aim above the sphere on the next post closer to a site and align the crosshair with the corner of that post.");
            txt3.setText("Lands at the dumpster blocking site from A-back.");
        }
        if (picNum == 2) {
            img1.setImageResource(R.drawable.midstairss);
            img2.setImageResource(R.drawable.midstairsa);
            img3.setImageResource(R.drawable.midstairsl);
            txt1.setText("Stand at the post on the wall facing cafe.");
            txt2.setText("Aim at the top tip of the leaves of the bottom group of branches.");
            txt3.setText("Lands at the mid stairs near fountain.");
        }
        if (picNum == 3) {
            img1.setImageResource(R.drawable.banks);
            img2.setImageResource(R.drawable.banka);
            img3.setImageResource(R.drawable.bankl);
            txt1.setText("Stand at the edge of the entrance to bathrooms. The edge closer to A site.");
            txt2.setText("Aim above the middle of the light post and at the top of the straight crack on the roof of the wall to the left.");
            txt3.setText("Lands at bank.");
        }
        if (picNum == 4) {
            img1.setImageResource(R.drawable.tubes);
            img2.setImageResource(R.drawable.tubea);
            img3.setImageResource(R.drawable.tubel);
            txt1.setText("Stand on the left edge of the flowers.");
            txt2.setText("Aim slightly to the left of the corner of the second balcony from the bottom.");
            txt3.setText("Lands at the entrence of the pipe at construction.");
        }
        if (picNum == 5) {

            img1.setImageResource(R.drawable.connectors);
            img2.setImageResource(R.drawable.connectora);
            img3.setImageResource(R.drawable.connectorl);
            txt1.setText("Stand between the 2 benches at playground.");
            txt2.setText("Aim the crosshair above the right side of the sphere object and to the right of the top of the sphere object.");
            txt3.setText("Lands on the stairs of connector.");
        }
        if (picNum == 6) {
            img1.setImageResource(R.drawable.trailers);
            img2.setImageResource(R.drawable.trailera);
            img3.setImageResource(R.drawable.trailerl);
            txt1.setText("Stand at the edge of the dumpster at A site agains the wall.");
            txt2.setText("Aim at the left corner of the electric wire post.");
            txt3.setText("Lands at the trailer ramp.");
        }
        if (picNum == 7) {
            img1.setImageResource(R.drawable.bridges);
            img2.setImageResource(R.drawable.bridgea);
            img3.setImageResource(R.drawable.bridgel);
            txt1.setText("Stand at the corner of lower construction near the sewage pipe.");
            txt2.setText("Aim just under the top of trailer and slightly to the right of the edge of the wall to the left.");
            txt3.setText("Lands on bridge.");
        }
        if (picNum == 8) {
            img1.setImageResource(R.drawable.bwindows);
            img2.setImageResource(R.drawable.bwindowa);
            img3.setImageResource(R.drawable.bwindowl);
            txt1.setText("Stand at the corner of the pile of plywood.");
            txt2.setText("Aim between the 2 horizontal lines on the railway bridge.");
            txt3.setText("Lands at window.");
        }
        if (picNum == 9) {
            img1.setImageResource(R.drawable.btoxics);
            img2.setImageResource(R.drawable.btoxica);
            img3.setImageResource(R.drawable.btoxicl);
            txt1.setText("Stand at the edge of the shadow on the floor and against the slanted wall.");
            txt2.setText("Aim slightly above and slightly to the left of the line between the 2 top bricks on the right side of the wall.");
            txt3.setText("Lands at toxic and can sometimes block the whole area between the cylindrical support and toxic.");
        }
        if (picNum == 10) {
            img1.setImageResource(R.drawable.bridgeramps);
            img2.setImageResource(R.drawable.brampa);
            img3.setImageResource(R.drawable.brampl);
            txt1.setText("Stand on the barrel at alley.");
            txt2.setText("Aim slightly above the left side of the small brown rectangle.");
            txt3.setText("Lands at the ramp at B.");
        }
        if (picNum == 11) {
            img1.setImageResource(R.drawable.bridgeramps);
            img2.setImageResource(R.drawable.bridge2a);
            img3.setImageResource(R.drawable.bridge2l);
            txt1.setText("Stand on the barrel at alley.");
            txt2.setText("Aim above the right side of the brown edge where the 2 big rectangles meet and align the crosshair with the top of the railing on the traffic light.");
            txt3.setText("Lands on the bridge.");
        }
    }
}
