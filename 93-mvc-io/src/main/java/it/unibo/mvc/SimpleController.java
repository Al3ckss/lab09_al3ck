package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

public final class SimpleController implements Controller {

    private String currentString;
    private final List<String> history;

    public SimpleController() {
        this.currentString = null;
        this.history = new ArrayList<>();
    }

    @Override
    public void setNextString(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        this.currentString = str;
    }

    @Override
    public String getNextString() {
        return this.currentString;
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(this.history); // Return a copy of the history list
    }

    @Override
    public void printCurrentString() throws IllegalStateException {
        if (this.currentString == null) {
            throw new IllegalStateException("Current string is not set");
        }
        System.out.println(this.currentString);
        this.history.add(this.currentString); // Add to history after printing
    }
}
