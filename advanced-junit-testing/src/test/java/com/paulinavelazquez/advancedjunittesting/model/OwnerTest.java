package com.paulinavelazquez.advancedjunittesting.model;

import com.paulinavelazquez.advancedjunittesting.ModelTests;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

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

    // Parameterized Value Source & Display Name
    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    // Enum Test
    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }
}