package com.example.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    private static BrandDto mapToBrandDto(BrandEntity brandEntity){
        BrandDto brandDto = new BrandDto();

        brandDto.setId(brandEntity.getId());
        brandDto.setBrandName(brandEntity.getBrandName());

        return brandDto;
    }

    @Transactional
    public List<BrandDto> getBrands(String brandName){
        List<BrandDto> brands = new LinkedList<>();
        for(BrandEntity c1 : brandRepository.findAll()){
            BrandDto c2 = mapToBrandDto(c1);
            brands.add(c2);
        }
        return brands;
    }

    @Transactional
    public BrandDto getBrand(Long brandId){
        Optional<BrandEntity> byId = brandRepository.findById(brandId);
        if(byId.isPresent()){
            return mapToBrandDto(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createBrand(BrandDto brandDto){
        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setBrandName(brandDto.getBrandName());

        brandRepository.save(brandEntity);
        return brandEntity.getId();
    }

    @Transactional
    public void updateBrand(Long brandId, BrandDto brandDto){
        Optional<BrandEntity> byId = brandRepository.findById(brandId);
        if(byId.isPresent()){
            byId.get().setBrandName(brandDto.getBrandName());
        }
    }

    @Transactional
    public void deleteBrand(Long brandId){
        Optional<BrandEntity> byId = brandRepository.findById(brandId);
        if(byId.isPresent()){
            brandRepository.delete(byId.get());
        }
    }

}
