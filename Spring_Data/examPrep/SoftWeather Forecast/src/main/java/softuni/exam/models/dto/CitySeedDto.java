package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CitySeedDto {

    @Expose
    private String cityName;

    @Expose
    private String description;

    @Expose
    private Integer population;

    @Expose
    private Long country;

    @Size(min = 2, max = 60)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Size(min = 2)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Min(500)
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long countryId) {
        this.country = countryId;
    }
}
