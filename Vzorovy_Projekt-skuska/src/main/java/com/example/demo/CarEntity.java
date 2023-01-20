package com.example.demo;

import javax.persistence.*;

@Entity
public class CarEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String carName;
    private int horsePower;

    @JoinColumn(name = "car_brand")
    @ManyToOne(fetch =  FetchType.LAZY)
    private BrandEntity carBrand;

    private String brandName;

    @Enumerated(EnumType.STRING)
    private CarType carType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public BrandEntity getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(BrandEntity carBrand) {
        this.carBrand = carBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
