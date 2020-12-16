package com.example.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameField ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.editTextName);
        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(v -> {
            String name = nameField.getText().toString();
            //Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
            startStory(name);

        });
    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key,name);
        startActivity(intent);
    }
}