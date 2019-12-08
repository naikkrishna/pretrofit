package com.example.pokemonhttp;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Httphandler {
    public Httphandler() {
    }
        public String makeServiceCall(String url) {
            String response =null;
            try {
                URL mUrl = new URL(url);
                HttpURLConnection con = null;
                try {
                    con = (HttpURLConnection) mUrl.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("content_Type","application/json");
                    InputStream in=new BufferedInputStream(con.getInputStream());
                    response = convertStream(in);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            return response;
    }


    public String convertStream(InputStream is) {
        BufferedReader read = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = read.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            Log.e("covertstream method", e.getMessage());
        }


    finally{
        try{
            is.close();
        }catch(IOException e)
        {
            Log.e("Convertstream F method",e.getMessage());
        }
        }
        return sb.toString();
    }
}
