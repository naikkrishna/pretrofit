package com.example.pokemonhttp;

import android.os.AsyncTask;

public class Ayscdata extends AsyncTask<String,Void,String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {

        String jsonurl = strings[0];
        Httphandler hp = new Httphandler();
        String json =hp.makeServiceCall(jsonurl);
        System.out.println("response from asycTask:"+json);

        return json;
    }
}
