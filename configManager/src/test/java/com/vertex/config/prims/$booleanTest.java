package com.vertex.config.prims;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $booleanTest {

    @Before
    public void setUp() {
        System.setProperty("testProperty1b", "true");
    }

    @Test
    public void shouldCorrectlyProcessBooleanValues() {
        $boolean prop = new $boolean("testProperty1b", false);
        assertEquals(false, prop.get());
    }
}