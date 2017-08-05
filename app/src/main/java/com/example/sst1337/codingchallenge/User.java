package com.example.sst1337.codingchallenge;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sst1337 on 8/4/17.
 */

public class User
{
    int id;
    String name, username, email, phone, website;
    Address address;
    Company company;

    public User(JSONObject userData)
    {
        try
        {
            id = userData.getInt("id");
            name = userData.getString("name");
            username = userData.getString("username");
            email = userData.getString("email");
            phone = userData.getString("phone");
            website = userData.getString("website");
            address = new Address(userData.getJSONObject("address"));
            company = new Company(userData.getJSONObject("company"));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public String getInformation()
    {
        String info = name + " works at " + company.name + ".\nThe company catchphrase is " + company.catchphrase;
        return  info;
    }

    public String printAddress()
    {
        return address.suite + " " + address.street + " " + address.city + " " + address.zipcode;
    }

    public String printLocation()
    {
        return "Latitiude: " + address.location.latitude + "\nLongitude: " + address.location.longitude;
    }

    public String printCompany()
    {
        return company.name + "\nCatchpharse: " + company.catchphrase;
    }
}
