package com.example.cw2contactdatabase;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        String details = dbHelper.getDetails();
        TextView detailsTxt = findViewById(R.id.detailsText);
        detailsTxt.setText(details);
    }
}