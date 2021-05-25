package com.paulinavelazquez.gettingstartedwithjunit5;

import org.junit.jupiter.api.*;

class GreetingTest {

    private Greeting greeting;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("** BeforeAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("* beforeEach");
        greeting = new Greeting();
    }

    @Test
    void helloWorld() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    void helloWorld1() {
        System.out.println(greeting.helloWorld("Paulina"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("* afterEach");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("** AfterAll");
    }
}