package com.example.sst1337.codingchallenge;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sst1337 on 8/4/17.
 */

class Geo
{
    String latitude, longitude;

    public Geo(JSONObject geoData)
    {
        try
        {
            latitude = geoData.getString("lat");
            longitude = geoData.getString("lng");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
