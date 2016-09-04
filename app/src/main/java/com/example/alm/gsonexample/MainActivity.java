package com.example.alm.gsonexample;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainActivity extends AppCompatActivity {

    String url = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        textView = (TextView) findViewById(R.id.textView);


    }

    private InputStream retrieveStream(String url) {

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet getRequest = new HttpGet(url);

        try {

            HttpResponse getResponse = client.execute(getRequest);

            final int statusCode = getResponse.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {

                Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + url);

                return null;

            }

            HttpEntity getResponseEntity = getResponse.getEntity();

            return getResponseEntity.getContent();

        } catch (IOException e) {

            getRequest.abort();

            Log.w(getClass().getSimpleName(), "Error for URL " + url, e);

        }

        return null;

    }


    public void onConnect(View view) {

        InputStream source = retrieveStream(url);

        Gson gson = new Gson();

        Reader reader = new InputStreamReader(source);

        ActorsArray response = gson.fromJson(reader, ActorsArray.class);

        textView.setText(response.getActorsList().toString());


        String actorResults = "";
        for (Actors result : response.getActorsList()) {
            actorResults = actorResults + " Name: " + result.getName() + "   Country: " + result.getCountry() + "\n";
        }

        textView.setText(actorResults);

    }
}
