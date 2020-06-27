package car.service.impl;

import car.dao.CarDao;
import car.exceptions.CarCanNotDoActionException;
import car.model.Car;
import car.model.CarWheel;
import car.service.CarService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Car add(Car car) {
        return carDao.add(car);
    }

    @Override
    public float getRealMaxSpeed(Car car) {
        List<CarWheel> wheels = car.getWheels();
        if (car.getPassengersInside() == 0 || car.getWheels().size() == 0) {
            return 0;
        }
        float minTire = wheels.get(0).getTireState();
        for (int i = 1; i < wheels.size(); i++) {
            minTire = Math.min(minTire, wheels.get(i).getTireState());
        }
        return car.getMaxSpeed() * minTire;
    }

    @Override
    public void changeSpeed(long speed, Car car) {
        if (speed > 0 && speed < getRealMaxSpeed(car)) {
            car.setCurrentSpeed(speed);
        } else {
            throw new CarCanNotDoActionException("Speed to change do not meet the credentials");
        }
    }
}
