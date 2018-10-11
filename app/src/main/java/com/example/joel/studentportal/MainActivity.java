package com.example.joel.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.joel.studentportal.R.*;

public class MainActivity extends AppCompatActivity {

    private List<Link> NewUrlList = new ArrayList<>();

    public static final String Extra_data = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if ((List<Link>) intent.getSerializableExtra(Extra_data) != null) {
            NewUrlList = (List<Link>) intent.getSerializableExtra(Extra_data);
        }


        final RecyclerView mRecyclerView = findViewById(id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        Adapter mAdapter = new Adapter(this,NewUrlList);
        mRecyclerView.setAdapter(mAdapter);

//        String url = getIntent().getStringExtra("urlExtra");
//        String title = getIntent().getStringExtra("titleExtra");

//        if (url != null && title != null){
//            NewUrlList.add(new Link(url, title));
//        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    Intent intent = new Intent(MainActivity.this, AddUrlActivity.class);
                    intent.putExtra(Extra_data,(Serializable) NewUrlList );
                    startActivity(intent);
                }
            }
        });

    }

}
