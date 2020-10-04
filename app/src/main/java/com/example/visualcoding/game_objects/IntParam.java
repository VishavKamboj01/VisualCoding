package com.example.visualcoding.game_objects;

public class IntParam extends ConditionParam {
    private int intVal;
    public IntParam(int intVal) {
        this.intVal = intVal;
    }

    public int getIntVal() {
        return intVal;
    }

    @Override
    public boolean evaluate(ConditionOperationType operation, ConditionParam rhs) {
        IntParam rightHandSide = rhs.asIntParam();
        switch (operation) {
            case EQUALS:
                return this.intVal == rightHandSide.getIntVal();
            case NOT_EQUALS:
                return this.intVal != rightHandSide.getIntVal();
            case LESS_THAN:
                return this.intVal < rightHandSide.getIntVal();
            case GREATER_THAN:
                return this.intVal > rightHandSide.getIntVal();
            case LESS_THAN_OR_EQUAL:
                return this.intVal <= rightHandSide.getIntVal();
            case GREATER_THAN_OR_EQUAL:
                return this.intVal >= rightHandSide.getIntVal();
            default:
                return false;
        }
    }

    @Override
    public ConditionParamType getParamType() {
        return ConditionParamType.INTEGER_PARAM;
    }
}
