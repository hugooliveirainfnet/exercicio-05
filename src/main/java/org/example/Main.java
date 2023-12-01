package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        URL uri = new URL("https://api.publicapis.org/entries");
        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
        conn.setRequestMethod("GET");
        int resCode = conn.getResponseCode();

        if (resCode == HttpURLConnection.HTTP_OK) {
            InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer = new StringBuffer();

            String inputLine = bufferedReader.readLine();
            while ( inputLine != null) {
                stringBuffer.append(inputLine);
                inputLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            Resposta resposta = new Resposta(stringBuffer.toString());
            System.out.println(resposta);

        } else {
            System.out.println("GET request not worked");
        }



    }
}