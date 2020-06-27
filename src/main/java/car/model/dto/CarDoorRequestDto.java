package car.model.dto;

import car.model.CarDoor;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CarDoorRequestDto {
    @NotNull
    private CarDoor.DoorState doorState;
    @NotNull
    private CarDoor.WindowState windowState;
}
