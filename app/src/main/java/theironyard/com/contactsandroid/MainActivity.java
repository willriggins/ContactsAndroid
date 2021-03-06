package theironyard.com.contactsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    ArrayAdapter<String> items;
    String nameToPass;

    ListView list;
    Button add;
    EditText name;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        add = (Button) findViewById(R.id.add);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        add.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nameToAdd = name.getText().toString();
        String phoneToAdd = phone.getText().toString();
        String contact = nameToAdd + " (" + phoneToAdd + ")";
        if (!nameToAdd.isEmpty() && !phoneToAdd.isEmpty()) {
            items.add(contact);
            name.setText("");
            phone.setText("");
        }
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }


    // see this link for example on using Intent: http://101apps.co.za/articles/passing-data-between-activities.html
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intentExtras = new Intent(MainActivity.this, Contacts.class);
        intentExtras.putExtra("nameToPass", items.getItem(position));
        startActivity(intentExtras);
    }
}
