package me.koltensturgill.sloth.ui.editor;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;

import java.lang.annotation.Target;

import me.koltensturgill.sloth.R;

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
