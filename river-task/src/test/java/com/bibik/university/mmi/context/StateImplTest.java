package com.bibik.university.mmi.context;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StateImplTest {

    public static final int INITIAL_STATE = 0b0110;

    State state;

    StateImplTest() {
        state = new StateImpl( INITIAL_STATE );
    }

    @Test
    void shouldReturnStateAsString() {
        final String expected = "[0, 1, 1, 0]";
        final String actual = state.getAsString();
        Assertions.assertEquals( expected, actual );
    }

    @Test
    void shouldReturnStateAsInteger() {
        final int actual = state.getAsInt();
        Assertions.assertEquals( INITIAL_STATE, actual );
    }

    @Test
    void shouldReturnStateAsArray() {
        final byte[] expected = new byte[]{0, 1, 1, 0};
        final byte[] actual = state.getAsArray();
        Assertions.assertArrayEquals( expected, actual );
    }

    @Test
    void shouldApplyActionOnTheStateCorrectly() {
        final State action = new StateImpl( 0b1001 );
        final State expected = new StateImpl( 0b1111 );
        final State actual = state.applyAction( action );
        Assertions.assertEquals( expected, actual );
    }

    @Test
    void shouldCreateStateFromGivenByteArray() {
        final String expected = "[1, 0, 1, 1]";
        final String actual = new StateImpl( new byte[]{1, 0, 1, 1} ).getAsString();
        Assertions.assertEquals( expected, actual );
    }

}