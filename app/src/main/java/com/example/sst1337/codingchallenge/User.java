package com.example.sst1337.codingchallenge;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sst1337 on 8/4/17.
 */

//  {
//          "id": 1,
//          "name": "Leanne Graham",
//          "username": "Bret",
//          "email": "Sincere@april.biz",
//          "address": {
//          "street": "Kulas Light",
//          "suite": "Apt. 556",
//          "city": "Gwenborough",
//          "zipcode": "92998-3874",
//          "geo": {
//          "lat": "-37.3159",
//          "lng": "81.1496"
//          }
//          },
//          "phone": "1-770-736-8031 x56442",
//          "website": "hildegard.org",
//          "company": {
//          "name": "Romaguera-Crona",
//          "catchPhrase": "Multi-layered client-server neural-net",
//          "bs": "harness real-time e-markets"
//          }
//          },

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
}
