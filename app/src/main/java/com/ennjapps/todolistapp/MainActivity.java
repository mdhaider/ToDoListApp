package com.ennjapps.todolistapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText item;
    private ListView dynamicListView;
    private FloatingActionButton add;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            String[] values = savedInstanceState.getStringArray("myKey");
            if (values != null) {
                adapter= new ArrayAdapter<String>(MainActivity.this,R.layout.custom_textx_listview,list);
                dynamicListView.setAdapter(adapter);
            }
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        dynamicListView = (ListView) findViewById(R.id.listView);
        add=(FloatingActionButton) findViewById(R.id.fab);

        NewTask nt=new NewTask();

        list=new ArrayList<>();
        adapter= new ArrayAdapter<String>(MainActivity.this,R.layout.custom_textx_listview,list);
        dynamicListView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,NewTask.class);
                startActivity(intent);

            }
        });

        dynamicListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                list.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    public void onSaveInstanceState(Bundle savedState) {

        super.onSaveInstanceState(savedState);

        // Note: getValues() is a method in your ArrayAdapter subclass



    }

}
