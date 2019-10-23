package me.koltensturgill.sloth;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;

import java.lang.annotation.Target;

import me.koltensturgill.sloth.R;


//This class has methods to set theme to activity by getting activity, checks if its main activity or not
//change theme private variable from settings when switched to/from dark theme
//two methods for switch that tracks the position of switch, returns true if checked
//changes private variable switchCheck to whatever boolean received
public class Utils
{
    private static int theme = R.style.AppTheme;
    private static boolean switchCheck = false;

    public static void setThemeToActivity(Activity activity, boolean isMain)
    {
        if (isMain)
        {
            if (theme == R.style.AppTheme)
            {
                activity.setTheme(R.style.AppTheme_NoActionBar);
            }
            else
            {
                activity.setTheme(R.style.AppDarkTheme_NoActionBar);
            }
        }
        else
        {
            activity.setTheme(theme);
        }
    }

    public static void changeTheme(int intTheme)
    {
        theme = intTheme;
    }


    public static boolean isSwitchChecked()
    {
        return switchCheck;
    }

    public static void changeSwitchCheck(boolean check)
    {
        switchCheck = check;
    }

}
