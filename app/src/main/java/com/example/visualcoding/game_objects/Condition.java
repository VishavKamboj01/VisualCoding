package com.example.visualcoding.game_objects;

public class Condition {
    private ConditionParam leftHandSide, rightHandSide;
    private ConditionOperationType operation;
    public Condition() {}

    public Condition(ConditionParam leftHandSide, ConditionOperationType operation, ConditionParam rightHandSide) {
        this.leftHandSide = leftHandSide;
        this.operation = operation;
        this.rightHandSide = rightHandSide;
    }

    public boolean evaluate() {
        return leftHandSide.evaluate(operation, rightHandSide);
    }

    public ConditionParam getLeftHandSide() {
        return leftHandSide;
    }

    public Condition setLeftHandSide(ConditionParam leftHandSide) {
        this.leftHandSide = leftHandSide;
        return this;
    }

    public ConditionOperationType getOperation() {
        return operation;
    }

    public Condition setOperation(ConditionOperationType operation) {
        this.operation = operation;
        return this;
    }

    public ConditionParam getRightHandSide() {
        return rightHandSide;
    }

    public Condition setRightHandSide(ConditionParam rightHandSide) {
        this.rightHandSide = rightHandSide;
        return this;
    }
}
