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


public class TrainNades extends ActionBarActivity {
    int picNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_nades);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        SharedPreferences sharedPref= getSharedPreferences("Train", 1);
        picNum = sharedPref.getInt("train", 0);

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
            img1.setImageResource(R.drawable.rightyellows);
            img2.setImageResource(R.drawable.rightyellowa);
            img3.setImageResource(R.drawable.rightyellowl);
            txt1.setText("crouch against the wall at the small box on the left.");
            txt2.setText("Aim while crouched a bit to the lower right from the center cross of the window railings. Make sure that the glass is broken before throwing. Stay crouched and hold both mouse keys for medium range throw and release.");
            txt3.setText("Lands on the right side of bomb train at A.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.snipers);
            img2.setImageResource(R.drawable.snipera);
            img3.setImageResource(R.drawable.sniperl);
            txt1.setText("Stand in the corner of the brown dumpster and the slanted plywood. ");
            txt2.setText("Aim slightly above the v-shaped intersection.");
            txt3.setText("Lands on the left of T train blocking view from IVY to break room.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.greenbrowns);
            img2.setImageResource(R.drawable.greenbrowna);
            img3.setImageResource(R.drawable.greenbrownl);
            txt1.setText("Stand where the roots touch the floor.");
            txt2.setText("Aim above the small white domed object on the left and align the crosshair with the right white pipe on the side of the wall.");
            txt3.setText("Lands between red train and A3 train.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.zs);
            img2.setImageResource(R.drawable.za);
            img3.setImageResource(R.drawable.zl);
            txt1.setText("Stand against the fence while on the brown dumpster between the 2 brown boxes behind the fence..");
            txt2.setText("Aim at the right corner of the building.");
            txt3.setText("Lands at the A side of Z connector.");
        }
        if (picNum == 5)
        {

            img1.setImageResource(R.drawable.bzs);
            img2.setImageResource(R.drawable.bza);
            img3.setImageResource(R.drawable.bzl);
            txt1.setText("Stand at the small corner in upper boiler.");
            txt2.setText("Aim at the top left cross in the railing. Run and throw");
            txt3.setText("Lands at the B side of Z connector.");
        }

        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.uppers);
            img2.setImageResource(R.drawable.uppera);
            img3.setImageResource(R.drawable.upperl);
            txt1.setText("Stand at the corner by the gray switch boxes.");
            txt2.setText("Aim slightly to the right of the corner and slight above the door knob.");
            txt3.setText("Lands at upper B, allowing passage through upper to down into sight without someone from CT side of upper seeing you.");
        }

        if (picNum == 7)
        {
            img1.setImageResource(R.drawable.byellows);
            img2.setImageResource(R.drawable.byellowa);
            img3.setImageResource(R.drawable.byellowl);
            txt1.setText("Stand at the corner by the tall brown box.");
            txt2.setText("Aim in the middle of the top right rectangle of the railing. Run and throw.");
            txt3.setText("Lands between B bomb train and pop dog.");
        }
        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.byellows);
            img2.setImageResource(R.drawable.byellowa);
            img3.setImageResource(R.drawable.byellowl);
            txt1.setText("Stand at the corner by the tall brown box.");
            txt2.setText("Aim in the middle of the top right rectangle of the railing. Run and throw.");
            txt3.setText("Lands between B bomb train and pop dog.");
        }
        if (picNum == 9)
        {
            img1.setImageResource(R.drawable.byellows);
            img2.setImageResource(R.drawable.byellowa);
            img3.setImageResource(R.drawable.byellowl);
            txt1.setText("Stand at the corner by the tall brown box.");
            txt2.setText("Aim in the middle of the top right rectangle of the railing. Run and throw.");
            txt3.setText("Lands between B bomb train and pop dog.");
        }



    }
}
