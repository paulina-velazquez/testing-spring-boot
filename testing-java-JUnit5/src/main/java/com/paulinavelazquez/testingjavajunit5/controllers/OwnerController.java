package com.paulinavelazquez.testingjavajunit5.controllers;

import com.paulinavelazquez.testingjavajunit5.fauxspring.Model;
import com.paulinavelazquez.testingjavajunit5.model.Owner;
import com.paulinavelazquez.testingjavajunit5.services.OwnerService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

public class OwnerController {
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public String findOwner(Model model) {
        model.addAttribute("owner", new Owner(null, null, null));
        return "owner/findOwners";
    }

    public String processFindForm(Owner owner, BindingResult result, Model model) {
        // allow parametersless GET request for / owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%"+owner.getLastName() + "%");

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", " not found");
            return "owner/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    public ModelAndView showOwner(Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    public String initCreationForm(Model model) {
        model.addAttribute("owner", new Owner(null, null, null));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    public String initUpdateOwnerForm(Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners" + savedOwner.getId();
        }
    }
}

