package com.vertex.config.prims;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $intTest {

    @Before
    public void setUp() {
        //boolean
        System.setProperty("testProperty1b", "true");
        //double
        System.setProperty("testProperty1d", "9.7");
        System.setProperty("testProperty2d", "df");
        System.setProperty("testProperty3d", "");
        //int
        System.setProperty("testProperty1i", "101");
        System.setProperty("testProperty2i", "ddg45h3");
        System.setProperty("testProperty3i", "");
        System.setProperty("testProperty4i", "17.37");
        //long
        System.setProperty("testProperty1l", "100501");
        System.setProperty("testProperty2l", "ddg45h3");
        System.setProperty("testProperty3l", "");
        System.setProperty("testProperty4l", "17.37");
        //string
        System.setProperty("testProperty1s", "hello world");
        System.setProperty("testProperty2s", "");

    }
    @Test
    public void shouldCorrectlyProcessIntValues1() {
        $int prop1 = new $int("testProperty1i", 27);
        assertEquals(101, prop1.get());
    }
    @Test
    public void shouldCorrectlyProcessIntValues2() {
        $int prop2 = new $int("testProperty2i", 27);
        assertEquals(27, prop2.get());
    }
    @Test
    public void shouldCorrectlyProcessIntValues3() {
        $int prop3 = new $int("testProperty3i", 27);
        assertEquals(27, prop3.get());
    }
    @Test
    public void shouldCorrectlyProcessIntValues4() {
        $int prop4 = new $int("testProperty4i", 27);
        assertEquals(27, prop4.get());
    }
}