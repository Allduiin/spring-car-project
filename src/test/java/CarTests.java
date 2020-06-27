import car.config.AppConfig;
import car.exceptions.CarCanNotDoActionException;
import car.model.Car;
import car.model.CarWheel;
import car.service.CarService;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarTests {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    private static CarService carService;
    private static Car car;
    private static final LocalDateTime DATE_OF_CREATION = LocalDateTime.MIN;
    private static final Car.EngineType ENGINE_TYPE = Car.EngineType.V6;
    private static final long MAX_SPEED = 320;
    private static final float ACCELERATION = 1.9f;
    private static final long CAPACITY = 4;

    @BeforeClass
    public static void before() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        carService = context.getBean(CarService.class);
        car = new Car(DATE_OF_CREATION, ENGINE_TYPE, MAX_SPEED, ACCELERATION, CAPACITY);
    }

    @Test
    public void addPassengerTest() {
        car.setPassengersInside(0);
        car.addPassenger();
        Assert.assertEquals("Car should add one passenger", 1, car.getPassengersInside());
    }

    @Test
    public void addPassengerToFullCarTest() {
        expectedEx.expect(CarCanNotDoActionException.class);
        expectedEx.expectMessage("There no capacity inside car");

        car.setPassengersInside(car.getCapacity());
        car.addPassenger();
    }

    @Test
    public void removePassengerTest() {
        int passengers = 3;
        car.setPassengersInside(passengers);
        car.removePassenger();
        Assert.assertEquals("Car should remove one passenger",
                passengers - 1, car.getPassengersInside());
    }

    @Test
    public void removePassengerFromEmptyCarTest() {
        expectedEx.expect(CarCanNotDoActionException.class);
        expectedEx.expectMessage("There no passengers inside car");

        int passengers = 0;
        car.setPassengersInside(passengers);
        car.removePassenger();
    }

    @Test
    public void addWheelsTest() {
        int size = car.getWheels().size();
        int count = 10;
        car.addWheelsToCar(count);
        Assert.assertEquals("Car should can correctly add wheels",
                size + count, car.getWheels().size());
    }

    @Test
    public void addNegativeCountOfWheelsTest() {
        expectedEx.expect(CarCanNotDoActionException.class);
        expectedEx.expectMessage("Car can't add negative count of wheels");

        car.addWheelsToCar(-10);
    }

    @Test
    public void removeWheels() {
        car.getWheels().add(new CarWheel());
        car.removeWheels();
        Assert.assertEquals("Car should remove all wheels", 0, car.getWheels().size());
    }

    @Test
    public void changeSpeedNormalTest() {
        if (car.getPassengersInside() <= 0) {
            car.setPassengersInside(1);
        }
        car.getWheels().add(new CarWheel());
        carService.changeSpeed(30, car);
        Assert.assertEquals("Car must change speed", 30, car.getCurrentSpeed());
    }

    @Test
    public void changeTooHighSpeedTest() {
        expectedEx.expect(CarCanNotDoActionException.class);
        expectedEx.expectMessage("Speed to change do not meet the credentials");

        if (car.getPassengersInside() <= 0) {
            car.setPassengersInside(1);
        }
        if (car.getWheels().size() == 0) {
            car.getWheels().add(new CarWheel());
        }
        carService.changeSpeed(500, car);
    }

    @Test
    public void changeToNegativeSpeedTest() {
        expectedEx.expect(CarCanNotDoActionException.class);
        expectedEx.expectMessage("Speed to change do not meet the credentials");

        if (car.getPassengersInside() <= 0) {
            car.setPassengersInside(1);
        }
        if (car.getWheels().size() == 0) {
            car.getWheels().add(new CarWheel());
        }
        carService.changeSpeed(-10, car);
    }

    @Test
    public void getRealMaxSpeedNormalTest() {
        if (car.getPassengersInside() <= 0) {
            car.setPassengersInside(1);
        }
        float minTireOfWheel = 0.3f;
        List<CarWheel> wheels = car.getWheels();
        wheels.clear();
        wheels.add(new CarWheel());
        wheels.get(0).setTireState(minTireOfWheel);
        Assert.assertEquals("Not correctly count of realMaxSpeed",
                MAX_SPEED * minTireOfWheel, carService.getRealMaxSpeed(car), 0);
    }

    @Test
    public void getRealMaxSpeedWithOutPassengersTest() {
        car.setPassengersInside(0);
        Assert.assertEquals("Car can't go without passengers", 0, carService.getRealMaxSpeed(car), 0);
    }

    @Test
    public void getRealMaxSpeedWithOutWheelsTest() {
        car.getWheels().clear();
        Assert.assertEquals("Car can't go without passengers", 0, carService.getRealMaxSpeed(car), 0);
    }
}
