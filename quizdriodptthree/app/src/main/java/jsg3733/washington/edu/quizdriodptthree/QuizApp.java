package jsg3733.washington.edu.quizdriodptthree;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jsg3733 on 2/16/2015.
 */
public class QuizApp extends Application {


    @Override
    public void onCreate(){
        super.onCreate();
        Log.i("QuizApp", "Have reached the Quiz App");

        //Initialize the singletons so their instances
        // are bound to the application process
        initSingletons();

    }

    private void initSingletons() {
        //Initialize the instance of my singleton
        MySingleton.initInstance();
    }

    public List<Topic> getTopics(Repo repo) {
        //Context con = getApplicationContext();
        //Repo repo = new Repo(con);
        List<Topic> topicsList = repo.getTopics();
        return topicsList;
    }

    public Topic getTopic(String s, Repo repo){
        //Context con = getApplicationContext();
        //Repo repo = new Repo(con);
        Topic topic = repo.getTopic(s);
        return topic;
    }

    public Repo getRepo(){
        Context con = getApplicationContext();
        Repo repo = new Repo(con);
        return repo;
    }

    /*public void customAppMethod() {
        Context con = getApplicationContext();
        Repo rep = new Repo(con);
        Topic t = rep.getTopic("Math");
        Log.i("Quizapp", "hello");
        String title = t.getTitle();
        Log.i("Quizapp", title);
        Log.i("Quizapp", t.getTitle());
        Log.i("Quizapp", t.getLongDesc());
        Log.i("Quizapp", t.getShortDesc());


    }*/

}
