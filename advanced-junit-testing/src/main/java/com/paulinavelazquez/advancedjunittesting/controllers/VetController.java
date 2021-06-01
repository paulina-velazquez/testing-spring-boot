package com.paulinavelazquez.advancedjunittesting.controllers;

import com.paulinavelazquez.advancedjunittesting.fauxspring.Model;
import com.paulinavelazquez.advancedjunittesting.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
