package car.mappers;

import car.model.Car;
import car.model.dto.CarRequestDto;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final CarWheelMapper carWheelMapper;
    private final CarDoorMapper carDoorMapper;

    public CarMapper(CarWheelMapper carWheelMapper, CarDoorMapper carDoorMapper) {
        this.carWheelMapper = carWheelMapper;
        this.carDoorMapper = carDoorMapper;
    }

    public Car getCarFromCarRequestDto(CarRequestDto carRequestDto) {
        Car car = new Car();
        car.setDateOfCreation(carRequestDto.getDateOfCreation());
        car.setEngineType(carRequestDto.getEngineType());
        car.setMaxSpeed(carRequestDto.getMaxSpeed());
        car.setAcceleration(carRequestDto.getAcceleration());
        car.setCapacity(carRequestDto.getCapacity());
        car.setCurrentSpeed(carRequestDto.getCurrentSpeed());
        if (carRequestDto.getWheels() != null) {
            car.setWheels(carRequestDto
                    .getWheels()
                    .stream()
                    .map(carWheelRequestDto ->
                            carWheelMapper.getCarWheelFromCarWheelRequestDto(carWheelRequestDto))
                    .collect(Collectors.toList()));
        }
        if (carRequestDto.getDoors() != null) {
            car.setDoors(carRequestDto
                    .getDoors()
                    .stream()
                    .map(carDoorRequestDto ->
                            carDoorMapper.getCarDoorFromCarDoorRequestDto(carDoorRequestDto))
                    .collect(Collectors.toList()));
        }
        return car;
    }
}
