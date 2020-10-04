package com.example.visualcoding.game_objects;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class WhileLoop extends CodeObject {
    private Condition loopCondition;
    private ArrayList<CodeObject> encapsulatedStatements;
    public WhileLoop(String id) {
        super(id);
        encapsulatedStatements = new ArrayList<>();
    }

    public void addStatement(CodeObject object) {
        encapsulatedStatements.add(object);
    }

    public Condition getLoopCondition() {
        return loopCondition;
    }

    public WhileLoop setLoopCondition(Condition loopCondition) {
        this.loopCondition = loopCondition;
        return this;
    }

    @Override
    public boolean evaluate() {
        if(loopCondition.evaluate()) {
            for (CodeObject statement : encapsulatedStatements) {
                statement.evaluate();
            }
            return true;
        }
        return false;
    }

    @NonNull
    @Override
    public String toString() {
        return "WHILE";
    }
}
