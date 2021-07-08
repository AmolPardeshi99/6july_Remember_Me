package com.example.a6july_remember_me;

import android.content.Context;
import android.content.SharedPreferences;

public class preferenceHelper {
    private static final String Preference_Key = "com.remember.sharedpreferences";

    public static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(Preference_Key,Context.MODE_PRIVATE);
    }

    public static void StringToPreferences(Context context, String key,String value){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringFromPrefernce(Context context,String key){
        return getSharedPreferences(context).getString(key,"Null");
    }
}
