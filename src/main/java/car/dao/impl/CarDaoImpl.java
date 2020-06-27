package car.dao.impl;

import car.dao.CarDao;
import car.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl extends EntityManagerImpl<Car> implements CarDao {
}
