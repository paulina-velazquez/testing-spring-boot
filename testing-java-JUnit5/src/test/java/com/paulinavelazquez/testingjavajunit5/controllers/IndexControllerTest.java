package com.paulinavelazquez.testingjavajunit5.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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

    // AssertJ
    @DisplayName("Test Proper View using AssertJ")
    @Test
    void testingIndexUsingAssertJ() {
        assertThat(controller.index()).isEqualTo("index");
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

    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Inside testTimeOut test");
        });
    }

    @Test
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Inside testTimeOutPrempt test");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU")));
    }

    // Conditional Execution
    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "pau")
    @Test
    void testIfUserPau() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testIfUserFred() {
    }
}















