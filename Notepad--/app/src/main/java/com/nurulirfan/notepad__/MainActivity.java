package com.nurulirfan.notepad__;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText TextArea = (EditText)findViewById(R.id.text_area);

        Button btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new SaveListener(TextArea));

        Button btnOpen = (Button) findViewById(R.id.btn_open);
        btnOpen.setOnClickListener(new OpenListener(TextArea));

        Button btnClear = (Button) findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(new ClearListener(TextArea));
     }

    protected class SaveListener implements View.OnClickListener{
        private EditText TextArea;
        public SaveListener(EditText txt){
            this.TextArea = txt;
        }

        public void onClick(View v){
            try{
                File myFile = new File(v.getContext().getExternalFilesDir(null), "myFile.txt");
                myFile.createNewFile();

                FileOutputStream fOut = new FileOutputStream(myFile);
                OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);

                myOutWriter.append(this.TextArea.getText());
                myOutWriter.close();
                fOut.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    protected class OpenListener implements View.OnClickListener{
        private EditText TextArea;
        public OpenListener(EditText txt){
            this.TextArea = txt;
        }

        public void onClick(View v){
            try{
                File myFile = new File(v.getContext().getExternalFilesDir(null), "myFile.txt");
                FileInputStream fIn = new FileInputStream(myFile);
                BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));

                String aDataRow = "";
                String aBuffer = "";

                while ((aDataRow = myReader.readLine()) != null){
                    aBuffer += aDataRow + "\n";
                }

                this.TextArea.setText(aBuffer);
                myReader.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    protected class ClearListener implements View.OnClickListener{
        private EditText TextArea;
        public ClearListener(EditText txt){
            this.TextArea = txt;
        }

        public void onClick(View v){
            this.TextArea.setText("");
        }
    }
}
