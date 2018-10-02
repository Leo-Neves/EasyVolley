package com.leoneves.easyvolley;


import java.util.HashMap;

/**
 * Created by leo on 28/03/17.
 */

public class Body extends HashMap<String, String> {

    public Body() {
        super();
    }

    public String put(String key, String value) {
        return super.put(key, value);
    }

    public void putAuthorization(){
        put("Authorization", "Basic Y3VybDpjdXJs");
    }
}
