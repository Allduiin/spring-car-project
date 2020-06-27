package car.model;

import car.exceptions.CarCanNotDoActionException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateOfCreation;
    private EngineType engineType;
    private long maxSpeed;
    private float acceleration;
    private long capacity;
    private long passengersInside;
    private long currentSpeed;
    @OneToMany
    private List<CarWheel> wheels;
    @OneToMany
    private List<CarDoor> doors;

    public Car() {
    }

    public Car(LocalDateTime dateOfCreation, EngineType engineType,
               long maxSpeed, float acceleration, long capacity) {
        this.dateOfCreation = dateOfCreation;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.capacity = capacity;
        this.wheels = new ArrayList<>();
        this.doors = new ArrayList<>();
    }

    public void addPassenger() {
        if (passengersInside != capacity) {
            passengersInside++;
        } else {
            throw new CarCanNotDoActionException("There no capacity inside car");
        }
    }

    public void removePassenger() {
        if (passengersInside != 0) {
            passengersInside--;
        } else {
            throw new CarCanNotDoActionException("There no passengers inside car");
        }
    }

    public void addWheelsToCar(long amount) {
        if (amount < 0) {
            throw new CarCanNotDoActionException("Car can't add negative count of wheels");
        }
        for (int i = 0; i < amount; i++) {
            wheels.add(new CarWheel());
        }
    }

    public void removeWheels() {
        wheels.clear();
    }

    public CarWheel getWheelById(int id) {
        return wheels.get(id);
    }

    public CarDoor getDoorById(int id) {
        return doors.get(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getPassengersInside() {
        return passengersInside;
    }

    public void setPassengersInside(long passengersInside) {
        this.passengersInside = passengersInside;
    }

    public long getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(long currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public List<CarWheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<CarWheel> wheels) {
        this.wheels = wheels;
    }

    public List<CarDoor> getDoors() {
        return doors;
    }

    public void setDoors(List<CarDoor> doors) {
        this.doors = doors;
    }

    public enum EngineType {
        R3, R4, V4, V6, V8, V10, V12, W12, VR6
    }
}
