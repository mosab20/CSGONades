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


public class NukeNades extends ActionBarActivity {
    int picNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuke_nades);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        SharedPreferences sharedPref= getSharedPreferences("Nuke", 1);
        picNum = sharedPref.getInt("nuke", 0);
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
            img1.setImageResource(R.drawable.heavenglasss);
            img2.setImageResource(R.drawable.heavenglassa);
            img3.setImageResource(R.drawable.heavenglassl);
            txt1.setText("Stand on the railing at t roof so that the crosshair is on the dot.");
            txt2.setText("Aim slightly above the roof slightly left of the corner.");
            txt3.setText("Lands at heaven if glass is not broken.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.heavennowins);
            img2.setImageResource(R.drawable.heavennowina);
            img3.setImageResource(R.drawable.heavennowinl);
            txt1.setText("Stand on the line that is on the pipe next to the big silo.");
            txt2.setText("Aim between the two lines on the wall right below the roof edge while crouched then stand up and throw.");
            txt3.setText("Lands at heaven if glass is broken.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.outgarages);
            img2.setImageResource(R.drawable.outgaragea);
            img3.setImageResource(R.drawable.outgaragel);
            txt1.setText("Stand against the fence as shown in the image.");
            txt2.setText("align the crosshair vertically with the left edge of the label on the red box and horizontally with the roof edge on the left.");
            txt3.setText("Lands blocking garage.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.secrets);
            img2.setImageResource(R.drawable.secreta);
            img3.setImageResource(R.drawable.secretl);
            txt1.setText("Stand on the metal loop on the blue box.");
            txt2.setText("align the crosshair vertically with the shadow of the pipe going down the side of the silo and horizontally with the top corner of that pipe.");
            txt3.setText("Lands in secret.");
        }
        if (picNum == 5)
        {

            img1.setImageResource(R.drawable.ramps);
            img2.setImageResource(R.drawable.rampa);
            img3.setImageResource(R.drawable.rampl);
            txt1.setText("Stand against the wall at the third pipe from the left.");
            txt2.setText("Aim at the crossing that the glass frames meet, then quickly run and throw.");
            txt3.setText("Lands at ramp.");
        }
        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.vendings);
            img2.setImageResource(R.drawable.vendinga);
            img3.setImageResource(R.drawable.vendingl);
            txt1.setText("Stand in front of the door side facing vending entrance to ramp.");
            txt2.setText("Aim just under the row of vents aligned vertically with the right side of the middle light.");
            txt3.setText("Lands in vending.");
        }

        if (picNum == 7)
        {
            img1.setImageResource(R.drawable.toutsides);
            img2.setImageResource(R.drawable.toutsidea);
            img3.setImageResource(R.drawable.toutsidel);
            txt1.setText("Stand against the ct fence so that the corner of the red box facing you is aligned with the corner of the main building.");
            txt2.setText("Aim between the corner of the main building and the structure on the left and above the right the structure on the left.  Run forwards and throw once you reach the yellow lines on the floor.");
            txt3.setText("Lands at the t side of outside.");
        }
        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.heavenglasss);
            img2.setImageResource(R.drawable.heavenglassa);
            img3.setImageResource(R.drawable.silol);
            txt1.setText("Stand on the railing at t roof so that the crosshair is on the dot.");
            txt2.setText("Aim slightly above the roof slightly left of the corner.");
            txt3.setText("Lands on the silos at A site only if the roof glass is broken.");
        }
        if (picNum == 9)
        {
            img1.setImageResource(R.drawable.outcats);
            img2.setImageResource(R.drawable.outcata);
            img3.setImageResource(R.drawable.outcatl);
            txt1.setText("Stand against the fence as shown in the image.");
            txt2.setText("Aim so that the crosshair is vertically between the pole on the left and the lach on the right while being aligned with the corner where the white wall meets the blue wall on the far left.");
            txt3.setText("Lands on the catwalk corner.");
        }

    }
}
