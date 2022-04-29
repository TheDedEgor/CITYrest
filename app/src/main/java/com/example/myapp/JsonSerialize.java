package com.example.myapp;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class JsonSerialize implements Serializable {
    private JSONObject json;

    public JsonSerialize(JSONObject json) {
        this.json = json;
    }

    public JSONObject getJson() {
        return this.json;
    }
}
