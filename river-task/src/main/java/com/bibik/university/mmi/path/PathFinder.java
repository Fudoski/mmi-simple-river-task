package com.bibik.university.mmi.path;

import com.bibik.university.mmi.context.State;

import java.util.List;

public interface PathFinder {

    List<Path> find(State inputState) throws PathFinderException;
}
