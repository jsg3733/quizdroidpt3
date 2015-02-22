package jsg3733.washington.edu.quizdriodptthree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TopicOverview extends ActionBarActivity {

    protected QuizApp app;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_overview);

        app = (QuizApp)getApplication();
        Repo repo = app.getRepo();
        final List<Topic> topics = app.getTopics(repo);

        list = (ListView) findViewById(R.id.lstTopics);

        List<String> values = new ArrayList<>();
        List<TopicRow> topicRow_data = new ArrayList<>();

        for(int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            values.add(t.getTitle());
            topicRow_data.add(new TopicRow(R.drawable.ic_launcher, t.getTitle(), t.getShortDesc()));
        }


        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);
        //list.setAdapter(adapter);


        /*TopicRow topicRow_data[] = new TopicRow[]
                {
                        new TopicRow(R.drawable.ic_launcher, values.get(0), ""),
                        new TopicRow(R.drawable.ic_launcher, "Showers", ""),
                        new TopicRow(R.drawable.ic_launcher, "Snow", ""),
                        new TopicRow(R.drawable.ic_launcher, "Storm", ""),
                        new TopicRow(R.drawable.ic_launcher, "Sunny", "")
                };*/


        TopicRowAdapter adapter = new TopicRowAdapter(this,
                R.layout.listview_item_row, topicRow_data);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                //String itemValue = (String) list.getItemAtPosition(itemPosition);
                String itemValue = (String) topics.get(itemPosition).getTitle();

                Intent nextActivity = new Intent(TopicOverview.this, TopicOver.class);
                nextActivity.putExtra("topic", itemValue);

                startActivity(nextActivity);
                //finish();


            }
        });




        /*TextView t = (TextView) findViewById(R.id.txthello);
        app.customAppMethod();
        t.setText("File has been found"); */

        //MySingleton.getInstance().customSingletonMethod();
        //String singletonVar = MySingleton.getInstance().customVar;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topic_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
