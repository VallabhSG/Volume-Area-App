package com.example.volumeareaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Shape> shapeArrayList;
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
                Shape selectedShape = shapeArrayList.get(position);
                Class<?> shapeActivityClass = getShapeActivityClass(selectedShape.getShapeName());
                if (shapeActivityClass != null) {
                    Intent i = new Intent(getApplicationContext(), shapeActivityClass);
                    startActivity(i);
                }
            }
        });
    }

    private Class<?> getShapeActivityClass(String s) {
        // Map shape names to their corresponding activity classes
        switch (s) {
            case "Sphere":
                return Sphere.class;
            case "Cylinder":
                return Cylinder.class;
            case "Cube":
                return Cube.class;
            case "Prism":
                return Prism.class;
            default:
                return null; // Return null if activity class not found for the shape
        }
    }
}
