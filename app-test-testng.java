package com.healthcare;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AppTest {
    
    @Test
    public void testApp() {
        assertTrue(true, "App should return true");
    }

    @Test
    public void testAddition() {
        assertEquals(2 + 2, 4, "2 + 2 should equal 4");
    }

    @Test
    public void testString() {
        String str = "Hello, World!";
        assertNotNull(str, "String should not be null");
        assertTrue(str.contains("Hello"), "String should contain 'Hello'");
    }
}
