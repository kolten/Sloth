package me.koltensturgill.sloth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    Switch switchTheme;
    Button btnTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Utils.setThemeToActivity(this, false);
        super.onCreate(savedInstanceState);
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
