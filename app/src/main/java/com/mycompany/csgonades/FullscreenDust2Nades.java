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
public class FullscreenDust2Nades extends ActionBarActivity {
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

        setContentView(R.layout.activity_fullscreen_dust2_nades);

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
        SharedPreferences sharedPref= getSharedPreferences("Number1", 1);
        picNum = sharedPref.getInt("number1", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

        if (picNum == 1)
        {
            img1.setImageResource(R.drawable.xboxs);
            txt1.setText("Stand on the boxes by the car near T spawn. Hug the wall and move until the further 2 wires intersect at the begining.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.bcars);
            txt1.setText("Stand at the metal frame.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.alongcrosss);
            txt1.setText("Stand at the edge of pit.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.bplats);
            txt1.setText("Stand at the corner in CT mid.");
        }
        if (picNum == 5)
        {
            img1.setImageResource(R.drawable.longcorners);
            txt1.setText("Stand at the blue car at T spawn.");
        }
        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.tunsretakes);
            txt1.setText("Stand at the humvee in mid.");
        }

        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.longdoorss);
            txt1.setText("Stand at long car.");
        }
    }
    
    public void nextPic(View view) {
        SharedPreferences sharedPref= getSharedPreferences("Number1", 1);
        picNum = sharedPref.getInt("number1", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);
        picOrder += 1;
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
                img1.setImageResource(R.drawable.xboxs);
                txt1.setText("Stand on the boxes by the car near T spawn. Hug the wall and move until the further 2 wires intersect at the begining.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.xboxa);
                txt1.setText("Aim at the begining of the intersecting wires.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.xboxl);
                txt1.setText("Lands on xbox.");
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
                img1.setImageResource(R.drawable.bcars);
                txt1.setText("Stand at the metal frame.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bcara);
                txt1.setText("Aim to the right of the light bulb and above the center of the sun.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bcarl);
                txt1.setText("Lands at car at B.");
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
                img1.setImageResource(R.drawable.alongcrosss);
                txt1.setText("Stand at the edge of pit.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.alongcrossa);
                txt1.setText("Aim at the top of the red sign.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.alongcrossl);
                txt1.setText("Lands at the cross to A site.");
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
                img1.setImageResource(R.drawable.bplats);
                txt1.setText("Stand at the corner in CT mid.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bplata);
                txt1.setText("Aim at the wire crossing mid and to the left of where the wire on the pole crosses it.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bplatl);
                txt1.setText("Lands at B plat.");
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
                img1.setImageResource(R.drawable.longcorners);
                txt1.setText("Stand at the blue car at T spawn.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.longcornera);
                txt1.setText("Aim below the bottom corner of the light post and at the wire.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.longcornerl);
                txt1.setText("Lands at the corner at long.");
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
                img1.setImageResource(R.drawable.tunsretakes);
                txt1.setText("Stand at the humvee in mid.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.tunsretakea);
                txt1.setText("Aim at the dent on the light post.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.tunsretakel);
                txt1.setText("Lands at the enterance from tuns to B.");
            }
        }

        if (picNum == 8)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.longdoorss);
                txt1.setText("Stand at long car.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.longdoorsa);
                txt1.setText("Aim where the left wire crosses the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.longdoorsl);
                txt1.setText("Lands at long doors.");
            }
        }
    }

    public void previousPic(View view) {
        SharedPreferences sharedPref= getSharedPreferences("Number1", 1);
        picNum = sharedPref.getInt("number1", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);
        picOrder -= 1;
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
                img1.setImageResource(R.drawable.xboxs);
                txt1.setText("Stand on the boxes by the car near T spawn. Hug the wall and move until the further 2 wires intersect at the begining.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.xboxa);
                txt1.setText("Aim at the begining of the intersecting wires.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.xboxl);
                txt1.setText("Lands on xbox.");
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
                img1.setImageResource(R.drawable.bcars);
                txt1.setText("Stand at the metal frame.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bcara);
                txt1.setText("Aim to the right of the light bulb and above the center of the sun.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bcarl);
                txt1.setText("Lands at car at B.");
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
                img1.setImageResource(R.drawable.alongcrosss);
                txt1.setText("Stand at the edge of pit.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.alongcrossa);
                txt1.setText("Aim at the top of the red sign.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.alongcrossl);
                txt1.setText("Lands at the cross to A site.");
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
                img1.setImageResource(R.drawable.bplats);
                txt1.setText("Stand at the corner in CT mid.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bplata);
                txt1.setText("Aim at the wire crossing mid and to the left of where the wire on the pole crosses it.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bplatl);
                txt1.setText("Lands at B plat.");
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
                img1.setImageResource(R.drawable.longcorners);
                txt1.setText("Stand at the blue car at T spawn.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.longcornera);
                txt1.setText("Aim below the bottom corner of the light post and at the wire.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.longcornerl);
                txt1.setText("Lands at the corner at long.");
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
                img1.setImageResource(R.drawable.tunsretakes);
                txt1.setText("Stand at the humvee in mid.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.tunsretakea);
                txt1.setText("Aim at the dent on the light post.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.tunsretakel);
                txt1.setText("Lands at the enterance from tuns to B.");
            }
        }

        if (picNum == 8)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.longdoorss);
                txt1.setText("Stand at long car.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.longdoorsa);
                txt1.setText("Aim where the left wire crosses the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.longdoorsl);
                txt1.setText("Lands at long doors.");
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
