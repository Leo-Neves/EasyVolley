package com.leoneves.easyvolley.presenter;

import android.content.Context;

import com.android.volley.Request;
import com.leoneves.easyvolley.Header;
import com.leoneves.easyvolley.RESTListener;
import com.leoneves.easyvolley.Send;
import com.leoneves.easyvolley.SendListener;
import com.leoneves.easyvolley.model.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private Context context;

    public Presenter(Context context){
        this.context = context;
    }

    public void getPokemons (final RESTListener restListener){
        int method = Request.Method.GET;
        String url = "https://pokeapi.co/api/v2/pokemon/";
        JSONObject body = null;
        Header header = null;
        SendListener sendListener = new SendListener() {
            @Override
            public void onError(Exception e, int code) {
                restListener.error();
            }

            @Override
            public void onSuccess(JSONObject result) {
                List<Pokemon> pokemons = new ArrayList<>();
                try{
                    JSONArray pokes = result.getJSONArray("results");
                    for (int i=0;i<pokes.length();i++){
                        JSONObject poke = pokes.getJSONObject(i);
                        Pokemon pokemon = new Pokemon();
                        pokemon.setName(poke.optString("name"));
                        pokemon.setUrl(poke.getString("url"));
                        pokemons.add(pokemon);
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
                restListener.success(pokemons);
            }
        };
        Send send = new Send(method, url, body, header, sendListener);
        send.sync(context);
    }
}
