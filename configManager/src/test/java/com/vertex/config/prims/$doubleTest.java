package com.vertex.config.prims;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $doubleTest {
    @Before
    public void setUp() {
        System.setProperty("testProperty1", "9.7");
        System.setProperty("testProperty2", "df");
        System.setProperty("testProperty3", "-9.7");

    }
    @Test
    public void shouldCorrectlyProcessDoubleValues1 () {
        $double prop = new $double("testProperty1", 9.77);

        assertEquals(9.7, prop.get(),0.000001);
    }

    @Test
    public void shouldCorrectlyProcessDoubleValues2 () {
        $double prop = new $double("testProperty2", 10.5);

        assertEquals(10.5, prop.get(),0.000001);
    }
    @Test
    public void shouldCorrectlyProcessDoubleValues3 () {
        $double prop = new $double("testProperty3", 10.5);

        assertEquals(-9.7, prop.get(),0.000001);
    }

}
