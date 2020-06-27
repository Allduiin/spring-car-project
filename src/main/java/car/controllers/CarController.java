package car.controllers;

import car.mappers.CarMapper;
import car.model.dto.CarRequestDto;
import car.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @PostMapping
    public void addCar(@RequestBody CarRequestDto carRequestDto) {
        carService.add(carMapper.getCarFromCarRequestDto(carRequestDto));
    }
}
