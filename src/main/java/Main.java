import car.config.AppConfig;
import car.model.Car;
import car.model.CarDoor;
import car.model.CarWheel;
import car.service.CarDoorService;
import car.service.CarService;
import car.service.CarWheelService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        CarDoor carDoor = context.getBean(CarDoorService.class).add(new CarDoor());
        CarWheel carWheel = context.getBean(CarWheelService.class).add(new CarWheel());
        Car car = new Car(LocalDateTime.now(), Car.EngineType.V6, 320, 1.9f, 4);
        car.addPassenger();
        car.setWheels(List.of(carWheel));
        car.setDoors(List.of(carDoor));
        context.getBean(CarService.class).add(car);
        System.out.println("It works Congratulations!!!");
    }
}
