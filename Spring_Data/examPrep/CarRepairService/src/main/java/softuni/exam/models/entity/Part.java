package softuni.exam.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String partName;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Integer quantity;

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
