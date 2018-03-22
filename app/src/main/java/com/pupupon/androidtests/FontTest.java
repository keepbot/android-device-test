package com.pupupon.androidtests;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class FontTest extends Activity {
    class RenderView extends View {
        Paint paint;
        Typeface font;
        Rect bounds = new Rect();
        public RenderView(Context context) {
            super(context);
            paint = new Paint();
            //font = Typeface.createFromAsset(context.getAssets(), "fonts/RaviPrakash-Regular.ttf");
            font = Typeface.createFromAsset(context.getAssets(), "fonts/haxrcorp.ttf");
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(0, 0, 0);
            paint.setColor(Color.YELLOW);
            paint.setTypeface(font);
            paint.setTextSize(160);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("This is a test!", canvas.getWidth() / 2, 100, paint);

            String text = "This is another test o_O";
            paint.setColor(Color.WHITE);
            paint.setTextSize(80);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds(text, 0, text.length(), bounds);
            canvas.drawText(text, canvas.getWidth() - bounds.width(), canvas.getHeight()/2, paint);

            paint.setColor(Color.GREEN);
            paint.setTextSize(80);
            paint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("! Русский текст !", 50, canvas.getHeight() - 300, paint);
            invalidate();

            String text2 = "Русский текст 2 o_O";
            paint.setColor(Color.RED);
            paint.setTextSize(80);
            paint.setTextAlign(Paint.Align.RIGHT);
            paint.getTextBounds(text2, 0, text2.length(), bounds);
            canvas.drawText(text2, bounds.width() + 10, canvas.getHeight()/2 - 150, paint);
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tools.fullScreen(this);
        setContentView(new RenderView(this));
    }

}