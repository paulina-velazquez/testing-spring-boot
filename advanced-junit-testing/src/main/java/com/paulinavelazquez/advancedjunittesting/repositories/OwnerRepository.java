package com.paulinavelazquez.advancedjunittesting.repositories;

import com.paulinavelazquez.advancedjunittesting.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName (String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
