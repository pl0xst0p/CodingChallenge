package com.example.sst1337.codingchallenge;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

public class UserActivity extends AppCompatActivity
{
    private User currentUser;
    private TextView nameTextView;
    private TextView descriptionTextView;

    public final static String USER = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setupUI();
    }

    private void setupUI()
    {
        Gson gson = new Gson();
        String user = getIntent().getStringExtra(USER);
        currentUser = gson.fromJson(user, User.class);
        nameTextView = (TextView) findViewById(R.id.person_name);
        descriptionTextView = (TextView) findViewById(R.id.person_description);

        nameTextView.setText(currentUser.name);
        String description = "Username: " + currentUser.username + "\nEmail: " + currentUser.email +
                "\nPhone: " + currentUser.phone + "\nWebsite: " + currentUser.website + "\nAddress: " +
                currentUser.printAddress() + "\n" + currentUser.printLocation() + "\nCompany: " + currentUser.printCompany();
        descriptionTextView.setText(description);
    }
}
