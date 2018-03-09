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
public class FullscreenInfernoNades extends ActionBarActivity {

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

        setContentView(R.layout.activity_fullscreen_inferno_nades);

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
        SharedPreferences sharedPref= getSharedPreferences("Inferno", 1);
        picNum = sharedPref.getInt("inferno", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);
        if (picNum == 1)
        {
            img1.setImageResource(R.drawable.infernoarchlibraryporchs);
            txt1.setText("Stand between the leaves on the wall and the broom stick.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.infernoarchlibraryporchs);
            txt1.setText("Stand between the leaves on the wall and the broom stick.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.infernoamids);
            txt1.setText("Stand at the edge of arch side of A mid.");
        }
        if (picNum == 5)
        {
            img1.setImageResource(R.drawable.infernohaywagons);
            txt1.setText("Stand on the drainage line against the wall.");
        }
        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.infernodeepbananas);
            txt1.setText("Stand in front of the coffins at b site.");
        }
        if (picNum == 7)
        {
            img1.setImageResource(R.drawable.infernoarchlibraryporchs);
            txt1.setText("Stand between the leaves on the wall and the broom stick.");
        }
        if (picNum == 9)
        {
            img1.setImageResource(R.drawable.infernoarchsides);
            txt1.setText("Stand on the left edge of the flower pot on the left side of mid.");
        }
        if (picNum == 11)
        {
            img1.setImageResource(R.drawable.infernocoffinss);
            txt1.setText("Stand at the logs at banana. There will be a bump, you should be standing on it.");
        }
        if (picNum == 12)
        {
            img1.setImageResource(R.drawable.infernocoffinss);
            txt1.setText("Stand at the logs at banana. There will be a bump, you should be standing on it.");
        }
    }
    
    public void nextPic(View view) {
        SharedPreferences sharedPref= getSharedPreferences("Inferno", 1);
        picNum = sharedPref.getInt("inferno", 0);

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
                img1.setImageResource(R.drawable.infernoarchlibraryporchs);
                txt1.setText("Stand between the leaves on the wall and the broom stick.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernoarcha);
                txt1.setText("Aim above the right edge of the chimney and to the left of roof corner.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoarchl);
                txt1.setText("Lands in arch.");
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
                img1.setImageResource(R.drawable.infernoarchlibraryporchs);
                txt1.setText("Stand between the leaves on the wall and the broom stick.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernolibrarya);
                txt1.setText("Align the crosshair on the corner of the building and to the right of the top right corner of the concrete railing on the tower to the left. Run and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernolibraryl);
                txt1.setText("Lands at the entrance to library.");
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
                img1.setImageResource(R.drawable.infernoamids);
                txt1.setText("Stand at the edge of arch side of A mid.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernoamida);
                txt1.setText("Aim at the top of the white area on the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoamidl);
                txt1.setText("Lands in mid completely blocking it.");
            }
        }
        if (picNum == 5)
        {
            if(picOrder == 5) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 4;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.infernohaywagons);
                txt1.setText("Stand on the drainage line against the wall.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernohaywagona2);
                txt1.setText("Aim above the tiny pipe showing above the roof.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernohaywagona1);
                txt1.setText("Also aim to the left of the left corner of the roof on the right.");
            }
            if(picOrder == 4)
            {
                img1.setImageResource(R.drawable.infernohaywagonl);
                txt1.setText("Lands on the left of the hay wagon at a site.");
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
                img1.setImageResource(R.drawable.infernodeepbananas);
                txt1.setText("Stand in front of the coffins at b site.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernodeepbananaa);
                txt1.setText("Aim above the left edge of the container holding cylinders and to the left of the roof corner.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernodeepbananal);
                txt1.setText("Lands deep into banana close to T stairs.");
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
                img1.setImageResource(R.drawable.infernoarchlibraryporchs);
                txt1.setText("Stand between the leaves on the wall and the broom stick.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernoporchsidea);
                txt1.setText("Aim above the left edge of the door and to the right of the top right corner of the window.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoporchsidel);
                txt1.setText("Lands on the right side of A mid. Enemies boosted on porch can still see over the smoke.");
            }
        }

        if (picNum == 9)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.infernoarchsides);
                txt1.setText("Stand on the left edge of the flower pot on the left side of mid.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernoarchsidea);
                txt1.setText("Aim at the railing and at the ridge edge of the window door.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoarchsidel);
                txt1.setText("Lands at arch side of mid.");
            }
        }
        if (picNum == 11)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.infernocoffinss);
                txt1.setText("Stand at the logs at banana. There will be a bump, you should be standing on it.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernocta);
                txt1.setText("Aim above the left edge of the scaffolding and at the lowest wire.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoctl);
                txt1.setText("Lands at the cross from CT to B.");
            }
        }
        if (picNum == 12)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.infernocoffinss);
                txt1.setText("Stand at the logs at banana. There will be a bump, you should be standing on it.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernocoffinsa);
                txt1.setText("Aim above and to the right of the two fence posts.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernocoffinsl);
                txt1.setText("Lands at coffins at b site.");
            }
        }
    }

    public void previousPic(View view) {
        SharedPreferences sharedPref= getSharedPreferences("Inferno", 1);
        picNum = sharedPref.getInt("inferno", 0);

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
                img1.setImageResource(R.drawable.infernoarchlibraryporchs);
                txt1.setText("Stand between the leaves on the wall and the broom stick.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernoarcha);
                txt1.setText("Aim above the right edge of the chimney and to the left of roof corner.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoarchl);
                txt1.setText("Lands in arch.");
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
                img1.setImageResource(R.drawable.infernoarchlibraryporchs);
                txt1.setText("Stand between the leaves on the wall and the broom stick.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernolibrarya);
                txt1.setText("Align the crosshair on the corner of the building and to the right of the top right corner of the concrete railing on the tower to the left. Run and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernolibraryl);
                txt1.setText("Lands at the entrance to library.");
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
                img1.setImageResource(R.drawable.infernoamids);
                txt1.setText("Stand at the edge of arch side of A mid.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernoamida);
                txt1.setText("Aim at the top of the white area on the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoamidl);
                txt1.setText("Lands in mid completely blocking it.");
            }
        }
        if (picNum == 5)
        {
            if(picOrder == 5) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 4;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.infernohaywagons);
                txt1.setText("Stand on the drainage line against the wall.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernohaywagona2);
                txt1.setText("Aim above the tiny pipe showing above the roof.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernohaywagona1);
                txt1.setText("Also aim to the left of the left corner of the roof on the right.");
            }
            if(picOrder == 4)
            {
                img1.setImageResource(R.drawable.infernohaywagonl);
                txt1.setText("Lands on the left of the hay wagon at a site.");
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
                img1.setImageResource(R.drawable.infernodeepbananas);
                txt1.setText("Stand in front of the coffins at b site.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernodeepbananaa);
                txt1.setText("Aim above the left edge of the container holding cylinders and to the left of the roof corner.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernodeepbananal);
                txt1.setText("Lands deep into banana close to T stairs.");
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
                img1.setImageResource(R.drawable.infernoarchlibraryporchs);
                txt1.setText("Stand between the leaves on the wall and the broom stick.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernoporchsidea);
                txt1.setText("Aim above the left edge of the door and to the right of the top right corner of the window.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoporchsidel);
                txt1.setText("Lands on the right side of A mid. Enemies boosted on porch can still see over the smoke.");
            }
        }

        if (picNum == 9)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.infernoarchsides);
                txt1.setText("Stand on the left edge of the flower pot on the left side of mid.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernoarchsidea);
                txt1.setText("Aim at the railing and at the ridge edge of the window door.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoarchsidel);
                txt1.setText("Lands at arch side of mid.");
            }
        }
        if (picNum == 11)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.infernocoffinss);
                txt1.setText("Stand at the logs at banana. There will be a bump, you should be standing on it.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernocta);
                txt1.setText("Aim above the left edge of the scaffolding and at the lowest wire.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernoctl);
                txt1.setText("Lands at the cross from CT to B.");
            }
        }
        if (picNum == 12)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.infernocoffinss);
                txt1.setText("Stand at the logs at banana. There will be a bump, you should be standing on it.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.infernocoffinsa);
                txt1.setText("Aim above and to the right of the two fence posts.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.infernocoffinsl);
                txt1.setText("Lands at coffins at b site.");
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
