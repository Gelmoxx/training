package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long> {
    @Override
    List<CarEntity> findAll();
    Optional<CarEntity> findById(Long carId);
}
