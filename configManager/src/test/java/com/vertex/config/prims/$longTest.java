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
        System.setProperty("testProperty1", "100500");
        System.setProperty("testProperty2", "ddg45h3");
        System.setProperty("testProperty3", "-37000999");

    }
    @Test
    public void shouldCorrectlyProcessLongValues() {
        $long prop = new $long("testProperty1", 995001001);
        assertEquals(100500, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessBadLongValues() {
        $long prop = new $long("testProperty2", 995001001);
        assertEquals(995001001, prop.get());
    }
    @Test
    public void shouldCorrectlyProcessMinesLongValues() {
        $long prop = new $long("testProperty3", 995001001);
        assertEquals(-37000999, prop.get());
    }
}