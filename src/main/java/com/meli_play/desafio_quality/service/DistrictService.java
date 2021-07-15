package com.meli_play.desafio_quality.service;

import com.meli_play.desafio_quality.exception.NotFoundException;
import com.meli_play.desafio_quality.models.District;
import com.meli_play.desafio_quality.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    @Autowired
    DistrictRepository districtRepository;

    public void addDistrict(District district){
        districtRepository.save(district);
    }

    public District getDistrict(Long id){
        return districtRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("[ %s ] id district not found", id)));
    }
}
