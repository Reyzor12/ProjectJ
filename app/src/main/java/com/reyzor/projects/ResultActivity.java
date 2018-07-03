package com.reyzor.projects;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.reyzor.projects.data.CountryDatabaseImp;
import com.reyzor.projects.entity.AdventureType;
import com.reyzor.projects.entity.Climate;
import com.reyzor.projects.entity.Country;
import com.reyzor.projects.entity.CountryFilterImp;

import java.util.List;

public class ResultActivity extends AppCompatActivity
{

    /*private TableLayout view;
    private Countries[] countries;
    private ArrayAdapter<Countries> adapter;
    private Integer columns = 1;
    private Integer rows = 1;

    private String TAG = "ResultActivity";*/

    private TableLayout resultLayout;
    private List<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        Boolean beach = intent.getExtras().getBoolean("beach");
        Boolean money = intent.getExtras().getBoolean("money");
        Boolean english = intent.getExtras().getBoolean("english");
        Climate climate = (Climate) intent.getExtras().getSerializable("climate");
        AdventureType adventure = (AdventureType)intent.getExtras().getSerializable("adventure");
        resultLayout = findViewById(R.id.resultLayout);
        //countries = (new CountryDatabaseImp()).getCountryWithFilter(new CountryFilterImp(null, beach, money, climate, english, adventure));
        countries = new CountryDatabaseImp().getAllCountries();

        if (countries.isEmpty())
        {
            ConstraintLayout layout = new ConstraintLayout(this);
            layout.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            TextView textView = new TextView(this);
            textView.setText("Countries not found!");
            textView.setTextSize(34);
            textView.setTextColor(Color.WHITE);
            textView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            textView.setGravity(Gravity.CENTER);
            layout.addView(textView);
            resultLayout.addView(layout);
        }
        else
        {
            for (Country country : countries)
            {
                TableRow row = new TableRow(this);
                row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                TextView content = new TextView(this);
                content.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                content.setBackgroundResource(country.getImage());
                content.setText(country.getName());

                row.addView(content);
                resultLayout.addView(row);
            }
            /*ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(this, R.layout.item_result, R.id.country, countries.toArray(new Country[countries.size()]));
            resultLayout.setAdapter(adapter);*/

        }
        /*resultLayout.setNumColumns(GridView.AUTO_FIT);
        resultLayout.setVerticalSpacing(5);
        resultLayout.setHorizontalSpacing(5);
        resultLayout.setStretchMode(GridView.STRETCH_SPACING);*/
        //text.setText(beach + " " + money+ " " + english + " " + climate + " " + adventure);
        /*view = (TableLayout) findViewById(R.id.results);
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
        }*/

    }
}
