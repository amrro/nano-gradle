package xyz.amrro.jokesandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    public static final String KEY_EXTRA_JOKE_TEXT = "key_extra_joke_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView jokeTV = findViewById(R.id.joke_textview);

        final Intent intent = getIntent();
        if (intent == null) {
            jokeTV.setText(R.string.joke_load_error);
        } else {
            final String joke = intent.getExtras().getString(KEY_EXTRA_JOKE_TEXT, getString(R.string.joke_load_error));
            jokeTV.setText(joke);
        }
    }

}
