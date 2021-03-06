package com.pupupon.androidtests;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class BitmapTest extends Activity {
    class RenderView extends View {
        Bitmap bob565;
        Bitmap bob4444;
        Rect dst = new Rect();
        public RenderView(Context context) {
            super(context);
            try {
                AssetManager assetManager = context.getAssets();
                InputStream inputStream = assetManager.open("images/bobrgb888.png");
                bob565 = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                Log.d("BitmapText", "bobrgb888.png format: " + bob565.getConfig());
                inputStream = assetManager.open("images/bobargb8888.png");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                bob4444 = BitmapFactory.decodeStream(inputStream, null, options);
                inputStream.close();
                Log.d("BitmapText", "bobargb8888.png format: " + bob4444.getConfig());
            } catch (IOException e) {
                // Ничего не делаем. На самом деле так нельзя.
            } finally {
                // здесь надо обязательно закрывать потоки
            }
        }
        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(0, 0, 0);
            dst.set(50, 50, 350, 350);
            canvas.drawBitmap(bob565, null, dst, null);
            canvas.drawBitmap(bob4444, canvas.getWidth()/2, canvas.getHeight()/2, null);
            invalidate();
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tools.fullScreen(this);
        setContentView(new RenderView(this));
    }
}