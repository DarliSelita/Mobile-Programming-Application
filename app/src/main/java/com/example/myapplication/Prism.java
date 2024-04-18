package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Prism extends AppCompatActivity {

    EditText prism_base, prism_height;
    TextView title, result;
    Button btnCalculateVolume, btnCalculateSurfaceArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);

        prism_base = findViewById(R.id.editText_prism_base);
        prism_height = findViewById(R.id.editText_prism_height);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume_prism);
        btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area_prism);

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
        String baseText = prism_base.getText().toString();
        String heightText = prism_height.getText().toString();

        if (!baseText.isEmpty() && !heightText.isEmpty()) {
            double baseArea = Double.parseDouble(baseText);
            double height = Double.parseDouble(heightText);

            // V = base area * height
            double volume = baseArea * height;
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            result.setText("Volume = " + df.format(volume) + " m^3");
        } else {
            result.setText("Please enter the base area and height.");
        }
    }

    private void calculateSurfaceArea() {
        String baseText = prism_base.getText().toString();
        String heightText = prism_height.getText().toString();

        if (!baseText.isEmpty() && !heightText.isEmpty()) {
            double baseArea = Double.parseDouble(baseText);
            double height = Double.parseDouble(heightText);

            // Surface Area = 2 * base area + perimeter * height
            double surfaceArea = 2 * baseArea + (baseArea * 4) * height;
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            result.setText("Surface Area = " + df.format(surfaceArea) + " m^2");
        } else {
            result.setText("Please enter the base area and height.");
        }
    }
}
