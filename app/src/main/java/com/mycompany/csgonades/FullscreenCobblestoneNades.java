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
public class FullscreenCobblestoneNades extends ActionBarActivity {
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

        setContentView(R.layout.activity_fullscreen_cobblestone_nades);
        
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
        SharedPreferences sharedPref= getSharedPreferences("Cobble", 1);
        picNum = sharedPref.getInt("cobble", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);
        if (picNum == 1)
        {
            img1.setImageResource(R.drawable.bandhuts);
            txt1.setText("Stand at the corner of the double stacked brown crates.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.blongs);
            txt1.setText("Stand in the corner of the platform in connector.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.bandhuts);
            txt1.setText("Stand at the corner of the double stacked brown crates.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.blongs2);
            txt1.setText("Stand next to the stairs leading from drop area to B site.");
        }
        if (picNum == 5)
        {

            img1.setImageResource(R.drawable.walls);
            txt1.setText("Stand in the corner of the double stacked crates.");
        }
        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.alongs);
            txt1.setText("Stand on the far edge of the wooden railing.");
        }
        if (picNum == 7)
        {
            img1.setImageResource(R.drawable.adoors);
            txt1.setText("Stand in front of the small barred window.");
        }
        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.amids);
            txt1.setText("Stand on the double stacked wooden barrels in the back of A site.");
        }
        if (picNum == 9)
        {
            img1.setImageResource(R.drawable.aarchs);
            txt1.setText("Stand between the two windows that are next to the arch");
        }
        if (picNum == 10)
        {
            img1.setImageResource(R.drawable.awindows);
            txt1.setText("Stand on the left side of the door in ");
        }
       
    }
    public void nextPic(View view) {
        SharedPreferences sharedPref= getSharedPreferences("Cobble", 1);
        picNum = sharedPref.getInt("cobble", 0);

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
                img1.setImageResource(R.drawable.bandhuts);
                txt1.setText("Stand at the corner of the double stacked brown crates.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bsitea);
                txt1.setText("Aim so that the crosshair is above the top left corner of the wooden post sticking out of the wall and align it horizontally flat with the roof on the right.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bsitel);
                txt1.setText("Lands on B site blocking view from doors. It makes it easier to get a plant without getting shot.");
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
                img1.setImageResource(R.drawable.blongs);
                txt1.setText("Stand in the corner of the platform in connector.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.blonga);
                txt1.setText("Aim towards the bottom right corner of the white shaded square on the wall. Then jump and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.blongl);
                txt1.setText("Lands in B long.");
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
                img1.setImageResource(R.drawable.bandhuts);
                txt1.setText("Stand at the corner of the double stacked brown crates.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bhuta);
                txt1.setText("Aim at the top right corner of the wooden post sticking out of the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bhutl);
                txt1.setText("Lands inside of B hut. It completely fills hut.");
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
                img1.setImageResource(R.drawable.blongs2);
                txt1.setText("Stand next to the stairs leading from drop area to B site.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.blonga2);
                txt1.setText("Aim above the middle line on the box and have the crosshair be on the arch behind the box.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.blongl2);
                txt1.setText("Lands in B long.");
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
                img1.setImageResource(R.drawable.walls);
                txt1.setText("Stand in the corner of the double stacked crates.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.walla);
                txt1.setText("Aim at the top of the edge of the broken wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.walll);
                txt1.setText("Lands blocking sight from drop area to broken wall.");
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
                img1.setImageResource(R.drawable.alongs);
                txt1.setText("Stand on the far edge of the wooden railing.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.alonga);
                txt1.setText("Aim at the top of the wooden support, where it connects to the roof.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.alongl);
                txt1.setText("Lands at the stairs of A long.");
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
                img1.setImageResource(R.drawable.adoors);
                txt1.setText("Stand in front of the small barred window.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.adoora);
                txt1.setText("Aim slightly above the right side of the middle wall. Align the edge of the crosshair so that it intersects the top right corner of the wall to the left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.adoorl);
                txt1.setText("Lands in front of the A connector doors.");
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
                img1.setImageResource(R.drawable.amids);
                txt1.setText("Stand on the double stacked wooden barrels in the back of A site.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.amida);
                txt1.setText("Aim above the right edge of the electric post and on the highest wire.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.amidl);
                txt1.setText("Lands down at the bottom of A ramp.");
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
                img1.setImageResource(R.drawable.aarchs);
                txt1.setText("Stand between the two windows that are next to the arch");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.aarcha);
                txt1.setText("Aim above the left side of the window on the right most wall. Align the edge of the crosshair so that it intersects the top right corner of the wall to the left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.aarchl);
                txt1.setText("Lands in front of storage at A.");
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
                img1.setImageResource(R.drawable.awindows);
                txt1.setText("Stand on the left side of the door in ");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.awindowa);
                txt1.setText("Aim to slightly to the left of the middle wooden post at window and put the crosshair between the two bottom electric cords.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.awindowl);
                txt1.setText("Lands in balcony.");
            }
        }
    }
    public void previousPic(View view) {
        SharedPreferences sharedPref= getSharedPreferences("Cobble", 1);
        picNum = sharedPref.getInt("cobble", 0);

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
                img1.setImageResource(R.drawable.bandhuts);
                txt1.setText("Stand at the corner of the double stacked brown crates.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bsitea);
                txt1.setText("Aim so that the crosshair is above the top left corner of the wooden post sticking out of the wall and align it horizontally flat with the roof on the right.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bsitel);
                txt1.setText("Lands on B site blocking view from doors. It makes it easier to get a plant without getting shot.");
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
                img1.setImageResource(R.drawable.blongs);
                txt1.setText("Stand in the corner of the platform in connector.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.blonga);
                txt1.setText("Aim towards the bottom right corner of the white shaded square on the wall. Then jump and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.blongl);
                txt1.setText("Lands in B long.");
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
                img1.setImageResource(R.drawable.bandhuts);
                txt1.setText("Stand at the corner of the double stacked brown crates.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.bhuta);
                txt1.setText("Aim at the top right corner of the wooden post sticking out of the wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.bhutl);
                txt1.setText("Lands inside of B hut. It completely fills hut.");
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
                img1.setImageResource(R.drawable.blongs2);
                txt1.setText("Stand next to the stairs leading from drop area to B site.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.blonga2);
                txt1.setText("Aim above the middle line on the box and have the crosshair be on the arch behind the box.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.blongl2);
                txt1.setText("Lands in B long.");
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
                img1.setImageResource(R.drawable.walls);
                txt1.setText("Stand in the corner of the double stacked crates.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.walla);
                txt1.setText("Aim at the top of the edge of the broken wall.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.walll);
                txt1.setText("Lands blocking sight from drop area to broken wall.");
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
                img1.setImageResource(R.drawable.alongs);
                txt1.setText("Stand on the far edge of the wooden railing.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.alonga);
                txt1.setText("Aim at the top of the wooden support, where it connects to the roof.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.alongl);
                txt1.setText("Lands at the stairs of A long.");
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
                img1.setImageResource(R.drawable.adoors);
                txt1.setText("Stand in front of the small barred window.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.adoora);
                txt1.setText("Aim slightly above the right side of the middle wall. Align the edge of the crosshair so that it intersects the top right corner of the wall to the left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.adoorl);
                txt1.setText("Lands in front of the A connector doors.");
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
                img1.setImageResource(R.drawable.amids);
                txt1.setText("Stand on the double stacked wooden barrels in the back of A site.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.amida);
                txt1.setText("Aim above the right edge of the electric post and on the highest wire.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.amidl);
                txt1.setText("Lands down at the bottom of A ramp.");
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
                img1.setImageResource(R.drawable.aarchs);
                txt1.setText("Stand between the two windows that are next to the arch");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.aarcha);
                txt1.setText("Aim above the left side of the window on the right most wall. Align the edge of the crosshair so that it intersects the top right corner of the wall to the left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.aarchl);
                txt1.setText("Lands in front of storage at A.");
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
                img1.setImageResource(R.drawable.awindows);
                txt1.setText("Stand on the left side of the door in ");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.awindowa);
                txt1.setText("Aim to slightly to the left of the middle wooden post at window and put the crosshair between the two bottom electric cords.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.awindowl);
                txt1.setText("Lands in balcony.");
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
