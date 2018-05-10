




package com.robertmccormick.mccormickrob_androidrotation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etValue;
    Button btnAdd;
    ListView lvShowItem;

    private android.os.Bundle state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValue = findViewById(R.id.etValue);
        btnAdd = findViewById(R.id.btnAdd);
        lvShowItem = findViewById(R.id.lvShowItem);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, AppData.getList());
        lvShowItem.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etValue.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Enter Value first", Toast.LENGTH_SHORT).show();
                } else if (etValue.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "input can not be white spaces", Toast.LENGTH_SHORT).show();
                } else {

                    AppData.getList().add(etValue.getText().toString());
                    adapter.notifyDataSetChanged();
                    etValue.setText("");
                }

            }
        });


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.


        savedInstanceState.putString("value", etValue.getText().toString());

        // etc.

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        etValue.setText(savedInstanceState.getString("value"));
    }

}
