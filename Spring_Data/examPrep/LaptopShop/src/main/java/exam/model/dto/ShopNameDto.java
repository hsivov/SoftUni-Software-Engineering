package exam.model.dto;

import com.google.gson.annotations.Expose;

public class ShopNameDto {
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
