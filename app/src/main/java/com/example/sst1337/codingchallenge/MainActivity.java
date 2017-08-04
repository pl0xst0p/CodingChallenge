package com.example.sst1337.codingchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter adapter;

    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

    private void setup()
    {
        getUsers();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new UsersAdapter(users);
        recyclerView.setAdapter(adapter);
    }

    private void getUsers()
    {
        try
        {
            createUsers(loadJSONFromAsset());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private String loadJSONFromAsset()
    {
        try
        {
            InputStream inputStream = getAssets().open("sample.json");
            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput)
            {
                return scanner.next();
            }
            else
            {
                return null;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
        return null;
    }

    private void createUsers(String jsonString) throws JSONException
    {
        users = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++)
        {
            JSONObject userData = jsonArray.getJSONObject(i);
            User user = new User(userData);
            users.add(user);
        }
    }
}
