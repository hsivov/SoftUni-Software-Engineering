package exam.softuni.instagraphlite.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class PictureSeedDto {
    //•	size – a floating point number. Cannot be null. Must be between 500 and 60000 (both numbers are INCLUSIVE)
    @Expose
    @NotNull
    private String path;
    @Expose
    @NotNull
    private Double size;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @DecimalMin("500")
    @DecimalMax("60000")
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
