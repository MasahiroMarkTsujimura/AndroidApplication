package john.anonchatroom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by johnkmnguyen on 11/17/17.
 */

public class Catagories extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.catagories);

        // Create list for the existing classes
        ListView list;
        final String[] catagory = {"CECS", "EE", "CAFF", "ENGL", "MATH", "ETC", "ETC", "ETC", "ETC"};

        // Calling the custom constructor
        CustomListAdapter adapter = new CustomListAdapter(this, catagory);
        list = (ListView) findViewById(R.id.customView);

        // Set up the list using the adapter from the CustomListAdapter
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
            {
                    //Create intent
                    // parameter is from which activity to which
                    Intent intent = new Intent(getApplicationContext(),SpecificClass.class);
                    //Send the catagory
                    intent.putExtra("catagory", catagory[position]);
                    startActivity(intent);
            }
        });
    }
}
