package com.example.android.autochilddetectorappcompanion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
    }

    public void setup(View view)    {
        EditText arduinoNumber = (EditText) findViewById(R.id.arNum);
        String arNum = arduinoNumber.getText().toString();
        EditText personalNumber = (EditText) findViewById(R.id.uNum);
        String urNum = personalNumber.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + arNum));
        intent.putExtra("sms_body", urNum);
        startActivity(intent);
    }
}
