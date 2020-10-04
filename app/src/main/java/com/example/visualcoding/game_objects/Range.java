package com.example.visualcoding.game_objects;

public class Range {
    private int lowerBound, upperBound, currentValue;
    public Range(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.currentValue = 0;
    }

    public Range() {
        this.lowerBound = 0;
        this.upperBound = 0;
        this.currentValue = 0;
    }

    public Range reset() {
        currentValue = 0;
        return this;
    }

    public int iterate() {
        currentValue++;
        return currentValue;
    }

    public Range setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
        return this;
    }

    public Range setUpperBound(int upperBound) {
        this.upperBound = upperBound;
        return this;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }
}
