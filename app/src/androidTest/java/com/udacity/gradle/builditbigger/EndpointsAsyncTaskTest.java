package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import org.junit.Test;

import java.util.concurrent.ExecutionException;


//@RunWith(JUnit4.class)
public class EndpointsAsyncTaskTest extends AndroidTestCase {

    @Test
    public void testEndpointAsyncTas_returnNonEmptyString() {
        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.execute(getContext());

        String jokeStr;

        try {
            jokeStr = task.get();
            assertNotNull("Non empty Joke received", jokeStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}