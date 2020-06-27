package car.controllers;

import car.mappers.CarDoorMapper;
import car.model.dto.CarDoorRequestDto;
import car.service.CarDoorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars-doors")
public class CarDoorController {
    private final CarDoorMapper mapper;
    private final CarDoorService carDoorService;

    public CarDoorController(CarDoorMapper mapper, CarDoorService carDoorService) {
        this.mapper = mapper;
        this.carDoorService = carDoorService;
    }

    @PostMapping
    public void add(@RequestBody CarDoorRequestDto carDoorRequestDto) {
        carDoorService.add(mapper.getCarDoorFromCarDoorRequestDto(carDoorRequestDto));
    }
}
