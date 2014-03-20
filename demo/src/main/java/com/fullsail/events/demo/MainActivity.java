package com.fullsail.events.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

    final String TAG = "Event Demo";
    private TextView mUserText;
    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting references to user and result text fields
        mUserText = (TextView) findViewById(R.id.usertext);
        mResultText = (TextView) findViewById(R.id.resulttext);

        //Button click listener
        Button button = (Button) findViewById(R.id.userbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button Clicked");
                showResult(mUserText.getText().toString());
            }
        });

        //Item item select listener
        ListView oslist = (ListView) findViewById(R.id.oslist);
        oslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "List Item Selected");
                TextView selected = (TextView) view;
                showResult(selected.getText().toString());
            }
        });
    }

    //CUSTOM FUNCTIONS
    private void showResult(String result){
        Log.i(TAG,"Updating result text.");
        mResultText.setText(result);
    }

}
