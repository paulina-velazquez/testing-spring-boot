package com.paulinavelazquez.advancedjunittesting.model;

import com.paulinavelazquez.advancedjunittesting.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Veronica", "Sambors");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Veronica", person.getFirstName(), "First name do not match"),
                () -> assertEquals("Sambors", person.getLastName(), "Last name do not match"));
    }

    @Test
    void groupedAssertionsFail() {
        // given
        Person person = new Person(1L, "Veronica", "Sambors");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Veronica", person.getFirstName(), "First name do not match"),
                () -> assertEquals("Sambors", person.getLastName(), "Last name do not match"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void myRepeatedTest() {
        // todo - impl
    }
}
