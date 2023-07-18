package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{
    //•	car type – the enumeration, one of the following – SUV, coupe, sport
    //•	car make – accepts char sequence (between 2 to 30 inclusive).
    //•	car model – accepts char sequence (between 2 to 30 inclusive).
    //•	year – accepts a positive number.
    //•	plate number – accepts char sequence (between 2 to 30 inclusive). The values are unique in the database.
    //•	kilometers – accepts a positive number.
    //•	engine – accepts number values that are more than or equal to 1.00.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarType carType;
    @Column(nullable = false)
    private String carMake;
    @Column(nullable = false)
    private String carModel;
    @Positive
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false, unique = true)
    private String plateNumber;

    @Positive
    @Column(nullable = false)
    private Integer kilometers;
    @Column(nullable = false)
    private Double engine;

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }
}
