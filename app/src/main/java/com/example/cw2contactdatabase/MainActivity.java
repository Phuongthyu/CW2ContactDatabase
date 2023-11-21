package com.example.cw2contactdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveBtn = findViewById(R.id.button);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDetails();
            }
        });

        Button viewDetailsButton = findViewById(R.id.viewDetailsButton);
        viewDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDetails();
            }
        });
    }

    private void saveDetails() {
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        EditText nameTxt = findViewById(R.id.editTextText);
        EditText dobTxt = findViewById(R.id.editTextText2);
        EditText phoneTxt = findViewById(R.id.editTextText3);

        String name = nameTxt.getText().toString();
        String dob = dobTxt.getText().toString();
        String phone = phoneTxt.getText().toString();

        long personId = dbHelper.insertDetails(name, dob, phone);
        Toast.makeText(this, "Person has been created with id: " + personId, Toast.LENGTH_LONG).show();
    }

    private void viewDetails() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}