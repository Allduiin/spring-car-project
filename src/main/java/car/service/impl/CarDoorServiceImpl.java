package car.service.impl;

import car.dao.CarDoorDao;
import car.model.CarDoor;
import car.service.CarDoorService;
import org.springframework.stereotype.Service;

@Service
public class CarDoorServiceImpl implements CarDoorService {
    private final CarDoorDao carDoorDao;

    public CarDoorServiceImpl(CarDoorDao carDoorDao) {
        this.carDoorDao = carDoorDao;
    }

    @Override
    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
    }
}
