package com.paulinavelazquez.advancedjunittesting.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

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
}
