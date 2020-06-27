package car.controllers;

import car.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @PostMapping
    public Car addCar(Car car) {
        return null;
    }
}
