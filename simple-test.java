package com.healthcare;

   import org.testng.annotations.Test;
   import static org.testng.Assert.*;

   public class SimpleTest {
       @Test
       public void simpleTest() {
           assertTrue(true, "This test should always pass");
       }
   }
   