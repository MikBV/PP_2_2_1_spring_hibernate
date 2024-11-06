package hiber.model;

import javax.persistence.*;

/**
 * Класс-сущность Car с колонками/параметрами:
 * model Строковый (String) с указанием модели машины
 * series целочисленный (int) для серии машины
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

    public Car() {}

    /**
     * Конструктор для класса с параметрами
     * @param model Строковый (String) с указанием модели машины
     * @param series целочисленный (int) для серии машины
     */
    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    /**
     * Геттеры и сеттеры для медели и серии, для ID только геттер.
     */

    public Long getId_car() {
        return id_car;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    /**
     * Переопределённый toString
     */
    @Override
    public String toString() {
        return "Car \n" +
                "\t id_car=" + id_car +
                ", \n\t model='" + model +
                ", \n\t series=" + series;
    }
}
