package edu.csulb.mark.anonchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by johnkmnguyen on 11/17/17.
 */

public class SpecificClass extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.specific_class);

        // get intent
        Bundle input = this.getIntent().getExtras();


        String classType = input.getString("catagory");
        TextView t;
        t = (TextView) findViewById(R.id.specficClass);
        t.setText(classType);

        // Create list for the existing classes
        ListView list;
        final String[] classNum = {"100", "105", "110", "200", "ETC", "ETC", "ETC", "ETC", "ETC"};

        // Calling the custom constructor
        CustomListAdapter adapter = new CustomListAdapter(this, classNum);
        list = (ListView) findViewById(R.id.customView);

        // Set up the list using the adapter from the CustomListAdapter
        list.setAdapter(adapter);


    }

}
