package car.mappers;

import car.model.CarWheel;
import car.model.dto.CarWheelRequestDto;
import org.springframework.stereotype.Component;

@Component
public class CarWheelMapper {
    public CarWheel getCarWheelFromCarWheelRequestDto(CarWheelRequestDto carWheelRequestDto) {
        CarWheel carWheel = new CarWheel();
        carWheel.setTireState(carWheelRequestDto.getTireState());
        return carWheel;
    }
}
