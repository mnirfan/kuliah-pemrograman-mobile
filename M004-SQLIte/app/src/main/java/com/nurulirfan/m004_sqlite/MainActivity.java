package com.nurulirfan.m004_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ListDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new ListDBHelper(this);
        ListDataAdapter adapter = new ListDataAdapter(this, R.layout.list_item, db);
        ListView lvData = (ListView) findViewById(R.id.listData);
        lvData.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.addItem);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, InsertActivity.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView lvData = (ListView) findViewById(R.id.listData);
        ListDataAdapter adapter = (ListDataAdapter) lvData.getAdapter();
        adapter.refresh();
    }
}
