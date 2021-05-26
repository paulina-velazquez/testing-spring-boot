package com.paulinavelazquez.testingjavajunit5.services;

import com.paulinavelazquez.testingjavajunit5.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
