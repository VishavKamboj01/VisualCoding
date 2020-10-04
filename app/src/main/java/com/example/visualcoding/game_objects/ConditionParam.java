package com.example.visualcoding.game_objects;

public abstract class ConditionParam {
    private String stringVal;
    public ConditionParam() {}

    public abstract boolean evaluate(ConditionOperationType operation, ConditionParam rhs);
    public abstract ConditionParamType getParamType();

    public FloatParam asFloatParam() {
        return (FloatParam) this;
    }

    public IntParam asIntParam() {
        return (IntParam) this;
    }
}
