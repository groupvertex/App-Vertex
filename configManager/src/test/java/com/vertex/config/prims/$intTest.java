package com.vertex.config.prims;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $intTest {

    @Before
    public void setUp() {
        System.setProperty("testProperty1i", "101");
        System.setProperty("testProperty2i", "ddg45h3");
        System.setProperty("testProperty3i", "");
        System.setProperty("testProperty4i", "17.37");

    }
    @Test
    public void shouldCorrectlyProcessIntValues1() {
        $int prop1 = new $int("testProperty1i", 27);
        assertEquals(27, prop1.get());
    }
    @Test
    public void shouldCorrectlyProcessIntValues2() {
        $int prop2 = new $int("testProperty2i", 17);
        assertEquals(17, prop2.get());
    }
    @Test
    public void shouldCorrectlyProcessIntValues3() {
        $int prop3 = new $int("testProperty3i", 17);
        assertEquals(17, prop3.get());
    }
    @Test
    public void shouldCorrectlyProcessIntValues4() {
        $int prop4 = new $int("testProperty4i", 17);
        assertEquals(17, prop4.get());
    }
}