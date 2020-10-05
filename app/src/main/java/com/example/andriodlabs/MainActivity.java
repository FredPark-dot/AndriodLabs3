package com.example.andriodlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);
        //setContentView(R.layout.activity_main_grid);
        //setContentView(R.layout.activity_main_relative);

        Switch s = findViewById(R.id.s);


        final Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){

                        Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_message),Toast.LENGTH_LONG).show();
                    }
                }
        );

        s.setOnCheckedChangeListener((cb,b) ->
        {if(b) Snackbar.make(s,"The switch is now on",Snackbar.LENGTH_LONG).setAction(R.string.snackbar_message,click -> cb.setChecked(!b)).show();
        else
        Snackbar.make(s,"The switch is now off",Snackbar.LENGTH_LONG).setAction(R.string.snackbar_message,click -> cb.setChecked(!b)).show();
        });
        }
    };