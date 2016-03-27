package com.ennjapps.todolistapp;

import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NewTask extends AppCompatActivity {
    private  Button btn;
    private EditText item;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        item=(EditText) findViewById(R.id.item);
        list=new ArrayList<>();

        list=new ArrayList<>();
        adapter= new ArrayAdapter<String>(NewTask.this,R.layout.custom_textx_listview,list);



         btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemtodo = item.getText().toString();
                if (itemtodo.length() > 0) {
                    list.add(itemtodo);
                    adapter.notifyDataSetChanged();
                    item.setText("");
                }
            }
        });
    }
}
