package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping("/api/brands")
    public List<BrandDto> getBrands(@RequestParam(required = false) String brandName){
        return this.brandService.getBrands(brandName);
    }

    @GetMapping("/api/brands/{brandId}")
    public BrandDto getBrand(@PathVariable Long brandId){
        return this.brandService.getBrand(brandId);
    }

    @PostMapping("/api/brands")
    public Long createBrand(@RequestBody BrandDto brandDto){
        return this.brandService.createBrand(brandDto);
    }

    @PutMapping("/api/brands/{brandId}")
    public void updateBrand(@PathVariable Long brandId, @RequestBody BrandDto brandDto){
        this.brandService.updateBrand(brandId, brandDto);
    }

    @DeleteMapping("/api/brands/{brandId}")
    public void deleteBrand(@PathVariable Long brandId){
        this.brandService.deleteBrand(brandId);
    }
}
