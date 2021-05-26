package com.paulinavelazquez.testingjavajunit5.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1l, "Veronica", "Sambors");

        // then
        assertAll("Test Props Set",
                () -> assertEquals( "Veronica", person.getFirstName(), "First name do not match"),
                () -> assertEquals("Sambors", person.getLastName(), "Last name do not match"));
    }

    @Test
    void groupedAssertionsFail() {
        // given
        Person person = new Person(1l, "Veronica", "Sambors");

        // then
        assertAll("Test Props Set",
                () -> assertEquals( "Veronica", person.getFirstName(), "First named failed"),
                () -> assertEquals("Sambors", person.getLastName(), "Last name failed"));
    }
}
