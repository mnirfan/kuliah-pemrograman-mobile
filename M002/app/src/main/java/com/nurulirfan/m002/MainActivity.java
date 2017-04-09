package com.nurulirfan.m002;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected class PhoneDiallerListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent iPhoneDialler = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:089610128959"));
            startActivity(iPhoneDialler);
        }
    }

    protected class OpenBrowserListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            String theUrl = "http://nurulirfan.com";
            Intent iOpenBrowserListener = new Intent(Intent.ACTION_VIEW, Uri.parse(theUrl));
            startActivity(iOpenBrowserListener);
        }
    }

    protected class OpenGalleryListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent iOpenGallery = new Intent();
            iOpenGallery.setType("image/pictures/*");
            iOpenGallery.setAction(Intent.ACTION_GET_CONTENT);
            startActivity(iOpenGallery);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPhoneDialler = (Button) this.findViewById(R.id.phonedialler);
        btnPhoneDialler.setOnClickListener(new PhoneDiallerListener());

        Button btnOpenBrowser = (Button) this.findViewById(R.id.openbrowser);
        btnOpenBrowser.setOnClickListener(new OpenBrowserListener());

        Button btnOpenGallery = (Button) this.findViewById(R.id.opengalery);
        btnOpenGallery.setOnClickListener(new OpenGalleryListener());
    }
}
