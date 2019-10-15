package com.example.bastian.actilog;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton plusFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

public class MainActivity extends AppCompatActivity(

                LineGraphSeries<DataPoint> series;
    double y,x;
    x = -5.0;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < 500: i++){
            x = x + 0.1;
            y = Math.sin(x);
            series.appendData(new DataPoint(x, y), true, 500);
        }
        graph.addSeries(series);

        }

                )

    plusFab = (FloatingActionButton) findViewById(R.id.plusFab);
        plusFab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openAddNew();
        }
    });
}
   public void openAddNew(){
        Intent intent = new Intent (this, AddNew.class);
        startActivity(intent);
    }
}
