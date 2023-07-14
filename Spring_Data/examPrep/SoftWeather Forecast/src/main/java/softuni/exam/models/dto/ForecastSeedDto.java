package softuni.exam.models.dto;

import softuni.exam.models.entity.enums.DayOfWeek;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSeedDto {
    @XmlElement(name = "min_temperature")
    private Double minTemperature;
    @XmlElement(name = "max_temperature")
    private Double maxTemperature;
    @XmlElement(name = "day_of_week")
    private DayOfWeek dayOfWeek;
    @XmlElement(name = "city")
    private Long city;
    @XmlElement(name = "sunrise")
    private String sunrise;
    @XmlElement(name = "sunset")
    private String sunset;


    @DecimalMin(value = "-50")
    @DecimalMax(value = "40")
    @NotNull
    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    @DecimalMin(value = "-20")
    @DecimalMax(value = "60")
    @NotNull
    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @NotNull
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    @NotNull
    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @NotNull
    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
}
