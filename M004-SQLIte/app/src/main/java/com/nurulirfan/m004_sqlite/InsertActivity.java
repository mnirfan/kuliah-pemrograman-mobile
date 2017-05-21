package com.nurulirfan.m004_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener{
    protected ListDBHelper db;

    protected class ClearScreenListener implements View.OnClickListener{
        private EditText TextArea;

        public ClearScreenListener(EditText e){
            TextArea = e;
        }

        @Override
        public void onClick(View view) {
            TextArea.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        db = new ListDBHelper(this);

        Button insertButton = (Button) findViewById(R.id.saveButton);
        insertButton.setOnClickListener(this);

        EditText textArea = (EditText) findViewById(R.id.editText);
        Button clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new ClearScreenListener(textArea));
    }

    @Override
    public void onClick(View view) {
        ItemData item = new ItemData();
        EditText textArea = (EditText) findViewById(R.id.editText);
        item.text = textArea.getText().toString();
        db.insert(item);

        finish();
    }
}
