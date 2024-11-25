package it.unibo.mvc;

import java.util.List;

public interface Controller {
    void setNextString(String str) throws IllegalArgumentException;
    String getNextString();
    List<String> getHistory();
    void printCurrentString() throws IllegalStateException;
}
