package com.example.android.autochilddetectorappcompanion;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SetupActivity extends AppCompatActivity {

    TextView textView;
    EditText editArduinoPhone;
    EditText editPersonalPhone;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        editArduinoPhone = (EditText) findViewById(R.id.arNum);
        editPersonalPhone = (EditText) findViewById(R.id.uNum);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(
                        editArduinoPhone.getText().toString(),
                        null,
                        editPersonalPhone.getText().toString(),
                        null,
                        null);
                textView.setText("Wait for Device Confirmation");
                View loadingIndicator = findViewById(R.id.loading_indicator);
                loadingIndicator.setVisibility(View.VISIBLE);
            }
        });
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 123);
            button.setEnabled(false);
        } else {
            Log.d("PLAYGROUND", "Permission is granted");
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 123) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                button.setEnabled(true);
            } else {
                button.setEnabled(false);
            }
        }
    }
}




