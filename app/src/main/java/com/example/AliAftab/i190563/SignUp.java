package com.example.AliAftab.i190563;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    private Spinner spinnerCountry;
    private Spinner spinnerCity;
    private Map<String, String[]> countryCityMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        TextView goBackTextView = findViewById(R.id.loginTextView); // Make sure to add this ID in the XML
        goBackTextView.setOnClickListener(v -> finish()); // This will close the current activity and go back to the previous one

        TextView signUpTextView = findViewById(R.id.signUpTextView);
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the MainActivity when the "Sign Up" TextView is clicked
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);

                // Display a toast message
                Toast.makeText(SignUp.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerCity = findViewById(R.id.spinnerCity);

        setupSpinners();

    }

    private void setupSpinners() {
        String[] countries = {"Pakistan", "England", "Australia"};
        countryCityMap = new HashMap<>();

        // Define cities for each country
        countryCityMap.put("Pakistan", new String[]{"Karachi", "Lahore", "Islamabad"});
        countryCityMap.put("England", new String[]{"London", "Manchester", "Liverpool"});
        countryCityMap.put("Australia", new String[]{"Sydney", "Melbourne", "Brisbane"});

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(countryAdapter);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedCountry = spinnerCountry.getSelectedItem().toString();
                updateCitySpinner(selectedCountry);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });
    }

    private void updateCitySpinner(String country) {
        String[] cities = countryCityMap.get(country);
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(cityAdapter);
    }
}
