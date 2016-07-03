package com.vertex.config.prims;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $StringTest {
    @Before
    public void setUp() {
        System.setProperty("testProperty1", "fgs");
        System.setProperty("testProperty2", "");

    }
    @Test
    public void shouldCorrectlyProcessStringValues1 () {
        $String prop = new $String("testProperty1", "fgs");

        assertEquals("fgs", prop.get());
    }
    @Test
    public void shouldCorrectlyProcessStringValues2 () {
        $String prop = new $String("testProperty2", "fgs");

        assertEquals("", prop.get());
    }


}