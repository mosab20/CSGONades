package com.mycompany.csgonades;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.mycompany.csgonades.R;

public class Settings extends ActionBarActivity {
    int toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Switch mSwitch = (Switch) findViewById(R.id.switch1);
        SharedPreferences sharedPref= getSharedPreferences("switch", 2);
        toggle = sharedPref.getInt("switch", 0);
        if (toggle == 1)
        {
            mSwitch.setChecked(true);
        }
        else if(toggle == 0)
        {
            mSwitch.setChecked(false);
        }
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferences guessString = getSharedPreferences("switch", 2);
                    //now get Editor
                    SharedPreferences.Editor editor1 = guessString.edit();
                    //put your value
                    editor1.putInt("switch", 1);
                    //commits your edits
                    editor1.commit();
                } else {
                    SharedPreferences guessString = getSharedPreferences("switch", 2);
                    //now get Editor
                    SharedPreferences.Editor editor1 = guessString.edit();
                    //put your value
                    editor1.putInt("switch", 0);
                    //commits your edits
                    editor1.commit();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
