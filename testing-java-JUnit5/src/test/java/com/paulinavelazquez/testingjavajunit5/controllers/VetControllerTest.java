package com.paulinavelazquez.testingjavajunit5.controllers;

import com.paulinavelazquez.testingjavajunit5.fauxspring.Model;
import com.paulinavelazquez.testingjavajunit5.fauxspring.ModelMapImpl;
import com.paulinavelazquez.testingjavajunit5.model.Vet;
import com.paulinavelazquez.testingjavajunit5.services.SpecialityService;
import com.paulinavelazquez.testingjavajunit5.services.VetService;
import com.paulinavelazquez.testingjavajunit5.services.map.SpecialityMapService;
import com.paulinavelazquez.testingjavajunit5.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetService vetService;
    SpecialityService specialityService;
    VetController vetController;


    @BeforeEach
    void setUp() {
        specialityService = new SpecialityMapService();
        vetService = new VetMapService(specialityService);
        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L, "Veronica", "Melendez", null);
        Vet vet2 = new Vet(2L, "Virginia", "Rosa", null);

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        String view = vetController.listVets(model);
        assertEquals("vets/index", view, "wrong view returned"); // JUnit
        assertThat(view).isEqualTo("vets/index"); // AssertJ
    }

    @Test
    void Expecting2Vets() {
        Model model = new ModelMapImpl();
        vetController.listVets(model);
        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}
