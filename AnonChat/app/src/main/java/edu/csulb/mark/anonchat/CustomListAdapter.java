package edu.csulb.mark.anonchat;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by johnkmnguyen on 11/16/17.
 */

public class CustomListAdapter extends ArrayAdapter<String>
{
    // variables from the adapter
    private final Activity context;
    private final String[] className;

    //Constructor
    public CustomListAdapter(Activity context, String[] className)
    {
        super(context, R.layout.classlist, className);

        this.context = context;
        this.className = className;

    }

    public View getView(int position, View view, ViewGroup parent)
    {
        // Inflate
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.classlist, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.rowText);

        // Set Text
        txtTitle.setText(className[position]);
        return rowView;
    };
}
