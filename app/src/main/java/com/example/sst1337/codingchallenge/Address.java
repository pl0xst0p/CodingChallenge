package com.example.sst1337.codingchallenge;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sst1337 on 8/4/17.
 */

public class Address
{
    String street, city, suite, zipcode;
    Geo location;

    public Address(JSONObject addressData)
    {
        try
        {
            street = addressData.getString("street");
            city = addressData.getString("city");
            suite = addressData.getString("suite");
            zipcode = addressData.getString("zipcode");
            location = new Geo(addressData.getJSONObject("geo"));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
