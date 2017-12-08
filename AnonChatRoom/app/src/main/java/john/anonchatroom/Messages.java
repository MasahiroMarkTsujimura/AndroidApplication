package john.anonchatroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Mustafa on 12/7/2017.
 */

class Messages  extends AppCompatActivity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.messages);
        TextView t = (TextView)findViewById(R.id.textView);
        t.setText("This is " + getIntent().getExtras().getString("position"));
    }
}
