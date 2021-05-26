package com.paulinavelazquez.testingjavajunit5.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index(), "wrong view returned");
    }

    @Test
    void oopsHandlerNotImplemented() {
        assertTrue("notimplemented".equals(controller.oopsHandlerNotImplemented()), () -> "This is some expensive " +
                "message to build" +
                "for my test");
    }

    @DisplayName("Test exception")
    @Test
    void exceptionHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.exceptionHandler();
        });
    }
}
