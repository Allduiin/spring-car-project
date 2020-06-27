import car.config.AppConfig;
import car.config.WebConfig;
import car.controllers.CarController;
import car.model.Car;
import car.model.CarDoor;
import car.model.CarWheel;
import car.model.dto.CarRequestDto;
import car.service.CarDoorService;
import car.service.CarService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class, WebConfig.class);
        context.getBean(CarDoorService.class).add(new CarDoor());
        Car car = new Car(LocalDateTime.now(), Car.EngineType.V6, 320, 1.9f, 4);
        car.addPassenger();
        car.setWheels(List.of(new CarWheel()));
        car.setDoors(List.of(new CarDoor()));
        context.getBean(CarService.class).add(car);
        context.getBean(CarController.class).addCar(new CarRequestDto());
        System.out.println("It works Congratulations!!!");
        context.close();
    }
}
