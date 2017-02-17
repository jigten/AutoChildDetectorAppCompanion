package com.example.android.autochilddetectorappcompanion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class KidsCarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_cars);

        ImageView logoView = (ImageView) findViewById(R.id.logo_website);
        logoView.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kidsandcars.org/"));
                startActivity(browserIntent);
            }
        }
        );

        ImageView donateView = (ImageView) findViewById(R.id.donate);
        donateView.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://donatenow.networkforgood.org/kidsandcars"));
                startActivity(browserIntent);
            }
        }
        );
    }
}
