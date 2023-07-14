package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.DayOfWeek;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    @Column(nullable = false)
    private Double maxTemperature;
    @Column(nullable = false)
    private Double minTemperature;
    @Column(nullable = false)
    private LocalTime sunrise;
    @Column(nullable = false)
    private LocalTime sunset;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalTime sunset) {
        this.sunset = sunset;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
