package com.meli_play.desafio_quality.repository;

import com.meli_play.desafio_quality.models.District;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends CrudRepository<District, Long> {
    boolean existsByDistrictName(String name);
}
