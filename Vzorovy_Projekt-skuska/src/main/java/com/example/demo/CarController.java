package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/api/cars")
    public List<CarDto> getCars(@RequestParam(required = false) String carName){
        return this.carService.getCars(carName);
    }

    @GetMapping("/api/cars/{carId}")
    public CarDto getCar(@PathVariable Long carId){
        return this.carService.getCar(carId);
    }

    @PostMapping("/api/cars")
    public Long createCar(@RequestBody CarDto carDto){
        return this.carService.createCar(carDto);
    }

    @PutMapping("/api/cars/{carId}")
    public void updateCar(@PathVariable Long carId, @RequestBody CarDto carDto){
        this.carService.updateCar(carId, carDto);
    }

    @DeleteMapping("/api/cars/{carId}")
    public void deleteCar(@PathVariable Long carId){
        this.carService.deleteCar(carId);
    }
}
