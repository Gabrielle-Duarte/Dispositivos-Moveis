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

import java.util.ArrayList;

public class SimplePaint extends View {
    Path mpath;
    Paint mpaint;

    ArrayList<Paint> paintList;
    ArrayList<Path> pathList;

    public SimplePaint(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        mpath = new Path ();
        mpaint = new Paint();
        mpaint.setStrokeWidth(5);
        mpaint.setColor(0xFF000000);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setAntiAlias(true);
        paintList = new ArrayList<>();
        pathList = new ArrayList<>();
    }
    @Override
    protected void onDraw(@NonNull Canvas canvas){
        super.onDraw(canvas);
        for (int i = 0; i < paintList.size(); i++){
            canvas.drawPath(pathList.get(i), paintList.get(i));
        }
        canvas.drawPath(mpath, mpaint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN: //Se o toque for de pressionar para baixo
                mpath.moveTo(x, y); //Movimenta para o x, y
                break;
            case MotionEvent.ACTION_MOVE:
                mpath.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                mpath.lineTo(x, y);
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    public void setColor(int color){
        //Criar nova camada de paint e path
        paintList.add(mpaint);
        pathList.add(mpath);
        mpaint = new Paint(mpaint);
        mpath = new Path();

        mpaint.setColor(color);
        invalidate();
    }
}

// path.moveTo(x, y); //Movimenta o ponteiro para as coordenadas do toque