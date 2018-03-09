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
public class FullscreenNukeNades extends ActionBarActivity {
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

        setContentView(R.layout.activity_fullscreen_nuke_nades);

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

        SharedPreferences sharedPref= getSharedPreferences("Nuke", 1);
        picNum = sharedPref.getInt("nuke", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

        if (picNum == 1)
        {
            img1.setImageResource(R.drawable.heavenglasss);
            txt1.setText("Stand on the railing at t roof so that the crosshair is on the dot.");
        }
        if (picNum == 2)
        {
            img1.setImageResource(R.drawable.heavennowins);
            txt1.setText("Stand on the line that is on the pipe next to the big silo.");
        }
        if (picNum == 3)
        {
            img1.setImageResource(R.drawable.outgarages);
            txt1.setText("Stand against the fence as shown in the image.");
        }
        if (picNum == 4)
        {
            img1.setImageResource(R.drawable.secrets);
            txt1.setText("Stand on the metal loop on the blue box.");
        }
        if (picNum == 5)
        {

            img1.setImageResource(R.drawable.ramps);
            txt1.setText("Stand against the wall at the third pipe from the left.");
        }
        if (picNum == 6)
        {
            img1.setImageResource(R.drawable.vendings);
            txt1.setText("Stand in front of the door side facing vending entrance to ramp.");
        }

        if (picNum == 7)
        {
            img1.setImageResource(R.drawable.toutsides);
            txt1.setText("Stand against the ct fence so that the corner of the red box facing you is aligned with the corner of the main building.");
        }
        if (picNum == 8)
        {
            img1.setImageResource(R.drawable.heavenglasss);
            txt1.setText("Stand on the railing at t roof so that the crosshair is on the dot.");
        }
        if (picNum == 9)
        {
            img1.setImageResource(R.drawable.outcats);
            txt1.setText("Stand against the fence as shown in the image.");
        }
    }

