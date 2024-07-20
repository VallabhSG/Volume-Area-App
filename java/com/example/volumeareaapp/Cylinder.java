package com.example.volumeareaapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cylinder extends AppCompatActivity {
    EditText cylinRadius, cylnHeight;
    TextView title, result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);
        cylinRadius = findViewById(R.id.editText_sphere);
        cylnHeight = findViewById(R.id.editText);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = cylinRadius.getText().toString();
                String height = cylnHeight.getText().toString();

                int r = Integer.parseInt(radius);
                int h = Integer.parseInt(height);

                double volume = ((double) 22 /7)*r*r*h;

                result.setText("V = "+volume+" m^3");
            }
        });
    }
}