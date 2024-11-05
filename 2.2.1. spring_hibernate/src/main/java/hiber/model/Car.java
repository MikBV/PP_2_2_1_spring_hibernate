package hiber.model;

import javax.persistence.*;

/**
 * Класс-сущность Car
 */
@Entity
@Table (name = "car")
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_car;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

}
