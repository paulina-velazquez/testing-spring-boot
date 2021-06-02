package com.paulinavelazquez.advancedjunittesting;

import org.junit.jupiter.api.*;

@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutputter(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }
}
