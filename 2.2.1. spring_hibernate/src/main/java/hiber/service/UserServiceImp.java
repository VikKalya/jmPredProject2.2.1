package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private SessionFactory sessionFactory;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public User getUserCar(String model, int series) {
      String hql = "FROM Car where model = :car_model and series = :car_series";
      TypedQuery <Car> query = sessionFactory.openSession().createQuery(hql);
      query.setParameter("car_model", model);
      query.setParameter("car_series", series);
      List<Car> carList = query.getResultList();
      Car findCar = carList.get(0);
      return findCar.getUser();
   }
}

