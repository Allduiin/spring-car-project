package car.controllers;

import car.mappers.CarWheelMapper;
import car.model.dto.CarWheelRequestDto;
import car.service.CarWheelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars-wheels")
public class CarWheelController {
    private final CarWheelMapper mapper;
    private final CarWheelService carWheelService;

    public CarWheelController(CarWheelMapper mapper, CarWheelService carWheelService) {
        this.mapper = mapper;
        this.carWheelService = carWheelService;
    }

    @PostMapping
    public void add(@RequestBody CarWheelRequestDto carWheelRequestDto) {
        carWheelService.add(mapper.getCarWheelFromCarWheelRequestDto(carWheelRequestDto));
    }
}
