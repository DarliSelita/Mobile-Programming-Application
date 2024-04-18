package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cube extends AppCompatActivity {

    EditText cube_edge;
    TextView title, result;
    Button btnCalculateVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        cube_edge = findViewById(R.id.editText_cube_edge);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume);

        btnCalculateVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateVolume();
            }
        });
    }

    private void calculateVolume() {
        String edgeText = cube_edge.getText().toString();

        if (!edgeText.isEmpty()) {
            double edge = Double.parseDouble(edgeText);

            // V = a^3
            double volume = Math.pow(edge, 3);
            DecimalFormat df = new DecimalFormat("#,###,##0.00");
            result.setText("Volume = " + df.format(volume) + " m^3");
        } else {
            result.setText("Please enter the edge length.");
        }
    }
}
