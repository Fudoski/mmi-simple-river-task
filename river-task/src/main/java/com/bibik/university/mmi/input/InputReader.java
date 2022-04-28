package com.bibik.university.mmi.input;

import com.bibik.university.mmi.context.State;

public interface InputReader {

    State read(String[] arguments) throws InputReaderException;
}
