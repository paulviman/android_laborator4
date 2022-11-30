package com.example.laborator4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listStud;
    Button btnAdd, btnDel;
    ArrayList<String> dynamicList;
    ArrayAdapter<String> listAdapter;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listStud = findViewById(R.id.list);
        dynamicList = new ArrayList<String>();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dynamicList);
        listStud.setAdapter(listAdapter);
        btnAdd = findViewById(R.id.btnAdd);
        btnDel = findViewById(R.id.btnDel);
        editText = findViewById(R.id.editText);

    }

    public void onClickAdd(View view) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please fill the name of student...", Toast.LENGTH_LONG).show();
        } else {
            listAdapter.add(editText.getText().toString());
            listAdapter.notifyDataSetChanged();
        }

    }

    public void onClickDel(View view) {
        if (dynamicList.size() > 0) {
            if (!editText.getText().toString().isEmpty()) {
                dynamicList.remove(editText.getText().toString());
                Toast.makeText(MainActivity.this, "deleted", Toast.LENGTH_LONG).show();
                listAdapter.notifyDataSetChanged();
            }
        } else {
            Toast.makeText(MainActivity.this, "There is no element to delete", Toast.LENGTH_LONG).show();
        }
    }
}