package com.example.andriodlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityLifecycle extends AppCompatActivity {

    EditText emailText;
    SharedPreferences prefs = null;
    protected void onCreate(Bundle savedInstanceState) {
        //my program starts here
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lifecycle);
        Intent goToProfile = new Intent(MainActivityLifecycle.this,ProfileActivity.class);
        prefs = getSharedPreferences("lab3File",Context.MODE_PRIVATE);

        String savedString = prefs.getString("ReverseName","Default value");
        emailText = findViewById(R.id.emailText);
        emailText.setText(savedString);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(btn -> {
            goToProfile.putExtra("email",emailText.getText().toString());
            startActivity(goToProfile);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveSharedPrefs(emailText.getText().toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void saveSharedPrefs(String stringToSave) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("ReserveName", stringToSave);
        editor.commit();
    }
}
