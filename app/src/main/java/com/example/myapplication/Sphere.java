package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Sphere extends AppCompatActivity {

    EditText sphere_radius, sphere_height;
    TextView title, result;
    Button btnCalculateVolume, btnCalculateSurfaceArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);

        sphere_radius = findViewById(R.id.editText_sphere_radius);
        sphere_height = findViewById(R.id.editText_sphere_height);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume);
        btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area);

        btnCalculateVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateVolume();
            }
        });

        btnCalculateSurfaceArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSurfaceArea();
            }
        });
    }

    private void calculateVolume() {
        String radiusText = sphere_radius.getText().toString();
        String heightText = sphere_height.getText().toString();

        if (!radiusText.isEmpty() && !heightText.isEmpty()) {
            double radius = Double.parseDouble(radiusText);
            double height = Double.parseDouble(heightText);

            // V = π * r^2 * h
            double volume = Math.PI * Math.pow(radius, 2) * height;
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            result.setText("Volume = " + df.format(volume) + " m^3");
        } else {
            result.setText("Please enter both radius and height.");
        }
    }

    private void calculateSurfaceArea() {
        String radiusText = sphere_radius.getText().toString();

        if (!radiusText.isEmpty()) {
            double radius = Double.parseDouble(radiusText);

            // A = 4 * π * r^2
            double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            result.setText("Surface Area = " + df.format(surfaceArea) + " m^2");
        } else {
            result.setText("Please enter the radius.");
        }
    }
}
