package com.example.visualcoding.game_objects;

public class FloatParam extends ConditionParam {
    private float floatVal;
    public FloatParam(float floatVal) {
        this.floatVal = floatVal;
    }

    public float getFloatVal() {
        return floatVal;
    }

    @Override
    public boolean evaluate(ConditionOperationType operation, ConditionParam rhs) {
        FloatParam rightHandSide = rhs.asFloatParam();
        switch (operation) {
            case EQUALS:
                return this.floatVal == rightHandSide.getFloatVal();
            case NOT_EQUALS:
                return this.floatVal != rightHandSide.getFloatVal();
            case LESS_THAN:
                return this.floatVal < rightHandSide.getFloatVal();
            case GREATER_THAN:
                return this.floatVal > rightHandSide.getFloatVal();
            case LESS_THAN_OR_EQUAL:
                return this.floatVal <= rightHandSide.getFloatVal();
            case GREATER_THAN_OR_EQUAL:
                return this.floatVal >= rightHandSide.getFloatVal();
            default:
                return false;
        }
    }

    @Override
    public ConditionParamType getParamType() {
        return ConditionParamType.FLOAT_PARAM;
    }
}
