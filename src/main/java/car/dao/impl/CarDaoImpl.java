package car.dao.impl;

import car.dao.CarDao;
import car.dao.CarDoorDao;
import car.dao.CarWheelDao;
import car.model.Car;
import car.model.CarDoor;
import car.model.CarWheel;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl extends EntityManagerImpl<Car> implements CarDao {
    private final CarDoorDao carDoorDao;
    private final CarWheelDao carWheelDao;

    public CarDaoImpl(CarDoorDao carDoorDao, CarWheelDao carWheelDao) {
        this.carDoorDao = carDoorDao;
        this.carWheelDao = carWheelDao;
    }

    @Override
    public Car add(Car car) {
        if (car.getWheels() != null) {
            for (CarWheel carWheel : car.getWheels()) {
                if (carWheel.getId() == null) {
                    carWheel = carWheelDao.add(carWheel);
                }
            }
        }
        if (car.getDoors() != null) {
            for (CarDoor carDoor : car.getDoors()) {
                if (carDoor.getId() == null) {
                    carDoor = carDoorDao.add(carDoor);
                }
            }
        }
        return super.add(car);
    }
}
