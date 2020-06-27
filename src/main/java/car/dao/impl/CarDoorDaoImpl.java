package car.dao.impl;

import car.dao.CarDoorDao;
import car.model.CarDoor;
import org.springframework.stereotype.Repository;

@Repository
public class CarDoorDaoImpl extends EntityManagerImpl<CarDoor> implements CarDoorDao {
}
