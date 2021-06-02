package com.paulinavelazquez.advancedjunittesting.controllers;

import com.paulinavelazquez.advancedjunittesting.ControllerTests;
import com.paulinavelazquez.advancedjunittesting.fauxspring.Model;
import com.paulinavelazquez.advancedjunittesting.fauxspring.ModelMapImpl;
import com.paulinavelazquez.advancedjunittesting.model.Vet;
import com.paulinavelazquez.advancedjunittesting.services.SpecialityService;
import com.paulinavelazquez.advancedjunittesting.services.VetService;
import com.paulinavelazquez.advancedjunittesting.services.map.SpecialityMapService;
import com.paulinavelazquez.advancedjunittesting.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VetControllerTest implements ControllerTests {

    VetService vetService;
    SpecialityService specialityService;
    VetController vetController;


    @BeforeEach
    void setUp() {
        specialityService = new SpecialityMapService();
        vetService = new VetMapService(specialityService);
        vetController = new VetController(vetService);

        Vet v1 = new Vet(1l, "Veronica", "Melendez", null);
        Vet v2 = new Vet(2l, "Virginia", "Rosa", null);

        vetService.save(v1);
        vetService.save(v2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        String view = vetController.listVets(model);
        // JUnit
        assertEquals("vets/index", view, "wrong view returned");
        // AssertJ
        assertThat(view).isEqualTo("vets/index");
    }

    @Test
    void expecting2Vets() {
        Model model = new ModelMapImpl();
        vetController.listVets(model);
        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}

