package com.bibik.university.mmi.path;

import com.bibik.university.mmi.context.State;
import com.bibik.university.mmi.context.StateImpl;
import com.bibik.university.mmi.path.PathImpl.PathElementImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PathImplTest {

    Path path;

    PathImplTest() {
        path = new PathImpl();
    }

    @Test
    void shouldAddElementToPath() {
        List<Path.Element> elements = new ArrayList<>();
        State state = new StateImpl( 0b0000 );
        State action = new StateImpl( 0b1001 );
        Path.Element element = new PathElementImpl( state, action );
        elements.add( element );

        final Path expected = new PathImpl( elements );
        path.add( element );

        Assertions.assertEquals( expected, path );
    }

    public static class ElementImplTest {

        public static final int ELEMENT_STATE = 0b1010;
        public static final int ELEMENT_ACTION = 0b1010;

        Path.Element element;

        public ElementImplTest() {
            State state = new StateImpl( ELEMENT_STATE );
            State action = new StateImpl( ELEMENT_ACTION );
            element = new PathElementImpl( state, action );
        }

        @Test
        void shouldReturnExpectedState() {
            final State expected = new StateImpl( ELEMENT_STATE );
            Assertions.assertEquals( expected, element.getState() );
        }

        @Test
        void shouldReturnExpectedAction() {
            final State expected = new StateImpl( ELEMENT_ACTION );
            Assertions.assertEquals( expected, element.getAction() );
        }

        @Test
        void shouldReturnExpectedAppliedActionState() {
            final State expected = new StateImpl( 0b0000 );
            Assertions.assertEquals( expected, element.applyActionAndGetState() );
        }
    }
}