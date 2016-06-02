package theironyard.com.contactsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        text = (TextView) findViewById(R.id.textView);

        Intent intentExtras = getIntent();
        String str = intentExtras.getExtras().getString("nameToPass");

        text.setText(str);

    }
}
