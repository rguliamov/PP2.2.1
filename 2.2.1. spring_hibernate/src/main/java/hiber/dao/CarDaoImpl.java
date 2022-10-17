package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Guliamov Rustam
 */
@Repository
@Transactional
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> getCars() {
        Query<Car> queryCars = sessionFactory.getCurrentSession().createQuery("select b from Car b", Car.class);
        return queryCars.list();
    }
}
