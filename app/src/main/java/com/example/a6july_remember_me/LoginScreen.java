package com.example.a6july_remember_me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtUsername, mEtPassword;
    private CheckBox mChkRemeberMe;
    private Button mBtnLogin;
    private final String Preference_Username = "Preference_Key";
    private boolean isRemeberMechecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initViews();
        isUserDataStored();

    }

    private void isUserDataStored() {
        String username = preferenceHelper.getStringFromPrefernce(LoginScreen.this, Preference_Username);
        if (username != "Null") {
            Intent intent = new Intent(LoginScreen.this, Home_Screen.class);
            startActivity(intent);
        }

    }

    private void initViews() {
        mEtUsername = findViewById(R.id.etUserName);
        mEtPassword = findViewById(R.id.etPassword);
        mChkRemeberMe = findViewById(R.id.checkBox);
        mBtnLogin = findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(this);
        mChkRemeberMe.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            if (isRemeberMechecked) {
                preferenceHelper.StringToPreferences(LoginScreen.this, Preference_Username, mEtUsername.getText().toString());
                Intent intent = new Intent(LoginScreen.this, Home_Screen.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(LoginScreen.this, Home_Screen.class);
                startActivity(intent);
            }

        } else if (v.getId() == R.id.checkBox) {

            isRemeberMechecked = ((CheckBox)v).isChecked();
        }

    }

}