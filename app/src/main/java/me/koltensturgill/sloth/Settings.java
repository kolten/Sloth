package me.koltensturgill.sloth;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import me.koltensturgill.sloth.ui.editor.Utils;

public class Settings extends AppCompatActivity {

    Switch switchTheme;
    Button btnTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Utils.setThemeToActivity(this);
        setContentView(R.layout.activity_settings);

        switchTheme = findViewById(R.id.swDarkTheme);
        switchTheme.setChecked(Utils.isSwitchChecked());
        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if (b)
                {
                    Utils.changeTheme(R.style.AppDarkTheme);
                }
                else
                {
                    Utils.changeTheme(R.style.AppTheme);
                }
                Utils.changeSwitchCheck(b);
                recreate();
            }
        });
    }
}
