package com.vertex.config.prims;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $booleanTest {

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
    public void shouldCorrectlyProcessBooleanValues() {
        $boolean prop = new $boolean("testProperty1b", false);
        assertEquals(true, prop.get());
    }
}