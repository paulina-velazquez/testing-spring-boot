package com.paulinavelazquez.advancedjunittesting.model;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Paola", "Longoria");
        owner.setCity("Key West");
        owner.setTelephone("123123123");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Paola", owner.getFirstName(), "First name do not match"),
                        () -> assertEquals("Longoria", owner.getLastName(), "Last name do not match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City does not match"),
                        () -> assertEquals("123123123", owner.getTelephone(), "Telephone do not match")
                ));
    }

    @Test
    void dependentAssertionsWithHamcrest() {
        Owner owner = new Owner(1L, "Paola", "Longoria");
        owner.setCity("Key West");
        owner.setTelephone("123123123");
        MatcherAssert.assertThat(owner.getCity(), is("Key West"));
    }
}