package com.example.AliAftab.i190563;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        TextView goBackTextView = findViewById(R.id.goBackTextView); // Make sure to add this ID in the XML
        goBackTextView.setOnClickListener(v -> finish()); // This will close the current activity and go back to the previous one
    }
}
