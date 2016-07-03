package com.vertex.config.prims;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $intTest {

    @Before
    public void setUp() {
        System.setProperty("testProperty1i", "10");
        System.setProperty("testProperty2i", "ddg45h3");
        System.setProperty("testProperty3i", "");
        System.setProperty("testProperty4i", "17.37");

    }
    @Test
    public void shouldCorrectlyProcessIntValues() {
        $int prop = new $int("testProperty1i", 17);
        assertEquals(10, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessStringIntValues() {
        $int prop = new $int("testProperty2i", 17);
        assertEquals(17, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessEmptyIntValues() {
        $int prop = new $int("testProperty3i", 17);
        assertEquals(17, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessDoubleIntValues() {
        $int prop = new $int("testProperty4i", 17);
        assertEquals(17, prop.get());
    }
}