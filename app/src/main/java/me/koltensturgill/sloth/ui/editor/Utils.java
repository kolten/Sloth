package me.koltensturgill.sloth.ui.editor;

import android.app.Activity;
import android.content.res.Resources;

import me.koltensturgill.sloth.R;

public class Utils
{
    private static int theme = R.style.AppTheme;
    private static boolean switchCheck = false;

    public static void setThemeToActivity(Activity activity)
    {
//        if (Utils.theme == R.style.AppTheme)
//        {
//            activity.setTheme(R.style.AppTheme);
//        }
        activity.setTheme(theme);
//        else if (Utils.theme == R.style.AppDarkTheme)
//        {
//            activity.setTheme(R.style.AppDarkTheme);
//        }
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

    public static boolean checkTheme(int intTheme)
    {
        if (theme == intTheme)
        {
            return true;
        }
        else {return false;}
    }
}
