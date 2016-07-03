package com.vertex.config.prims;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $intTest {

    @Before
    public void setUp() {
        System.setProperty("testProperty1", "10");
        System.setProperty("testProperty2", "ddg45h3");
        System.setProperty("testProperty3", "-37");

    }
    @Test
    public void shouldCorrectlyProcessIntValues() {
        $int prop = new $int("testProperty1", 17);
        assertEquals(10, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessBadIntValues() {
        $int prop = new $int("testProperty2", 17);
        assertEquals(17, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessMinesIntValues() {
        $int prop = new $int("testProperty3", 17);
        assertEquals(-37, prop.get());
    }
}