package com.mycompany.csgonades;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenCacheNades extends ActionBarActivity {
    int picOrder=1;
    int picNum;
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen_cache_nades);
        
        SharedPreferences sharedPref = getSharedPreferences("Cache", 1);
        picNum = sharedPref.getInt("cache", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.image1);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        if (picNum == 1) {
            img1.setImageResource(R.drawable.trees);
            txt1.setText("Jump onto the ledge and stand at the corner of the white box.");
        }
        if (picNum == 2) {
            img1.setImageResource(R.drawable.boosts);
            txt1.setText("Stand in the corner of mid near sandbags.");
        }
        if (picNum == 3) {
            img1.setImageResource(R.drawable.mmids);
            txt1.setText("Stand at the edge of the side doorway at garage.");
        }
        if (picNum == 4) {
            img1.setImageResource(R.drawable.doorandmains);
            txt1.setText("Stand at the wheel of the truck.");
        }
        if (picNum == 5) {
            img1.setImageResource(R.drawable.rmids);
            txt1.setText("Stand at the left side of the t side doorway.");
        }
        if (picNum == 6) {
            img1.setImageResource(R.drawable.doorandmains);
            txt1.setText("Stand at the wheel of the truck.");
        }
        if (picNum == 7) {
            img1.setImageResource(R.drawable.generators);
            txt1.setText("Stand at the corner where the box and fence intersect in toxic.");
        }
        if (picNum == 8) {
            img1.setImageResource(R.drawable.bmains);
            txt1.setText("Stand at the corner close to generator at the boxes closest to heaven on B site.");
        }
        if (picNum == 9) {
            img1.setImageResource(R.drawable.trucks);
            txt1.setText("Stand at the left side of the left fenced door in b main.");
        }
        if (picNum == 10) {
            img1.setImageResource(R.drawable.midconnectors);
            txt1.setText("Run towards the white stripes from spawn.");
        }
        if (picNum == 11) {
            img1.setImageResource(R.drawable.quads);
            txt1.setText("Stand on the white line against the wall.");
        }
        if (picNum == 12) {
            img1.setImageResource(R.drawable.cacheaheavens1);
            txt1.setText("Stand by the corner at the entrance to squeaky.");
        }
        if (picNum == 13) {
            img1.setImageResource(R.drawable.cachebackas1);
            txt1.setText("Stand at the corner by the entrance to squeaky.");
        }
        if (picNum == 14) {
            img1.setImageResource(R.drawable.cachehighways1);
            txt1.setText("Stand on the wooden planks that are leaning on the truck.");
        }
    }
    public void nextPic(View view) {
        SharedPreferences sharedPref = getSharedPreferences("Cache", 1);
        picNum = sharedPref.getInt("cache", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);
        picOrder +=1;
        if (picNum == 1) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.trees);
                txt1.setText("Jump onto the ledge and stand at the corner of the white box.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cachebtreea1);
                txt1.setText("Aim between the two brown rust spots on the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.cachebtreel);
                txt1.setText("Lands at entrance of tree room.");
            }
        }
        if (picNum == 2) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.boosts);
                txt1.setText("Stand in the corner of mid near sandbags.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.boosta);
                txt1.setText("Aim at the highest corner of the building behind the boost spot.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.boostl);
                txt1.setText("Lands on wood piece at the boost area.  They can still see, but they will have to push up more at boost.");
            }
        }
        if (picNum == 3) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.mmids);
                txt1.setText("Stand at the edge of the side doorway at garage.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.mmida);
                txt1.setText("Aim towards the bottom end of the thicker piece of wood at the middle.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.mmidl);
                txt1.setText("Lands at the left side of mid. This smoke is good with the other mid smokes to completely block enemy vision while heading into vents.");
            }
        }
        if (picNum == 4) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.doorandmains);
                txt1.setText("Stand at the wheel of the truck.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.amaina);
                txt1.setText("Aim at the middle of the handle of the red hammer.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.amainl);
                txt1.setText("Lands blocking a main completely.");
            }
        }
        if (picNum == 5) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.rmids);
                txt1.setText("Stand at the left side of the t side doorway.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.rmida);
                txt1.setText("Aim at the top and towards the right side of the blocked window.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.rmidl);
                txt1.setText("Lands at the right side of mid. This smoke is good with the other mid smokes to completely block enemy vision while heading into vents.");
            }
        }
        if (picNum == 6) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.doorandmains);
                txt1.setText("Stand at the wheel of the truck.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.squa);
                txt1.setText("Aim above the brown box and to the right of the crack on the left corner wall.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.squl);
                txt1.setText("Lands at the door of squeaky.");
            }
        }
        if (picNum == 7) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.generators);
                txt1.setText("Stand at the corner where the box and fence intersect in toxic.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.generatora);
                txt1.setText("aim at the bottom of the railing pole.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.generatorl);
                txt1.setText("Lands at generator.");
            }
        }
        if (picNum == 8) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.bmains);
                txt1.setText("Stand at the corner close to generator at the boxes closest to heaven on B site.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bmaina);
                txt1.setText("Aim at the top corner of the left side of the B main doorway");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.bmainl);
                txt1.setText("Lands completely blocking sight from B main to site or checkers.  They will have to jump on the box or run through smoke.");
            }
        }
        if (picNum == 9) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.trucks);
                txt1.setText("Stand at the left side of the left fenced door in b main.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.trucka);
                txt1.setText("Lightly tap w just before you throw.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.truckl);
                txt1.setText("Lands between forklift and the red crate blocking view from truck.");
            }
        }
        if (picNum == 10) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.midconnectors);
                txt1.setText("Run towards the white stripes from spawn.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.midconnectora);
                txt1.setText("While running, keep the crosshair just below the bottom of the lowest branch on the tree while being vertically aligned with the vertical wooden frame on the wall. Once You reach the white stripes, jump and throw.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.midconnectorl);
                txt1.setText("Lands at the mid entrance to ct connector.");
            }
        }
        if (picNum == 11) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.quads);
                txt1.setText("Stand on the white line against the wall.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.quada);
                txt1.setText("Align the crosshair with the antenna pole and with the corner on the right that the blue railings make with the building.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.quadl);
                txt1.setText("Lands on the right of the red box on A site.");
            }
        }
        if (picNum == 12) {
            if(picOrder == 5) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 4;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.cacheaheavens1);
                txt1.setText("Stand by the corner at the entrance to squeaky.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cacheaheavens2);
                txt1.setText("A closer view of where to stand.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.cacheaheavena);
                txt1.setText("Aim at the tip of the antenna.");
            }
            if(picOrder == 4) {
                img1.setImageResource(R.drawable.cacheaheavenl);
                txt1.setText("Lands on the catwalk above the ladder at a.");
            }
        }
        if (picNum == 13) {
            if(picOrder == 5) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 4;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.cachebackas1);
                txt1.setText("Stand at the corner by the entrance to squeaky.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cachebackas2);
                txt1.setText("A closer view of where to stand.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.cachebackaa);
                txt1.setText("Aim to the left of the railing, between the 2 marks on it.");
            }
            if(picOrder == 4) {
                img1.setImageResource(R.drawable.cachebackal2);
                txt1.setText("Lands behind red box on A site.");
            }
        }
        if (picNum == 14) {
            if(picOrder == 5) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 4;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.cachehighways1);
                txt1.setText("Stand on the wooden planks that are leaning on the truck.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cachehighways2);
                txt1.setText("Go to the left corner of wooden planks.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.cachehighwaya);
                txt1.setText("Align the crosshair with the white edge on the wall. Jump and throw.");
            }
            if(picOrder == 4) {
                img1.setImageResource(R.drawable.cachehighwayl);
                txt1.setText("Lands on highway blocking vision into A site.");
            }
        }
    }

    public void previousPic(View view) {
        SharedPreferences sharedPref = getSharedPreferences("Cache", 1);
        picNum = sharedPref.getInt("cache", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

        picOrder -=1;

        if (picNum == 1) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.trees);
                txt1.setText("Jump onto the ledge and stand at the corner of the white box.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cachebtreea1);
                txt1.setText("Aim between the two brown rust spots on the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.cachebtreel);
                txt1.setText("Lands at entrance of tree room.");
            }

        }
        if (picNum == 2) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.boosts);
                txt1.setText("Stand in the corner of mid near sandbags.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.boosta);
                txt1.setText("Aim at the highest corner of the beilding behind the boost spot.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.boostl);
                txt1.setText("Lands on wood piece at the boost area.  They can still see, but they will have to push up more at boost.");
            }
        }
        if (picNum == 3) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.mmids);
                txt1.setText("Stand at the edge of the side doorway at garage.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.mmida);
                txt1.setText("Aim towards the bottom end of the thicker piece of wood at the middle.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.mmidl);
                txt1.setText("Lands at the left side of mid. This smoke is good with the other mid smokes to completely block enemy vision while heading into vents.");
            }
        }
        if (picNum == 4) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.doorandmains);
                txt1.setText("Stand at the wheel of the truck.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.amaina);
                txt1.setText("Aim at the middle of the handle of the red hammer.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.amainl);
                txt1.setText("Lands blocking a main completely.");
            }
        }
        if (picNum == 5) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.rmids);
                txt1.setText("Stand at the left side of the t side doorway.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.rmida);
                txt1.setText("Aim at the top and towards the right side of the blocked window.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.rmidl);
                txt1.setText("Lands at the right side of mid. This smoke is good with the other mid smokes to completely block enemy vision while heading into vents.");
            }
        }
        if (picNum == 6) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.doorandmains);
                txt1.setText("Stand at the wheel of the truck.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.squa);
                txt1.setText("Aim above the brown box and to the right of the crack on the left corner wall.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.squl);
                txt1.setText("Lands at the door of squeaky.");
            }
        }
        if (picNum == 7) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.generators);
                txt1.setText("Stand at the corner where the box and fence intersect in toxic.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.generatora);
                txt1.setText("aim at the bottom of the railing pole.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.generatorl);
                txt1.setText("Lands at generator.");
            }
        }
        if (picNum == 8) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.bmains);
                txt1.setText("Stand at the corner close to generator at the boxes closest to heaven on B site.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bmaina);
                txt1.setText("Aim at the top corner of the left side of the B main doorway");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.bmainl);
                txt1.setText("Lands completely blocking sight from B main to site or checkers.  They will have to jump on the box or run through smoke.");
            }
        }
        if (picNum == 9) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.trucks);
                txt1.setText("Stand at the left side of the left fenced door in b main.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.trucka);
                txt1.setText("Lightly tap w just before you throw.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.truckl);
                txt1.setText("Lands between forklift and the red crate blocking view from truck.");
            }
        }
        if (picNum == 10) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.midconnectors);
                txt1.setText("Run towards the white stripes from spawn.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.midconnectora);
                txt1.setText("While running, keep the crosshair just below the bottom of the lowest branch on the tree while being vertically aligned with the vertical wooden frame on the wall. Once You reach the white stripes, jump and throw.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.midconnectorl);
                txt1.setText("Lands at the mid entrance to ct connector.");
            }
        }
        if (picNum == 11) {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.quads);
                txt1.setText("Stand on the white line against the wall.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.quada);
                txt1.setText("Align the crosshair with the antenna pole and with the corner on the right that the blue railings make with the building.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.quadl);
                txt1.setText("Lands on the right of the red box on A site.");
            }
        }
        if (picNum == 12) {
            if(picOrder == 5) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 4;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.cacheaheavens1);
                txt1.setText("Stand by the corner at the entrance to squeaky.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cacheaheavens2);
                txt1.setText("A closer view of where to stand.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.cacheaheavena);
                txt1.setText("Aim at the tip of the antenna.");
            }
            if(picOrder == 4) {
                img1.setImageResource(R.drawable.cacheaheavenl);
                txt1.setText("Lands on the catwalk above the ladder at a.");
            }
        }
        if (picNum == 13) {
            if(picOrder == 5) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 4;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.cachebackas1);
                txt1.setText("Stand at the corner by the entrance to squeaky.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cachebackas2);
                txt1.setText("A closer view of where to stand.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.cachebackaa);
                txt1.setText("Aim to the left of the railing, between the 2 marks on it.");
            }
            if(picOrder == 4) {
                img1.setImageResource(R.drawable.cachebackal2);
                txt1.setText("Lands behind red box on A site.");
            }
        }
        if (picNum == 14) {
            if(picOrder == 5) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 4;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.cachehighways1);
                txt1.setText("Stand on the wooden planks that are leaning on the truck.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cachehighways2);
                txt1.setText("Go to the left corner of wooden planks.");
            }
            if(picOrder == 3) {
                img1.setImageResource(R.drawable.cachehighwaya);
                txt1.setText("Align the crosshair with the white edge on the wall. Jump and throw.");
            }
            if(picOrder == 4) {
                img1.setImageResource(R.drawable.cachehighwayl);
                txt1.setText("Lands on highway blocking vision into A site.");
            }
        }
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
