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
public class FullscreenTrainNades extends ActionBarActivity {
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

        setContentView(R.layout.activity_fullscreen_train_nades);

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
        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);
        
        SharedPreferences sharedPref= getSharedPreferences("Train", 1);
        picNum = sharedPref.getInt("train", 0);

        if (picNum == 1)
        {
            img1.setImageResource(R.drawable.rightyellows);
            txt1.setText("crouch against the wall at the small box on the left.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.snipers);
            txt1.setText("Stand in the corner of the brown dumpster and the slanted plywood. ");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.greenbrowns);
            txt1.setText("Stand where the roots touch the floor.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.zs);
            txt1.setText("Stand against the fence while on the brown dumpster between the 2 brown boxes behind the fence.");
        }
        if (picNum == 5)
        {

            img1.setImageResource(R.drawable.bzs);
            txt1.setText("Stand at the small corner in upper boiler.");
        }

        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.uppers);
            txt1.setText("Stand at the corner by the gray switch boxes.");
        }

        if (picNum == 7)
        {
            img1.setImageResource(R.drawable.byellows);
            txt1.setText("Stand at the corner by the tall brown box.");
        }
        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.trainabetweentrainss1);
            txt1.setText("Stand on the crack on the floor next to the rectangular pillar.");
        }
    }

    public void nextPic(View view) {
        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

        SharedPreferences sharedPref= getSharedPreferences("Train", 1);
        picNum = sharedPref.getInt("train", 0);

        picOrder +=1;

        if (picNum == 1)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.rightyellows);
                txt1.setText("crouch against the wall at the small box on the left.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.rightyellowa);
                txt1.setText("Aim while crouched a bit to the lower right from the center cross of the window railings. Make sure that the glass is broken before throwing. Stay crouched and hold both mouse keys for medium range throw and release.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.rightyellowl);
                txt1.setText("Lands on the right side of bomb train at A.");
            }
        }
        if (picNum == 2)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.snipers);
                txt1.setText("Stand in the corner of the brown dumpster and the slanted plywood. ");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.snipera);
                txt1.setText("Aim slightly above the v-shaped intersection.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.sniperl);
                txt1.setText("Lands on the left of T train blocking view from IVY to break room.");
            }
        }
        if (picNum == 3)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.greenbrowns);
                txt1.setText("Stand where the roots touch the floor.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.greenbrowna);
                txt1.setText("Aim above the small white domed object on the left and align the crosshair with the right white pipe on the side of the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.greenbrownl);
                txt1.setText("Lands between red train and A3 train.");
            }
        }
        if (picNum == 4)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.zs);
                txt1.setText("Stand against the fence while on the brown dumpster between the 2 brown boxes behind the fence.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.za);
                txt1.setText("Aim at the right corner of the building.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.zl);
                txt1.setText("Lands at the A side of Z connector.");
            }
        }
        if (picNum == 5)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.bzs);
                txt1.setText("Stand at the small corner in upper boiler.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bza);
                txt1.setText("Aim at the top left cross in the railing. Run and throw");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bzl);
                txt1.setText("Lands at the B side of Z connector.");
            }
        }
        if (picNum == 6)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.uppers);
                txt1.setText("Stand at the corner by the gray switch boxes.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.uppera);
                txt1.setText("Aim slightly to the right of the corner and slight above the door knob.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.upperl);
                txt1.setText("Lands at upper B, allowing passage through upper to down into sight without someone from CT side of upper seeing you.");
            }
        }
        if (picNum == 7)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.byellows);
                txt1.setText("Stand at the corner by the tall brown box.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.byellowa);
                txt1.setText("Aim in the middle of the top right rectangle of the railing. Run and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.byellowl);
                txt1.setText("Lands between B bomb train and pop dog.");
            }
        }
        //new smokes from guy that reviewed.
        if (picNum == 8)
        {
            if(picOrder == 6) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 5;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.trainabetweentrainss1);
                txt1.setText("Stand on the crack on the floor next to the rectangular pillar.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.trainabetweentrainss2);
                txt1.setText("Stand with your crosshair aiming at that crack intersection.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.trainabetweentrainsa1);
                txt1.setText("Break the glass on that side of the window.");
            }
            if(picOrder == 4)
            {
                img1.setImageResource(R.drawable.trainabetweentrainsa2);
                txt1.setText("Aim in the middle of the triangle the corner of the window frame makes with the antenna.");
            }
            if(picOrder == 5)
            {
                img1.setImageResource(R.drawable.trainabetweentrainsl);
                txt1.setText("Lands between T train and red train on A.");
            }
        }
    }

    public void previousPic(View view) {
        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

        SharedPreferences sharedPref= getSharedPreferences("Train", 1);
        picNum = sharedPref.getInt("train", 0);

        picOrder -=1;

        if (picNum == 1)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.rightyellows);
                txt1.setText("crouch against the wall at the small box on the left.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.rightyellowa);
                txt1.setText("Aim while crouched a bit to the lower right from the center cross of the window railings. Make sure that the glass is broken before throwing. Stay crouched and hold both mouse keys for medium range throw and release.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.rightyellowl);
                txt1.setText("Lands on the right side of bomb train at A.");
            }
        }
        if (picNum == 2)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.snipers);
                txt1.setText("Stand in the corner of the brown dumpster and the slanted plywood. ");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.snipera);
                txt1.setText("Aim slightly above the v-shaped intersection.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.sniperl);
                txt1.setText("Lands on the left of T train blocking view from IVY to break room.");
            }
        }
        if (picNum == 3)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.greenbrowns);
                txt1.setText("Stand where the roots touch the floor.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.greenbrowna);
                txt1.setText("Aim above the small white domed object on the left and align the crosshair with the right white pipe on the side of the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.greenbrownl);
                txt1.setText("Lands between red train and A3 train.");
            }
        }
        if (picNum == 4)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.zs);
                txt1.setText("Stand against the fence while on the brown dumpster between the 2 brown boxes behind the fence.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.za);
                txt1.setText("Aim at the right corner of the building.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.zl);
                txt1.setText("Lands at the A side of Z connector.");
            }
        }
        if (picNum == 5)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.bzs);
                txt1.setText("Stand at the small corner in upper boiler.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bza);
                txt1.setText("Aim at the top left cross in the railing. Run and throw");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bzl);
                txt1.setText("Lands at the B side of Z connector.");
            }
        }
        if (picNum == 6)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.uppers);
                txt1.setText("Stand at the corner by the gray switch boxes.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.uppera);
                txt1.setText("Aim slightly to the right of the corner and slight above the door knob.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.upperl);
                txt1.setText("Lands at upper B, allowing passage through upper to down into sight without someone from CT side of upper seeing you.");
            }
        }
        if (picNum == 7)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.byellows);
                txt1.setText("Stand at the corner by the tall brown box.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.byellowa);
                txt1.setText("Aim in the middle of the top right rectangle of the railing. Run and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.byellowl);
                txt1.setText("Lands between B bomb train and pop dog.");
            }
        }
        //new smokes from guy that reviewed.
        if (picNum == 8)
        {
            if(picOrder == 6) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 5;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.trainabetweentrainss1);
                txt1.setText("Stand on the crack on the floor next to the rectangular pillar.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.trainabetweentrainss2);
                txt1.setText("Stand with your crosshair aiming at that crack intersection.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.trainabetweentrainsa1);
                txt1.setText("Break the glass on that side of the window.");
            }
            if(picOrder == 4)
            {
                img1.setImageResource(R.drawable.trainabetweentrainsa2);
                txt1.setText("Aim in the middle of the triangle the corner of the window frame makes with the antenna.");
            }
            if(picOrder == 5)
            {
                img1.setImageResource(R.drawable.trainabetweentrainsl);
                txt1.setText("Lands between T train and red train on A.");
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
