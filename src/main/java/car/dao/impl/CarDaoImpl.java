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
    private CarDoorDao carDoorDao;
    private CarWheelDao carWheelDao;

    public CarDaoImpl(CarDoorDao carDoorDao, CarWheelDao carWheelDao) {
        this.carDoorDao = carDoorDao;
        this.carWheelDao = carWheelDao;
    }

    @Override
    public Car add(Car car) {
        for (CarWheel carWheel: car.getWheels()) {
            if (carWheel.getId() == null) {
                carWheelDao.add(carWheel);
            }
        }
        for (CarDoor carDoor: car.getDoors()) {
            if (carDoor.getId() == null) {
                carDoorDao.add(carDoor);
            }
        }
        return super.add(car);
    }
}
