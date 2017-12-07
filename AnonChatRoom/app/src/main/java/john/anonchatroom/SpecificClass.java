package john.anonchatroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by johnkmnguyen on 11/17/17.
 */

public class SpecificClass extends AppCompatActivity
{
    String[] classNum = {"100", "105", "110", "200", "ETC", "ETC", "ETC", "ETC", "ETC"};
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


        ArrayList<String> className1 = new ArrayList<>();
        try {
            JSONObject doc = new JSONObject(readJSONFromAsset());
            Log.d("s91", "try");
            int row;

            JSONArray arr;
            JSONObject obj;
            arr = doc.getJSONArray("list");
            for (int i = 0; i < arr.length(); i++){
                obj = arr.getJSONObject(i);
                //Log.d("s91", obj.get("dept").toString());
                //className1.add(obj.get("dept").toString());
                if (obj.get("dept").toString().equals(classType)){
                    row = i;
                    arr = obj.getJSONArray("courses");
                    i = 1000;
                }

            }
            String last = "";
            for (int i =0; i < arr.length(); i++){
                obj = arr.getJSONObject(i);
                if(obj.get("num").toString().equals(last)){
                    //do nothing
                }
                else {
                    className1.add(obj.get("num").toString());
                    last = obj.get("num").toString();
                }
            }


            //sort it
            classNum = new String[className1.size()];
            className1.toArray(classNum);



            //Log.d("s91", obj.get("name").toString() + " " + obj2.get("dept").toString() );

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("s91", "fail");
        }
        // Calling the custom constructor
        CustomListAdapter adapter = new CustomListAdapter(this, classNum);
        list = (ListView) findViewById(R.id.customView);

        // Set up the list using the adapter from the CustomListAdapter
        list.setAdapter(adapter);


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
