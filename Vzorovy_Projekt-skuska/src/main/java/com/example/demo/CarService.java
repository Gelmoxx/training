package com.example.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final BrandRepository brandRepository;

    public CarService(CarRepository carRepository, BrandRepository brandRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
    }

    private static CarDto mapToCarDto(CarEntity carEntity){
        CarDto carDto = new CarDto();

        carDto.setId(carEntity.getId());
        carDto.setCarName(carEntity.getCarName());
        carDto.setHorsePower(carEntity.getHorsePower());
        carDto.setCarType(carEntity.getCarType());
        carDto.setBrandId(carEntity.getCarBrand().getId());
        carDto.setBrandName(carEntity.getCarBrand().getBrandName());

        return carDto;
    }

    @Transactional
    public List<CarDto> getCars(String carName){
        List<CarDto> cars = new LinkedList<>();
        for(CarEntity c1 : carRepository.findAll()){
            CarDto c2 = mapToCarDto(c1);
            cars.add(c2);
        }
        return cars;
    }

    @Transactional
    public CarDto getCar(Long carId){
        Optional<CarEntity> byId = carRepository.findById(carId);
        if(byId.isPresent()){
            return mapToCarDto(byId.get());
        }
        return null;
    }

    @Transactional
    public Long createCar(CarDto carDto){
        CarEntity carEntity = new CarEntity();

        Optional<BrandEntity> brand = brandRepository.findById(carDto.getBrandId());

        carEntity.setCarName(carDto.getCarName());
        carEntity.setHorsePower(carDto.getHorsePower());
        carEntity.setCarType(carDto.getCarType());
        carEntity.setCarBrand(brand.get());

        this.carRepository.save(carEntity);
        return carEntity.getId();
    }

    @Transactional
    public void updateCar(Long carId, CarDto carDto){
        Optional<CarEntity> byId = carRepository.findById(carId);
        if(byId.isPresent()){
            byId.get().setCarName(carDto.getCarName());
            byId.get().setHorsePower(carDto.getHorsePower());
            byId.get().setCarType(carDto.getCarType());
            byId.get().setCarBrand(brandRepository.findById(carDto.getBrandId()).get());
        }
    }

    @Transactional
    public void deleteCar(Long carId){
        Optional<CarEntity> byId = carRepository.findById(carId);
        if(byId.isPresent()){
            carRepository.delete(byId.get());
        }
    }
}
