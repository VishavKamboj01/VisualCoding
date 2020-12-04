package com.example.visualcoding.ui.helpers;

public class FrameController {
    int fps;
    double frameStartTime, frameEndTime, currFrameTime, frameTimeSeconds,
            frameTimeMilliSeconds, frameTimeNanoSeconds;

    public FrameController(int fps) {
        this.fps = fps;
        this.frameTimeSeconds = 1.0 / fps;
        this.frameTimeMilliSeconds = frameTimeSeconds * 1000;
        this.frameTimeNanoSeconds = frameTimeMilliSeconds * 1000000;
    }

    public void startFrame() {
        frameStartTime = System.nanoTime();
    }

    public void endFrame() {
        frameEndTime = System.nanoTime();
    }

    public boolean shouldWait() {
        currFrameTime = frameEndTime - frameStartTime;
        return currFrameTime < frameTimeNanoSeconds;
    }

    public long getWaitTimeMillis() {
        return (long) ((frameTimeNanoSeconds - currFrameTime) / 1000000);
    }
}
