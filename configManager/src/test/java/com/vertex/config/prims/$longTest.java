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
        System.setProperty("testProperty1l", "100500");
        System.setProperty("testProperty2l", "ddg45h3");
        System.setProperty("testProperty3l", "");
        System.setProperty("testProperty4l", "17.37");

    }
    @Test
    public void shouldCorrectlyProcessLongValues() {
        $long prop = new $long("testProperty1l", 995001001);
        assertEquals(100500, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessBadLongValues() {
        $long prop = new $long("testProperty2l", 995001001);
        assertEquals(995001001, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessMinesLongValues() {
        $long prop = new $long("testProperty3l", 995001001);
        assertEquals(995001001, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessDoubleLongValues() {
        $int prop = new $int("testProperty4i", 995001001);
        assertEquals(995001001, prop.get());
    }
}