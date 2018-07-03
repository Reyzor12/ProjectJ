package com.reyzor.projects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.reyzor.projects.entity.AdventureType;
import com.reyzor.projects.entity.Climate;

public class MainScreen extends AppCompatActivity
{
    private static final String TAG = "MainScreen";

    private CheckBox beachCheckBox;
    private CheckBox moneyCheckBox;
    private CheckBox englishCheckBox;

    private Spinner climateSpinner;
    private Spinner adventureSpinner;

    private Button findButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        beachCheckBox = findViewById(R.id.beach);
        moneyCheckBox = findViewById(R.id.money);
        englishCheckBox = findViewById(R.id.english);

        climateSpinner = findViewById(R.id.climate);
        adventureSpinner = findViewById(R.id.adventure);

        findButton = findViewById(R.id.find);

        ArrayAdapter<Climate> adapter = new ArrayAdapter<Climate>(this, android.R.layout.simple_spinner_item, Climate.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        climateSpinner.setAdapter(adapter);
        climateSpinner.setPrompt("Climate");
        climateSpinner.setSelection(0);

        ArrayAdapter<AdventureType> adapterAdventure = new ArrayAdapter<AdventureType>(this, android.R.layout.simple_spinner_item, AdventureType.values());
        adapterAdventure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adventureSpinner.setAdapter(adapterAdventure);
        adventureSpinner.setPrompt("Type of adventure");
        adventureSpinner.setSelection(0);
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        intent.putExtra("beach",beachCheckBox.isChecked());
        intent.putExtra("money", moneyCheckBox.isChecked());
        intent.putExtra("english", englishCheckBox.isChecked());
        intent.putExtra("climate", (Climate)climateSpinner.getSelectedItem());
        intent.putExtra("adventure", (AdventureType) adventureSpinner.getSelectedItem());
        startActivity(intent);
    }
}
