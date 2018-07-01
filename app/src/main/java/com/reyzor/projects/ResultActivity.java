package com.reyzor.projects;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.reyzor.projects.data.DataBase;
import com.reyzor.projects.entity.Countries;

public class ResultActivity extends AppCompatActivity
{

    private TableLayout view;
    private Countries[] countries;
    private ArrayAdapter<Countries> adapter;
    private Integer columns = 1;
    private Integer rows = 1;

    private String TAG = "ResultActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        view = (TableLayout) findViewById(R.id.results);
        countries = DataBase.getCountries();
        for (int i = 0; i < rows; i++)
        {
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setBackgroundColor(Color.BLUE);

            TableRow row = new TableRow(this);
            //row.setBackgroundColor(Color.GREEN);
            row.setLayoutParams(new TableRow.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            for (int j = 0; j < columns; j++)
            {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(countries[j].getImageId());
                TextView textView = new TextView(this);
                //textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                textView.setText(countries[j].getName());
                textView.setTextColor(Color.GREEN);
                textView.setTextSize(20f);
                textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                textView.setBackgroundResource(countries[j].getImageId());
                //textView.setBackgroundColor(Color.GREEN);
                //layout.addView(imageView);
                layout.addView(textView);
                //layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            }
            row.addView(layout);
            view.addView(row, i);
        }

    }
}