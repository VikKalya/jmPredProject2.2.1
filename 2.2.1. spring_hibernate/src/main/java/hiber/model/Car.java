package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class Car {
    private String model;
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;
    @Id
    @GeneratedValue
    private Long id;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car(){}

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
