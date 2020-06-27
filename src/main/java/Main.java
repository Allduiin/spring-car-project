import car.config.AppConfig;
import car.model.Car;
import car.model.CarDoor;
import car.model.CarWheel;
import car.service.CarService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = new Car(LocalDateTime.now(), Car.EngineType.V6, 320, 1.9f, 4);
        car.addPassenger();
        car.setWheels(List.of(new CarWheel()));
        car.setDoors(List.of(new CarDoor()));
        context.getBean(CarService.class).add(car);
        System.out.println("It works Congratulations!!!");
    }
}
