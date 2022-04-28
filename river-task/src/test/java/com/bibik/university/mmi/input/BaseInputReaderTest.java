package com.bibik.university.mmi.input;

import com.bibik.university.mmi.context.State;
import com.bibik.university.mmi.context.StateImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseInputReaderTest {

    InputReader reader = new BaseInputReader();

    @Test
    void shouldThrowExceptionWhenProvidedNullArguments() {
        Assertions.assertThrows( InputReaderException.class,
                () -> reader.read( null )
        );
    }

    @Test
    void shouldThrowExceptionWhenProvidedNotAllowedArgumentsValue() {
        Assertions.assertThrows( InputReaderException.class,
                () -> reader.read( new String[]{"0", "1", "1", "2"} )
        );
    }

    @Test
    void shouldThrowExceptionWhenProvidedNotAllowedArguments() {
        Assertions.assertThrows( InputReaderException.class,
                () -> reader.read( new String[]{"0", "1", "1", "aa"} )
        );
    }

    @Test
    void shouldReturnExcpectedStateFromInput() throws InputReaderException {
        final State expected = new StateImpl( 0b0110 );
        final State actual = reader.read( new String[]{"0", "1", "1", "0"} );
        Assertions.assertEquals( expected, actual );
    }

}