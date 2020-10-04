package com.example.visualcoding.game_objects;

import android.os.Handler;

public class ActionObject extends CodeObject {
    private Handler actionExecutionHandler;
    public ActionObject(String id) {
        super(id);
    }

    @Override
    public boolean evaluate() {
        if(actionExecutionHandler!=null) {
            actionExecutionHandler.obtainMessage().sendToTarget();
            return true;
        }
        return false;
    }
}
