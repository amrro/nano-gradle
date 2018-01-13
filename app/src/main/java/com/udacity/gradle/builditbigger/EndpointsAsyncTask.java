package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import xyz.amrro.jokesandroid.JokeDisplayActivity;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;


class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private MyApi api;
    private Context context;


    @Override
    protected String doInBackground(Context[] params) {
        if (api == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer((GoogleClientRequestInitializer) abstractGoogleClientRequest -> {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    });
            // end options for devappserver

            api = builder.build();
        }

        context = params[0];
        try {
            return api.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.KEY_EXTRA_JOKE_TEXT, s);
        context.startActivity(intent);
    }
}
