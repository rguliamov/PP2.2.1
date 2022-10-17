package hiber.dao;

import hiber.model.Car;

import java.util.List;

/**
 * @author Guliamov Rustam
 */
public interface CarDao {

    void add(Car car);

    List<Car> getCars();
}
