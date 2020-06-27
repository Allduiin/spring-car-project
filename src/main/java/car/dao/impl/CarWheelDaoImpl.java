package car.dao.impl;

import car.dao.CarWheelDao;
import car.model.CarWheel;
import org.springframework.stereotype.Repository;

@Repository
public class CarWheelDaoImpl extends EntityManagerImpl<CarWheel> implements CarWheelDao {
}
