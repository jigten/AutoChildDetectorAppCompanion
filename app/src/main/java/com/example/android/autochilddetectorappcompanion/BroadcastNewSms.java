package com.example.android.autochilddetectorappcompanion;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by ujigt on 2/12/2017.
 */

public class BroadcastNewSms extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_newsms);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}
