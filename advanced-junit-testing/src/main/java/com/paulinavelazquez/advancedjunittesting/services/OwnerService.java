package com.paulinavelazquez.advancedjunittesting.services;

import com.paulinavelazquez.advancedjunittesting.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
