package car.mappers;

import car.model.CarDoor;
import car.model.dto.CarDoorRequestDto;
import org.springframework.stereotype.Component;

@Component
public class CarDoorMapper {
    public CarDoor getCarDoorFromCarDoorRequestDto(CarDoorRequestDto carDoorRequestDto) {
        CarDoor carDoor = new CarDoor();
        carDoor.setDoorState(carDoorRequestDto.getDoorState());
        carDoor.setWindowState(carDoorRequestDto.getWindowState());
        return carDoor;
    }
}
