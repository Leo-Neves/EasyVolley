package com.leoneves.easyvolley;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by leo on 30/11/16.
 */

public abstract class RESTListener {
    public void success(Object... args){}
    public void error(Object... args){}
    public void successAndError(Object... args){}
    public void refreshProgress(int progress, String mesage){}

    public static SendListener restListenerToSendListener(final RESTListener restListener){
        return new SendListener() {
            @Override
            public void onError(Exception e, int code) {
                restListener.error();
                restListener.successAndError();
            }

            @Override
            public void onSuccess(JSONObject result) {
                restListener.success();
                restListener.successAndError();
            }

            @Override
            public void onSuccess(JSONArray result) {
                restListener.success();
                restListener.successAndError();
            }

            @Override
            public void onSuccess(String resposta) {
                restListener.success();
                restListener.successAndError();
            }
        };
    }
    public static RESTListener sendListenerToRESTListener(final SendListener sendListener){return new RESTListener() {
        @Override
        public void success(Object... args) {
            sendListener.onSuccess("Success");
            sendListener.onSuccess(new JSONObject());
            sendListener.onSuccess(new JSONArray());
        }

        @Override
        public void error(Object... args) {
            sendListener.onError(new Exception(), 0);
        }

        @Override
        public void successAndError(Object... args) {
            sendListener.onError(new Exception(), 0);
            sendListener.onSuccess("Success");
            sendListener.onSuccess(new JSONObject());
            sendListener.onSuccess(new JSONArray());
        }
    };}
}
