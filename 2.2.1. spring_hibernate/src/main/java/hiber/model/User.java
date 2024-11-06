package hiber.model;

import javax.persistence.*;

/**
 * Класс-сущность юзер
 */
@Entity
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @JoinColumn(name = "id_car")
   @OneToOne (cascade = CascadeType.ALL)
   private Car userCar;

   /**
    * Конструкторы для класса-сущности
    */

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public User(String firstName, String lastName, String email, Car userCar) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.userCar = userCar;
   }

   /**
    * Геттеры и сеттеры полей
    */

   public Long getId() {
      return id;
   }

   //закомменчен, чтобы не было возможности менять id
   /*
   public void setId(Long id) {
      this.id = id;
   }*/

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getUserCar() {
      return userCar;
   }

   public void setUserCar(Car userCar) {
      this.userCar = userCar;
   }


}
