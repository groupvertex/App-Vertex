package com.vertex.config.prims;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ololoev on 03.07.2016.
 */
public class $longTest {

    @Before
    public void setUp() {
        System.setProperty("testProperty1l", "100501");
        System.setProperty("testProperty2l", "ddg45h3");
        System.setProperty("testProperty3l", "");
        System.setProperty("testProperty4l", "17.37");

    }
    @Test
    public void shouldCorrectlyProcessLongValues1() {
        $long prop1 = new $long("testProperty1l", 995001001);
        assertEquals(995001001, prop1.get());
    }
    @Test
    public void shouldCorrectlyProcessLongValues2() {
        $long prop2 = new $long("testProperty2l", 995001002);
        assertEquals(995001002, prop2.get());
    }
    @Test
    public void shouldCorrectlyProcessLongValues3() {
        $long prop3 = new $long("testProperty3l", 995001003);
        assertEquals(995001003, prop3.get());
    }
    @Test
    public void shouldCorrectlyProcessLongValues4() {
        $long prop4 = new $long("testProperty4l", 995001004);
        //long a4 = 995001004;
        //assertEquals(a4, prop4.get());
        assertEquals(995001004, prop4.get());
    }
}