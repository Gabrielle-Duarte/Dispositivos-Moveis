package com.example.appgab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimplePaint extends View {
    Path path;
    Paint paint;
    public SimplePaint(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        path = new Path ();
        paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(0xFF000000);
        paint.setStyle(Paint.Style.STROKE);
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN: //Se o toque for de pressionar para baixo
                path.moveTo(x, y); //Movimenta para o x, y
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                path.lineTo(x, y);
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }
}

// path.moveTo(x, y); //Movimenta o ponteiro para as coordenadas do toque