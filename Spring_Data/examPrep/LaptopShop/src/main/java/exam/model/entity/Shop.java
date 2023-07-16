package exam.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{
    @Column(unique = true)
    private String name;
    @Column
    private BigDecimal income;
    @Column
    private String address;
    @Column
    private Integer employeeCount;
    @Column
    private Integer shopArea;
    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Integer getShopArea() {
        return shopArea;
    }

    public void setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
    }
}
