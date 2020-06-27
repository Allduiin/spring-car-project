package car.service.impl;

import car.dao.CarWheelDao;
import car.model.CarWheel;
import car.service.CarWheelService;
import org.springframework.stereotype.Service;

@Service
public class CarWheelServiceImpl implements CarWheelService {
    private final CarWheelDao carWheelDao;

    public CarWheelServiceImpl(CarWheelDao carWheelDao) {
        this.carWheelDao = carWheelDao;
    }

    @Override
    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }
}
