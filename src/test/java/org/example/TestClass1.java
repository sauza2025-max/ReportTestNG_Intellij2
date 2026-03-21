package org.example;

import org.testng.annotations.Test;

public class TestClass1 {
    @Test
    public void testMethod1() {
        System.out.println("This is test method1 from SecondTestClass");
    }
    @Test
    public void testMethod2() {
        System.out.println("This is test method1 from FirstTestClass");
    }
    @Test
    public void testMethod3() {
        System.out.println("This is test method2 from FirstTestClass");
    }
    @Test
    public void testMethod4() {
        System.out.println("This is test method3 from FirstTestClass");
    }
    @Test
    public void testMethod5() {
        System.out.println("This is test method4 from FirstTestClass");
    }
    @Test
    public void testMethod6() {
        System.out.println("This is test method5 from FirstTestClass");
    }
}