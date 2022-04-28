package com.bibik.university.mmi.context;

public interface State {

    int getAsInt();

    String getAsString();

    byte[] getAsArray();

    State applyAction(State action);
}
