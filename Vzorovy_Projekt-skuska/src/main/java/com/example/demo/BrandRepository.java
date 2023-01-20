package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends CrudRepository<BrandEntity, Long> {
    @Override
    List<BrandEntity> findAll();
    Optional<BrandEntity> findById(Long brandId);
}
