package com.bibik.university.mmi;

import com.bibik.university.mmi.context.State;
import com.bibik.university.mmi.input.BaseInputReader;
import com.bibik.university.mmi.input.InputReader;
import com.bibik.university.mmi.path.BasePathFinder;
import com.bibik.university.mmi.path.Path;
import com.bibik.university.mmi.path.PathFinder;
import com.bibik.university.mmi.path.PathFormatter;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        try {
            InputReader reader = new BaseInputReader();
            State inputState = reader.read( args );

            PathFinder finder = new BasePathFinder();
            List<Path> paths = finder.find( inputState );

            System.out.printf( "Found %d paths%n", paths.size() );
            paths.stream().map( PathFormatter::format ).forEach( System.out::println );
            if (paths.isEmpty()) {
                System.out.println();
            }
        } catch (Exception exception) {
            System.err.println( exception.getMessage() );
        }
    }
}
