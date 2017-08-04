package com.example.sst1337.codingchallenge;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sst1337 on 8/4/17.
 */

public class Company
{
    String name, catchphrase, bs;

    public Company(JSONObject companyData)
    {
        try
        {
            name = companyData.getString("name");
            catchphrase = companyData.getString("catchPhrase");
            bs = companyData.getString("bs");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
