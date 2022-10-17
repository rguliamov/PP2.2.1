package hiber.service;

import hiber.model.Car;

import java.util.List;

/**
 * @author Guliamov Rustam
 */
public interface CarService {

    void add(Car car);

    List<Car> getCars();
}
