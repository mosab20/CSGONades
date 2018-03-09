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
public class FullscreenMirageNades extends ActionBarActivity {
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

        setContentView(R.layout.activity_fullscreen_mirage_nades);

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
        
        SharedPreferences sharedPref= getSharedPreferences("Mirage", 1);
        picNum = sharedPref.getInt("mirage", 0);

        if (picNum == 1)
        {
            img1.setImageResource(R.drawable.windows);
            txt1.setText("Stand in the middle of the window that is furthest to the right of T spawn.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.cttoramps);
            txt1.setText("Stand agains the right wall and at the top of CT stairs.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.kitchencats);
            txt1.setText("Stand in the middle of the barred door outside apartments.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.jungletoramps);
            txt1.setText("Stand by the white on the wall.");
        }
        if (picNum == 5)
        {
            img1.setImageResource(R.drawable.bs);
            txt1.setText("Stand at the right edge of the window outside apartments.");
        }
        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.kitchencats);
            txt1.setText("Stand in the middle of the barred door outside apartments.");
        }
        if (picNum == 7)
        {
            img1.setImageResource(R.drawable.benchs);
            txt1.setText("Stand next to the second wooden post for underpass stairs.");
        }
        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.stairss);
            txt1.setText("Stand at the corner of the wooden post on T roof outside of T ramp.");
        }
        if (picNum == 9)
        {
            img1.setImageResource(R.drawable.cts);
            txt1.setText("Stand on the corner of T roof.");
        }
        if (picNum == 10)
        {
            img1.setImageResource(R.drawable.as);
            txt1.setText("Stand at the edge of T roof.");
        }
        if (picNum == 11)
        {
            img1.setImageResource(R.drawable.jungles);
            txt1.setText("Stand between the 2 windows on T roof.");
        }
    }

    public void nextPic(View view) {
        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

        SharedPreferences sharedPref= getSharedPreferences("Mirage", 1);
        picNum = sharedPref.getInt("mirage", 0);

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
                img1.setImageResource(R.drawable.windows);
                txt1.setText("Stand in the middle of the window that is furthest to the right of T spawn.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.windowa);
                txt1.setText("Aim above where the right intersection of the wires is and to the left of the horizontal line on antenna. Run and throw just before you hit the fence.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.windowl);
                txt1.setText("Lands in window.");
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
                img1.setImageResource(R.drawable.cttoramps);
                txt1.setText("Stand agains the right wall and at the top of CT stairs.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cttorampa);
                txt1.setText("Aim to the left of the wooden post and align the crosshair with the right edge of the left boxes.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.cttorampl);
                txt1.setText("Lands at T ramp.");
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
                img1.setImageResource(R.drawable.kitchencats);
                txt1.setText("Stand in the middle of the barred door outside apartments.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cata);
                txt1.setText("Aim slightly above the top wire and between the left and middle wooden posts.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.catl);
                txt1.setText("Lands in cat, but they can still see apartments if they move to the other side of cat.");
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
                img1.setImageResource(R.drawable.jungletoramps);
                txt1.setText("Stand by the white on the wall.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.jungletorampa);
                txt1.setText("Aim slightly to the right of the wooden post and align the crosshair with the corner on the left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.jungletorampl);
                txt1.setText("Lands at T ramp.");
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
                img1.setImageResource(R.drawable.bs);
                txt1.setText("Stand at the right edge of the window outside apartments.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.ba);
                txt1.setText("Aim above the middle wooden post and to the left of the further metal support for the AC unite.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bl);
                txt1.setText("Lands in right side of B site.");
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
                img1.setImageResource(R.drawable.kitchencats);
                txt1.setText("Stand in the middle of the barred door outside apartments.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.kitchena);
                txt1.setText("Aim slightly under the wires and align the crosshair with the left edge of the window on the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.kitchenl);
                txt1.setText("Lands blocking view from kitchen window.");
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
                img1.setImageResource(R.drawable.benchs);
                txt1.setText("Stand next to the second wooden post for underpass stairs.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bencha);
                txt1.setText("Aim to the right of the corner on the left wall and above the left wooden post from the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.benchl);
                txt1.setText("Lands at bench next to van.");
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
                img1.setImageResource(R.drawable.stairss);
                txt1.setText("Stand at the corner of the wooden post on T roof outside of T ramp.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.stairsa);
                txt1.setText("Aim the crosshair above the top right corner on the wall and make the tip of the thumb (if using default view model) with the start of small wooden railing.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.stairsl);
                txt1.setText("Lands on A stairs.");
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
                img1.setImageResource(R.drawable.cts);
                txt1.setText("Stand on the corner of T roof.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cta);
                txt1.setText("Aim slightly to the right of the wooden post. Run and immediately throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.ctl);
                txt1.setText("Lands at CT stairs.");
            }
        }
        if (picNum == 10)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.as);
                txt1.setText("Stand at the edge of T roof.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.aa);
                txt1.setText("Aim above the top left corner of the hump on the wall and align the crosshair with the bottom of the skinny window.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.al);
                txt1.setText("Lands in the middle of sight.");
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
                img1.setImageResource(R.drawable.jungles);
                txt1.setText("Stand between the 2 windows on T roof.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.junglea);
                txt1.setText("Aim above the bottom left corner of the middle hump on the wall and slightly bellow the top of the hump.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.junglel);
                txt1.setText("Lands in jungle.");
            }
        }
    }

    public void previousPic(View view) {
        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

        SharedPreferences sharedPref= getSharedPreferences("Mirage", 1);
        picNum = sharedPref.getInt("mirage", 0);

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
                img1.setImageResource(R.drawable.windows);
                txt1.setText("Stand in the middle of the window that is furthest to the right of T spawn.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.windowa);
                txt1.setText("Aim above where the right intersection of the wires is and to the left of the horizontal line on antenna. Run and throw just before you hit the fence.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.windowl);
                txt1.setText("Lands in window.");
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
                img1.setImageResource(R.drawable.cttoramps);
                txt1.setText("Stand agains the right wall and at the top of CT stairs.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cttorampa);
                txt1.setText("Aim to the left of the wooden post and align the crosshair with the right edge of the left boxes.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.cttorampl);
                txt1.setText("Lands at T ramp.");
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
                img1.setImageResource(R.drawable.kitchencats);
                txt1.setText("Stand in the middle of the barred door outside apartments.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cata);
                txt1.setText("Aim slightly above the top wire and between the left and middle wooden posts.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.catl);
                txt1.setText("Lands in cat, but they can still see apartments if they move to the other side of cat.");
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
                img1.setImageResource(R.drawable.jungletoramps);
                txt1.setText("Stand by the white on the wall.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.jungletorampa);
                txt1.setText("Aim slightly to the right of the wooden post and align the crosshair with the corner on the left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.jungletorampl);
                txt1.setText("Lands at T ramp.");
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
                img1.setImageResource(R.drawable.bs);
                txt1.setText("Stand at the right edge of the window outside apartments.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.ba);
                txt1.setText("Aim above the middle wooden post and to the left of the further metal support for the AC unite.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bl);
                txt1.setText("Lands in right side of B site.");
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
                img1.setImageResource(R.drawable.kitchencats);
                txt1.setText("Stand in the middle of the barred door outside apartments.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.kitchena);
                txt1.setText("Aim slightly under the wires and align the crosshair with the left edge of the window on the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.kitchenl);
                txt1.setText("Lands blocking view from kitchen window.");
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
                img1.setImageResource(R.drawable.benchs);
                txt1.setText("Stand next to the second wooden post for underpass stairs.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bencha);
                txt1.setText("Aim to the right of the corner on the left wall and above the left wooden post from the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.benchl);
                txt1.setText("Lands at bench next to van.");
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
                img1.setImageResource(R.drawable.stairss);
                txt1.setText("Stand at the corner of the wooden post on T roof outside of T ramp.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.stairsa);
                txt1.setText("Aim the crosshair above the top right corner on the wall and make the tip of the thumb (if using default view model) with the start of small wooden railing.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.stairsl);
                txt1.setText("Lands on A stairs.");
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
                img1.setImageResource(R.drawable.cts);
                txt1.setText("Stand on the corner of T roof.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.cta);
                txt1.setText("Aim slightly to the right of the wooden post. Run and immediately throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.ctl);
                txt1.setText("Lands at CT stairs.");
            }
        }
        if (picNum == 10)
        {
            if(picOrder == 4) {
                picOrder = 1;
            }
            if(picOrder ==0 ) {
                picOrder = 3;
            }
            if(picOrder == 1)
            {
                img1.setImageResource(R.drawable.as);
                txt1.setText("Stand at the edge of T roof.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.aa);
                txt1.setText("Aim above the top left corner of the hump on the wall and align the crosshair with the bottom of the skinny window.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.al);
                txt1.setText("Lands in the middle of sight.");
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
                img1.setImageResource(R.drawable.jungles);
                txt1.setText("Stand between the 2 windows on T roof.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.junglea);
                txt1.setText("Aim above the bottom left corner of the middle hump on the wall and slightly bellow the top of the hump.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.junglel);
                txt1.setText("Lands in jungle.");
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
