package john.anonchatroom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by johnkmnguyen on 11/17/17.
 */

public class Catagories extends AppCompatActivity
{
    String[] catagory = {"CECS", "EE", "CAFF", "ENGL", "MATH", "ETC", "ETC", "ETC", "ETC"};

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.catagories);

        // Create list for the existing classes
        ListView list;


        ArrayList<String> className1 = new ArrayList<>();
        try {
            JSONObject doc = new JSONObject(readJSONFromAsset());
            Log.d("s91", "try");

            JSONArray arr;
            JSONObject obj;
            arr = doc.getJSONArray("list");
            for (int i = 0; i < arr.length(); i++){
                obj = arr.getJSONObject(i);
                Log.d("s91", obj.get("dept").toString());
                className1.add(obj.get("dept").toString());

            }
            //sort it
            catagory = new String[className1.size()];
            className1.toArray(catagory);



            //Log.d("s91", obj.get("name").toString() + " " + obj2.get("dept").toString() );

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("s91", "fail");
        }

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

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("base.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
