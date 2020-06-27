package car.model.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CarWheelRequestDto {
    @NotNull
    private Float tireState;
}
