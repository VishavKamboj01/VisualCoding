package com.example.visualcoding.ui.activities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.visualcoding.ui.helpers.FrameController;
import com.example.visualcoding.objects.Material;
import com.example.visualcoding.objects.Rectangle;

public class CodeMapDrawingSurface extends SurfaceView implements Runnable, View.OnTouchListener {
    private SurfaceHolder surfaceHolder;
    private Matrix cameraMatrix;
    private boolean canDraw;
    private Thread thread;
    private Context context;
    private FrameController frameController;
    private Rectangle rectangle;
    public CodeMapDrawingSurface(Context context) {
        super(context);
        init(context);
    }

    public CodeMapDrawingSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        surfaceHolder = getHolder();
        canDraw = false;

        setOnTouchListener(this);

        frameController = new FrameController(60);
        cameraMatrix = new Matrix();

        Paint redFill = new Paint();
        redFill.setColor(Color.RED);
        redFill.setStyle(Paint.Style.FILL);

        rectangle = new Rectangle(new Rect(0, 0, 60, 60));
        rectangle.setMaterial(new Material());
        rectangle.getMaterial().addColor("color1", redFill);

        resume();
    }

    @Override
    public void run() {

        while (canDraw) {
            if (!surfaceHolder.getSurface().isValid()) {
                continue;
            }
            frameController.startFrame();
            Canvas canvas = surfaceHolder.lockCanvas();
            canvas.drawARGB(255, 0, 0, 0);

            try {
                // draw here
                //cameraMatrix.postRotate(1);
                canvas.setMatrix(cameraMatrix);
                rectangle.draw(canvas);

            } finally {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

           frameController.endFrame();

            try {
                if (frameController.shouldWait()) {
                    Thread.sleep(frameController.getWaitTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pause () {
        canDraw = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread = null;
    }

    public void resume () {
        canDraw = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return onTouchHelper(motionEvent);
    }

    private boolean onTouchHelper(MotionEvent motionEvent) {
        int event = motionEvent.getAction();
        switch (event) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("Action Down: "+ (int)motionEvent.getX() +", "+ (int)motionEvent.getY());
                rectangle.getRectangle().offsetTo((int)motionEvent.getX(), (int)motionEvent.getY());

                return true;
            case MotionEvent.ACTION_MOVE:
                System.out.println("Action Move: "+ (int)motionEvent.getX() +", "+ (int)motionEvent.getY());
                rectangle.getRectangle().offsetTo((int)motionEvent.getX(), (int)motionEvent.getY());
                return true;
            case MotionEvent.ACTION_UP:
                System.out.println("Action Up: "+ (int)motionEvent.getX() +", "+ (int)motionEvent.getY());

                return true;
        }
        return false;
    }
}