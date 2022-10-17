package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Guliamov Rustam
 */
@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<User> listUsersByModelAndSeries(String model, int series) {
        String sql = "select user from Car car inner join car.user user where car.model = ?1 and car.series = ?2";
        Query<User> query = sessionFactory.getCurrentSession().createQuery(sql, User.class);
        query.setParameter(1, model);
        query.setParameter(2, series);

        return query.list();
    }
}
