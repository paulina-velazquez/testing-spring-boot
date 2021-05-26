package com.paulinavelazquez.testingjavajunit5.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Paola", "Longoria");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Paola", owner.getFirstName(), "First named do not match"),
                        () -> assertEquals("Longoria", owner.getLastName(), "Last name do not match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City do not match"),
                        () -> assertEquals("1231231234", owner.getTelephone(), "Telephone do not match")
        ));

    }
}

