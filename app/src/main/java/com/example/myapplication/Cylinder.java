package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cylinder extends AppCompatActivity {

    EditText cylinder_radius, cylinder_height;
    TextView title, result;
    Button btnCalculateVolume, btnCalculateSurfaceArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cylinder);

        cylinder_radius = findViewById(R.id.editText_cylinder_radius);
        cylinder_height = findViewById(R.id.editText_cylinder_height);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume_cylinder);
        btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area_cylinder);

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
        String radiusText = cylinder_radius.getText().toString();
        String heightText = cylinder_height.getText().toString();

        if (!radiusText.isEmpty() && !heightText.isEmpty()) {
            double radius = Double.parseDouble(radiusText);
            double height = Double.parseDouble(heightText);

            // V = π * r^2 * h
            double volume = Math.PI * Math.pow(radius, 2) * height;
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            result.setText("Volume = " + df.format(volume) + " m^3");
        } else {
            result.setText("Please enter the radius and height.");
        }
    }

    private void calculateSurfaceArea() {
        String radiusText = cylinder_radius.getText().toString();
        String heightText = cylinder_height.getText().toString();

        if (!radiusText.isEmpty() && !heightText.isEmpty()) {
            double radius = Double.parseDouble(radiusText);
            double height = Double.parseDouble(heightText);

            // Surface Area = 2πrh + 2πr^2
            double surfaceArea = 2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2);
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            result.setText("Surface Area = " + df.format(surfaceArea) + " m^2");
        } else {
            result.setText("Please enter the radius and height.");
        }
    }
}
