package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car car1 = new Car("bmw", 1000);
      Car car2 = new Car("audi", 200);
      Car car3 = new Car("bmw", 1000);
      Car car4 = new Car("bmw", 1000);


      User user1 = new User("Rustam", "1", "rustam@gmail.com");
      User user2 = new User("Nastia", "2", "nastia@gmail.com");
      User user3 = new User("Kirill", "3", "kirill@gmail.com");
      User user4 = new User("Ivan", "4", "ivan@gmail.com");

      car1.setUser(user1);
      car2.setUser(user2);
      car3.setUser(user3);
      car4.setUser(user4);

      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);

      userService.listUsersByModelAndSeries("bmw", 1000).forEach(user -> System.out.println(user.getFirstName()));

     context.close();
   }
}
