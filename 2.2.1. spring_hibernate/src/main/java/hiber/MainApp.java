package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   static void checkSearchByCar (User user) {
      if (user==null) {
         System.out.printf("I did'n find user with such car\n");
      } else {
         System.out.printf("I find user %s %s with such car\n", user.getFirstName(), user.getLastName());
      }
   }
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Toyota1", 111)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Toyota2", 222)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Toyota3", 333)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Toyota4", 444)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getUserCar().toString());
      }

      String model = "Toyota";
      String model2 = "Toyota2";
      int series = 0;
      int series2 = 222;
      checkSearchByCar(userService.getUserForCar(model, series));
      checkSearchByCar(userService.getUserForCar(model2, series2));



      context.close();
   }
}
