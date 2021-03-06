package com.reyzor.projects;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.widget.TextViewCompat;
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
                row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                row.setPadding(20,10,20,10);
                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), ActivityMap.class);
                        intent.putExtra("countryName", country.getName());
                        intent.putExtra("coordinate", country.getCountryDescription().getCoordinate());
                        startActivity(intent);
                    }
                });

                LinearLayout layout = new LinearLayout(this);
                layout.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                /*layout.setBackgroundColor(Color.GRAY);
                layout.getBackground().setAlpha(80);*/
                layout.setBackgroundResource(R.layout.item);

                ImageView image = new ImageView(this);
                image.setImageResource(country.getImage());
                image.setScaleType(ImageView.ScaleType.FIT_XY);
                image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0f));
                image.getLayoutParams().height = 400;
                image.getLayoutParams().width = 400;
                layout.addView(image);

                TextView content = new TextView(this);
                StringBuilder sb = new StringBuilder(country.getName()+"\n");
                sb.append("Description:\n");
                sb.append(country.getCountryDescription().getTextDescription());
                content.setText(sb.toString());
                content.setTextColor(Color.YELLOW);
                content.setPadding(40, 0 , 0, 0);
                content.setLayoutParams(new LinearLayout.LayoutParams(600, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
                //content.getLayoutParams().width = 100;
                layout.addView(content);

                row.addView(layout);
                resultLayout.addView(row);
            }
            /*ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(this, R.layout.item_result, R.id.country, countries.toArray(new Country[countries.size()]));
            resultLayout.setAdapter(adapter);*/

        }

    }
}
