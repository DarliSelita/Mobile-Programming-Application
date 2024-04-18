package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1- AdapterView: GridView
    GridView gridView;

    // 2- Data Source: ArrayList<Shape>
    ArrayList<Shape> shapeArrayList;

    // 3- Adapter: MyCustomAdapter
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        shapeArrayList = new ArrayList<>();

        Shape s1 = new Shape(R.drawable.sphere, "Sphere");
        Shape s2 = new Shape(R.drawable.cylinder, "Cylinder");
        Shape s3 = new Shape(R.drawable.cube, "Cube");
        Shape s4 = new Shape(R.drawable.prism, "Prism");

        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);

        adapter = new MyCustomAdapter(shapeArrayList, getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Shape clickedShape = shapeArrayList.get(position);
                Intent intent;
                switch (clickedShape.getShapeName()) {
                    case "Sphere":
                        intent = new Intent(MainActivity.this, Sphere.class);
                        startActivity(intent);
                        break;
                    case "Cylinder":
                        intent = new Intent(MainActivity.this, Cylinder.class);
                        startActivity(intent);
                        break;
                    case "Cube":
                        intent = new Intent(MainActivity.this, Cube.class);
                        startActivity(intent);
                        break;
                    case "Prism":
                        intent = new Intent(MainActivity.this, Prism.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

}
