package car.service;

import car.model.Car;

public interface CarService extends GenericService<Car> {
    Car add(Car car);

    float getRealMaxSpeed(Car car);

    void changeSpeed(long speed, Car car);
}
