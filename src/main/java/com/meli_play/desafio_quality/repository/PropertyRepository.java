package com.meli_play.desafio_quality.repository;

import com.meli_play.desafio_quality.models.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {
}
