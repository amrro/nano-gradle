package com.udacity.gradle.builditbigger.backend;

import xyz.amrro.jokes.JokeRepository;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;

    public String getData() {
//        myData = JokeRepository.generateJoke();
        myData = new JokeRepository().getJoke();
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}