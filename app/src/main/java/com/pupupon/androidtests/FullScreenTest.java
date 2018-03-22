package com.pupupon.androidtests;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class FullScreenTest extends SingleTouchTest {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Fullscreen
        Tools.hideStatus(this);

        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Tools.hideUI(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}