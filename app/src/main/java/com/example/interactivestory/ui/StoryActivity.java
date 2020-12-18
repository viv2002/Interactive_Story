package com.example.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.interactivestory.R;
import com.example.interactivestory.model.Story;
import com.example.interactivestory.model.page;

import java.util.Stack;

import static android.view.View.VISIBLE;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    private String name;
    private Story story;
    private ImageView storyImageView ;
    private TextView storyTextView;
    private Button first_choice_button;
    private Button second_choice_button;
    private final Stack<Integer> pageStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = findViewById(R.id.storyImageView);
        storyTextView = findViewById(R.id.storyTextView);
        first_choice_button = findViewById(R.id.first_choice_button);
        second_choice_button = findViewById(R.id.second_choice_button);

        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));
        if(name==null || name.isEmpty()){
            name = "Friend";
        }
        Log.d(TAG,name);
        story = new Story();
        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        pageStack.push(pageNumber);
        final page page = story.getPage(pageNumber);
        Drawable image = ContextCompat.getDrawable(this,page.getImageId());
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());
        // Add name if placeholder included won't if not
        pageText = String.format(pageText,name);
        storyTextView.setText(pageText);

        if(page.isFinalpage()) {
            first_choice_button.setVisibility(View.INVISIBLE);
            second_choice_button.setText(R.string.play_again);
            second_choice_button.setOnClickListener(v -> loadPage(0));
        }
        else loadButtons(page);
    }

    private void loadButtons(final page page) {
        first_choice_button.setVisibility(VISIBLE);
        first_choice_button.setText(page.getChoice1().getTextId());
        first_choice_button.setOnClickListener(v -> {
            int nextPage = page.getChoice1().getNextPage();
             loadPage(nextPage);
        });
        second_choice_button.setVisibility(VISIBLE);
        second_choice_button.setText(page.getChoice2().getTextId());
        second_choice_button.setOnClickListener(v -> {
            int nextPage = page.getChoice2().getNextPage();
            loadPage(nextPage);
        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if(pageStack.isEmpty()) super.onBackPressed();
        else loadPage(pageStack.pop());
    }
}