    public void nextPic(View view) {
        SharedPreferences sharedPref= getSharedPreferences("Nuke", 1);
        picNum = sharedPref.getInt("nuke", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

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
                img1.setImageResource(R.drawable.heavenglasss);
                txt1.setText("Stand on the railing at t roof so that the crosshair is on the dot.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.heavenglassa);
                txt1.setText("Aim slightly above the roof slightly left of the corner.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.heavenglassl);
                txt1.setText("Lands at heaven if glass is not broken.");
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
                img1.setImageResource(R.drawable.heavennowins);
                txt1.setText("Stand on the line that is on the pipe next to the big silo.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.heavennowina);
                txt1.setText("Aim between the two lines on the wall right below the roof edge while crouched then stand up and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.heavennowinl);
                txt1.setText("Lands at heaven if glass is broken.");
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
                img1.setImageResource(R.drawable.outgarages);
                txt1.setText("Stand against the fence as shown in the image.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.outgaragea);
                txt1.setText("align the crosshair vertically with the left edge of the label on the red box and horizontally with the roof edge on the left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.outgaragel);
                txt1.setText("Lands blocking garage.");
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
                img1.setImageResource(R.drawable.secrets);
                txt1.setText("Stand on the metal loop on the blue box.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.secreta);
                txt1.setText("align the crosshair vertically with the shadow of the pipe going down the side of the silo and horizontally with the top corner of that pipe.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.secretl);
                txt1.setText("Lands in secret.");
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
                img1.setImageResource(R.drawable.ramps);
                txt1.setText("Stand against the wall at the third pipe from the left.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.rampa);
                txt1.setText("Aim at the crossing that the glass frames meet, then quickly run and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.rampl);
                txt1.setText("Lands at ramp.");
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
                img1.setImageResource(R.drawable.vendings);
                txt1.setText("Stand in front of the door side facing vending entrance to ramp.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.vendinga);
                txt1.setText("Aim just under the row of vents aligned vertically with the right side of the middle light.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.vendingl);
                txt1.setText("Lands in vending.");
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
                img1.setImageResource(R.drawable.toutsides);
                txt1.setText("Stand against the ct fence so that the corner of the red box facing you is aligned with the corner of the main building.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.toutsidea);
                txt1.setText("Aim between the corner of the main building and the structure on the left and above the right the structure on the left.  Run forwards and throw once you reach the yellow lines on the floor.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.toutsidel);
                txt1.setText("Lands at the t side of outside.");
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
                img1.setImageResource(R.drawable.heavenglasss);
                txt1.setText("Stand on the railing at t roof so that the crosshair is on the dot.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.heavenglassa);
                txt1.setText("Aim slightly above the roof slightly left of the corner.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.silol);
                txt1.setText("Lands on the silos at A site only if the roof glass is broken.");
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
                img1.setImageResource(R.drawable.outcats);
                txt1.setText("Stand against the fence as shown in the image.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.outcata);
                txt1.setText("Aim so that the crosshair is vertically between the pole on the left and the lach on the right while being aligned with the corner where the white wall meets the blue wall on the far left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.outcatl);
                txt1.setText("Lands on the catwalk corner.");
            }
        }
    }

    public void previousPic(View view) {
        SharedPreferences sharedPref= getSharedPreferences("Nuke", 1);
        picNum = sharedPref.getInt("nuke", 0);

        ImageView img1 = (ImageView) findViewById(R.id.image1);

        TextView txt1 = (TextView) findViewById(R.id.picText);

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
                img1.setImageResource(R.drawable.heavenglasss);
                txt1.setText("Stand on the railing at t roof so that the crosshair is on the dot.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.heavenglassa);
                txt1.setText("Aim slightly above the roof slightly left of the corner.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.heavenglassl);
                txt1.setText("Lands at heaven if glass is not broken.");
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
                img1.setImageResource(R.drawable.heavennowins);
                txt1.setText("Stand on the line that is on the pipe next to the big silo.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.heavennowina);
                txt1.setText("Aim between the two lines on the wall right below the roof edge while crouched then stand up and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.heavennowinl);
                txt1.setText("Lands at heaven if glass is broken.");
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
                img1.setImageResource(R.drawable.outgarages);
                txt1.setText("Stand against the fence as shown in the image.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.outgaragea);
                txt1.setText("align the crosshair vertically with the left edge of the label on the red box and horizontally with the roof edge on the left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.outgaragel);
                txt1.setText("Lands blocking garage.");
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
                img1.setImageResource(R.drawable.secrets);
                txt1.setText("Stand on the metal loop on the blue box.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.secreta);
                txt1.setText("align the crosshair vertically with the shadow of the pipe going down the side of the silo and horizontally with the top corner of that pipe.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.secretl);
                txt1.setText("Lands in secret.");
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
                img1.setImageResource(R.drawable.ramps);
                txt1.setText("Stand against the wall at the third pipe from the left.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.rampa);
                txt1.setText("Aim at the crossing that the glass frames meet, then quickly run and throw.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.rampl);
                txt1.setText("Lands at ramp.");
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
                img1.setImageResource(R.drawable.vendings);
                txt1.setText("Stand in front of the door side facing vending entrance to ramp.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.vendinga);
                txt1.setText("Aim just under the row of vents aligned vertically with the right side of the middle light.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.vendingl);
                txt1.setText("Lands in vending.");
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
                img1.setImageResource(R.drawable.toutsides);
                txt1.setText("Stand against the ct fence so that the corner of the red box facing you is aligned with the corner of the main building.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.toutsidea);
                txt1.setText("Aim between the corner of the main building and the structure on the left and above the right the structure on the left.  Run forwards and throw once you reach the yellow lines on the floor.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.toutsidel);
                txt1.setText("Lands at the t side of outside.");
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
                img1.setImageResource(R.drawable.heavenglasss);
                txt1.setText("Stand on the railing at t roof so that the crosshair is on the dot.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.heavenglassa);
                txt1.setText("Aim slightly above the roof slightly left of the corner.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.silol);
                txt1.setText("Lands on the silos at A site only if the roof glass is broken.");
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
                img1.setImageResource(R.drawable.outcats);
                txt1.setText("Stand against the fence as shown in the image.");
            }
            if(picOrder == 2)
            {
                img1.setImageResource(R.drawable.outcata);
                txt1.setText("Aim so that the crosshair is vertically between the pole on the left and the lach on the right while being aligned with the corner where the white wall meets the blue wall on the far left.");
            }
            if(picOrder == 3)
            {
                img1.setImageResource(R.drawable.outcatl);
                txt1.setText("Lands on the catwalk corner.");
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
