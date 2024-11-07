package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

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
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   /**
    * Метод, который возвращает бъект типа User из таблицы users по модели и серии взятых из объекта типа Car
    * Сущность Car связана со столбцом userCar таблицы users односторонней связью OneToOne
    * Поиск идёт по двум колонкам с использованием лгического оператора И (AND)
    * @param car - Объект типа Car
    * @return объект типа User
    */
   @Override
   public User getUserForCar(Car car) {
       String hql = "FROM User u WHERE u.userCar.model = :model AND u.userCar.series = :series";
       return sessionFactory.getCurrentSession().createQuery(hql, User.class)
               .setParameter("model", car.getModel())
               .setParameter("series", car.getSeries())
               .uniqueResult();
   }

   /**
    * Перегруженный вариант метода getUserForCar(Car car), но для поиска исключительно по передаваемым модели и серии,
    * не связанными с объектом типа Car
    * @param model модель машины, тип String
    * @param series серия машины, тип int
    * @return объект типа User  
    */
   @Override
   public User getUserForCar(String model, int series) {
      String hql = "FROM User u WHERE u.userCar.model = :model AND u.userCar.series = :series";
      return sessionFactory.getCurrentSession().createQuery(hql, User.class)
              .setParameter("model", model)
              .setParameter("series", series)
              .uniqueResult();
   }
}
