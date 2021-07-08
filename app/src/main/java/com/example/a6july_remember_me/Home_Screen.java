package com.example.a6july_remember_me;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Home_Screen extends AppCompatActivity {

    TextView mtvUsername;
    private final String Preference_Key = "Preference_Key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        mtvUsername = findViewById(R.id.textView);
        String username = preferenceHelper.getStringFromPrefernce(Home_Screen.this,Preference_Key);
        mtvUsername.setText(username);
    }
}