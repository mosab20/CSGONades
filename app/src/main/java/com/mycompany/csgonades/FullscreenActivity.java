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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.mycompany.csgonades.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends ActionBarActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    int picOrder=1;
    int picNum;


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
        int picNum;
        setContentView(R.layout.activity_fullscreen);
        SharedPreferences sharedPref = getSharedPreferences("Overpass", 1);
        picNum = sharedPref.getInt("overpass", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);
        if (picNum == 1) {
            img1.setImageResource(R.drawable.jumps);

            txt1.setText("Stand at the post on the wall.");
        }
        if (picNum == 2) {
            img1.setImageResource(R.drawable.midstairss);

            txt1.setText("Stand at the post on the wall facing cafe.");
        }
        if (picNum == 3) {
            img1.setImageResource(R.drawable.banks);

            txt1.setText("Stand at the edge of the entrance to bathrooms. The edge closer to A site.");
        }
        if (picNum == 4) {
            img1.setImageResource(R.drawable.tubes);

            txt1.setText("Stand on the left edge of the flowers.");
        }
        if (picNum == 5)
        {
            img1.setImageResource(R.drawable.connectors);

            txt1.setText("Stand between the 2 benches at playground.");
        }
        if (picNum == 6) {
            img1.setImageResource(R.drawable.trailers);

            txt1.setText("Stand at the edge of the dumpster at A site agains the wall.");
        }
        if (picNum == 7) {
            img1.setImageResource(R.drawable.bridges);

            txt1.setText("Stand at the corner of lower construction near the sewage pipe.");
        }
        if (picNum == 8) {
            img1.setImageResource(R.drawable.bwindows);

            txt1.setText("Stand at the corner of the pile of plywood.");
        }
        if (picNum == 9) {
            img1.setImageResource(R.drawable.btoxics);

            txt1.setText("Stand at the edge of the shadow on the floor and against the slanted wall.");
        }
        if (picNum == 10) {
            img1.setImageResource(R.drawable.bridgeramps);

            txt1.setText("Stand on the barrel at alley.");
        }
        if (picNum == 11) {
            img1.setImageResource(R.drawable.bridgeramps);
            txt1.setText("Stand on the barrel at alley.");
        }
        if (picNum == 12) {
            img1.setImageResource(R.drawable.overpassalongs1);
            txt1.setText("Stand at the corner at the wall next to entrance to connector");
        }
        if (picNum == 13) {
            img1.setImageResource(R.drawable.overpassbbridges1);
            txt1.setText("Stand at the corner at tracks. Don't slide up the corner.");
        }
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


        



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }
    public void nextPic(View view)
    {
        SharedPreferences sharedPref = getSharedPreferences("Overpass", 1);
        picNum = sharedPref.getInt("overpass", 0);

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
                img1.setImageResource(R.drawable.jumps);
                txt1.setText("Stand at the post on the wall.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.jumpa);
                txt1.setText("Aim above the sphere on the next post closer to a site and align the crosshair with the corner of that post.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.jumpl);
                txt1.setText("Lands at the dumpster blocking site from A-back.");
            }
        }
        if (picNum == 2) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.midstairss);
                txt1.setText("Stand at the post on the wall facing cafe.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.midstairsa);
                txt1.setText("Aim at the top tip of the leaves of the bottom group of branches.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.midstairsl);
                txt1.setText("Lands at the mid stairs near fountain.");
            }
        }
        if (picNum == 3) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.banks);
                txt1.setText("Stand at the edge of the entrance to bathrooms. The edge closer to A site.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.banka);
                txt1.setText("Aim above the middle of the light post and at the top of the straight crack on the roof of the wall to the left.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.bankl);
                txt1.setText("Lands at bank.");
            }


        }
        if (picNum == 4) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.tubes);
                txt1.setText("Stand on the left edge of the flowers.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.tubea);
                txt1.setText("Aim slightly to the left of the corner of the second balcony from the bottom.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.tubel);
                txt1.setText("Lands at the entrence of the pipe at construction.");
            }
        }
        if (picNum == 5) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.connectors);
                txt1.setText("Stand between the 2 benches at playground.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.connectora);
                txt1.setText("Aim the crosshair above the right side of the sphere object and to the right of the top of the sphere object.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.connectorl);
                txt1.setText("Lands on the stairs of connector.");
            }

        }
        if (picNum == 6) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.trailers);
                txt1.setText("Stand at the edge of the dumpster at A site agains the wall.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.trailera);
                txt1.setText("Aim at the left corner of the electric wire post.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.trailerl);
                txt1.setText("Lands at the trailer ramp.");
            }
        }
        if (picNum == 7) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.bridges);
                txt1.setText("Stand at the corner of lower construction near the sewage pipe.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.bridgea);
                txt1.setText("Aim just under the top of trailer and slightly to the right of the edge of the wall to the left.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.bridgel);
                txt1.setText("Lands on bridge.");
            }
        }
        if (picNum == 8) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.bwindows);
                txt1.setText("Stand at the corner of the pile of plywood.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.bwindowa);
                txt1.setText("Aim between the 2 horizontal lines on the railway bridge.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.bwindowl);
                txt1.setText("Lands at window.");
            }
        }
        if (picNum == 9) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.btoxics);
                txt1.setText("Stand at the edge of the shadow on the floor and against the slanted wall.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.btoxica);
                txt1.setText("Aim slightly above and slightly to the left of the line between the 2 top bricks on the right side of the wall.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.btoxicl);
                txt1.setText("Lands at toxic and can sometimes block the whole area between the cylindrical support and toxic.");
            }
        }
        if (picNum == 10) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.bridgeramps);
                txt1.setText("Stand on the barrel at alley.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.brampa);
                txt1.setText("Aim slightly above the left side of the small brown rectangle.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.brampl);
                txt1.setText("Lands at the ramp at B.");
            }
        }
        if (picNum == 11) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.bridgeramps);
                txt1.setText("Stand on the barrel at alley.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.bridge2a);
                txt1.setText("Aim above the right side of the brown edge where the 2 big rectangles meet and align the crosshair with the top of the railing on the traffic light.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.bridge2l);
                txt1.setText("Lands on the bridge at b.");
            }
        }
        if (picNum == 12) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.overpassalongs1);
                txt1.setText("Stand at the corner at the wall next to entrance to connector");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.overpassalonga);
                txt1.setText("Aim at the bottom right corner of the bathroom sign. Jump right after letting go of the mouse button.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.overpassalongl);
                txt1.setText("Lands on the left side of A site, blocking view of long from bank.");
            }
        }
        if (picNum == 13) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.overpassbbridges1);
                txt1.setText("Stand at the corner at tracks. Don't slide up the corner.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.overpassbbridgea);
                txt1.setText("Aim right at the top of the train bridge and aligned with the light poll. Jump and throw.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.overpassbbridgel);
                txt1.setText("Lands on the bridge at b.");
            }
        }
    }
    public void previousPic(View view)
    {
        SharedPreferences sharedPref = getSharedPreferences("Overpass", 1);
        picNum = sharedPref.getInt("overpass", 0);

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
                img1.setImageResource(R.drawable.jumps);
                txt1.setText("Stand at the post on the wall.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.jumpa);
                txt1.setText("Aim above the sphere on the next post closer to a site and align the crosshair with the corner of that post.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.jumpl);
                txt1.setText("Lands at the dumpster blocking site from A-back.");
            }

        }
        if (picNum == 2) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.midstairss);
                txt1.setText("Stand at the post on the wall facing cafe.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.midstairsa);
                txt1.setText("Aim at the top tip of the leaves of the bottom group of branches.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.midstairsl);
                txt1.setText("Lands at the mid stairs near fountain.");
            }
        }
        if (picNum == 3) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.banks);
                txt1.setText("Stand at the edge of the entrance to bathrooms. The edge closer to A site.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.banka);
                txt1.setText("Aim above the middle of the light post and at the top of the straight crack on the roof of the wall to the left.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.bankl);
                txt1.setText("Lands at bank.");
            }


        }
        if (picNum == 4) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.tubes);
                txt1.setText("Stand on the left edge of the flowers.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.tubea);
                txt1.setText("Aim slightly to the left of the corner of the second balcony from the bottom.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.tubel);
                txt1.setText("Lands at the entrence of the pipe at construction.");
            }
        }
        if (picNum == 5) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.connectors);
                txt1.setText("Stand between the 2 benches at playground.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.connectora);
                txt1.setText("Aim the crosshair above the right side of the sphere object and to the right of the top of the sphere object.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.connectorl);
                txt1.setText("Lands on the stairs of connector.");
            }

        }
        if (picNum == 6) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.trailers);
                txt1.setText("Stand at the edge of the dumpster at A site agains the wall.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.trailera);
                txt1.setText("Aim at the left corner of the electric wire post.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.trailerl);
                txt1.setText("Lands at the trailer ramp.");
            }
        }
        if (picNum == 7) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.bridges);
                txt1.setText("Stand at the corner of lower construction near the sewage pipe.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.bridgea);
                txt1.setText("Aim just under the top of trailer and slightly to the right of the edge of the wall to the left.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.bridgel);
                txt1.setText("Lands on bridge.");
            }
        }
        if (picNum == 8) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.bwindows);
                txt1.setText("Stand at the corner of the pile of plywood.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.bwindowa);
                txt1.setText("Aim between the 2 horizontal lines on the railway bridge.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.bwindowl);
                txt1.setText("Lands at window.");
            }
        }
        if (picNum == 9) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.btoxics);
                txt1.setText("Stand at the edge of the shadow on the floor and against the slanted wall.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.btoxica);
                txt1.setText("Aim slightly above and slightly to the left of the line between the 2 top bricks on the right side of the wall.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.btoxicl);
                txt1.setText("Lands at toxic and can sometimes block the whole area between the cylindrical support and toxic.");
            }
        }
        if (picNum == 10) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.bridgeramps);
                txt1.setText("Stand on the barrel at alley.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.brampa);
                txt1.setText("Aim slightly above the left side of the small brown rectangle.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.brampl);
                txt1.setText("Lands at the ramp at B.");
            }
        }
        if (picNum == 11) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.bridgeramps);
                txt1.setText("Stand on the barrel at alley.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.bridge2a);
                txt1.setText("Aim above the right side of the brown edge where the 2 big rectangles meet and align the crosshair with the top of the railing on the traffic light.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.bridge2l);
                txt1.setText("Lands on the bridge at b.");
            }
        }
        if (picNum == 12) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.overpassalongs1);
                txt1.setText("Stand at the corner at the wall next to entrance to connector");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.overpassalonga);
                txt1.setText("Aim at the bottom right corner of the bathroom sign. Jump right after letting go of the mouse button.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.overpassalongl);
                txt1.setText("Lands on the left side of A site, blocking view of long from bank.");
            }
        }
        if (picNum == 13) {
            if(picOrder == 4)
                picOrder =1;
            if(picOrder ==0 )
                picOrder = 3;
            if(picOrder == 1){
                img1.setImageResource(R.drawable.overpassbbridges1);
                txt1.setText("Stand at the corner at tracks. Don't slide up the corner.");
            }
            if(picOrder == 2){
                img1.setImageResource(R.drawable.overpassbbridgea);
                txt1.setText("Aim right at the top of the train bridge and aligned with the light poll. Jump and throw.");
            }
            if(picOrder==3){
                img1.setImageResource(R.drawable.overpassbbridgel);
                txt1.setText("Lands on the bridge at b.");
            }
        }
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
