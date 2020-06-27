package car.model.dto;

import car.model.Car;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class CarRequestDto {
    private LocalDateTime dateOfCreation;
    private Car.EngineType engineType;
    private long maxSpeed;
    private float acceleration;
    private long capacity;
    private long passengersInside;
    private long currentSpeed;
    private List<CarWheelRequestDto> wheels;
    private List<CarDoorRequestDto> doors;
}
