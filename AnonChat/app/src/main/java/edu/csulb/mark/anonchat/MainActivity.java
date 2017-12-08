package edu.csulb.mark.anonchat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by johnkmnguyen on 11/16/17.
 */

public class MainActivity extends AppCompatActivity
{
    Button mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create list for the existing classes
        ListView list;
        final String[] className = {"CECS 453", "CECS 326", "EE 381", "CECS 453", "CECS 326", "EE 381", "CECS 453", "CECS 326", "EE 381"};

        // Calling the custom constructor
        CustomListAdapter adapter = new CustomListAdapter(this, className);
        list = (ListView) findViewById(R.id.customView);

        // Set up the list using the adapter from the CustomListAdapter
        list.setAdapter(adapter);

        mainMenu = (Button) findViewById(R.id.menu_button);
        mainMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                PopupMenu popup = new PopupMenu(MainActivity.this, mainMenu);

                //Inflate the popup using the main_menu xml
                popup.getMenuInflater().inflate(R.menu.main_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        switch(item.getItemId())
                        {
                            case R.id.moreclasses:
                            {
                                Intent intent = new Intent(getApplicationContext(),Catagories.class);
                                //Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                                return true;
                            }

                        }
                        return(onMenuItemClick(item));
                    }
                });

                //Show popup menu
                popup.show();
            }
        });

    }

}
