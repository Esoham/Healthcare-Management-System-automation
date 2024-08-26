package com.healthcare;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    
    @Test
    public void testApp() {
        assertTrue("App should return true", true);
    }

    @Test
    public void testAddition() {
        assertEquals("2 + 2 should equal 4", 4, 2 + 2);
    }

    @Test
    public void testString() {
        String str = "Hello, World!";
        assertNotNull("String should not be null", str);
        assertTrue("String should contain 'Hello'", str.contains("Hello"));
    }
}
