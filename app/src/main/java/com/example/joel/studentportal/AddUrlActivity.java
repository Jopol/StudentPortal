package com.example.joel.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.List;

public class AddUrlActivity extends AppCompatActivity {

    Button addButton;
    private EditText editTextUrl;
    private EditText editTextTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addurl);

        editTextUrl = findViewById(R.id.editTextUrl);
        editTextTitle = findViewById(R.id.editTextTitle);
        Button addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String url = editTextUrl.getText().toString();
               String title = editTextTitle.getText().toString();
//
//
//                Intent intent = new Intent(AddUrlActivity.this, MainActivity.class);
//                intent.putExtra("urlExtra", url);
//                intent.putExtra("titleExtra", title);
//                startActivity(intent);
                Intent i = getIntent();
                List<Link> NewUrlList = (List<Link>) i.getSerializableExtra(
                        MainActivity.Extra_data
                );
                NewUrlList.add(new Link(url, title));
                Intent intent = new Intent(
                        AddUrlActivity.this,
                        MainActivity.class
                );
                intent.putExtra(MainActivity.Extra_data, (Serializable) NewUrlList);
                startActivity(intent);
            }
        });
    }
}
