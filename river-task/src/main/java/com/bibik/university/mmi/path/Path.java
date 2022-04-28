package com.bibik.university.mmi.path;

import com.bibik.university.mmi.context.State;

import java.util.Deque;

public interface Path {

    void add(Element element);

    Deque<Element> getElements();

    interface Element {

        State getState();

        State getAction();

        State applyActionAndGetState();
    }
}
