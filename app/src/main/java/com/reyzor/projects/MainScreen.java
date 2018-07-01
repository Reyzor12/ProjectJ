package com.reyzor.projects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.reyzor.projects.data.DataBase;

public class MainScreen extends AppCompatActivity
{
    private String TAG = "MainScreen";
    private Spinner climateSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DataBase.getClimate());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        climateSpinner = (Spinner) findViewById(R.id.climate);
        climateSpinner.setAdapter(adapter);
        climateSpinner.setPrompt("Климат");
        climateSpinner.setSelection(0);

        Button button = (Button) findViewById(R.id.find);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                Log.d(TAG, intent.toString());
                startActivity(intent);
            }
        });
    }
}
