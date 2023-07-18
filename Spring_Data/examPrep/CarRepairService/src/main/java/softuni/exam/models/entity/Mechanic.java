package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mechanics")
public class Mechanic extends BaseEntity{
    //•	first name – accepts char sequences as values where their character length value higher than or equal to 2. The values are unique in the database.
    //•	last name – accepts char sequences as values where their character length value higher than or equal to 2.
    //•	email – an email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.
    //•	phone – accepts char sequences as values where their character length value higher than or equal to 2. Can be nullable. The values are unique in the database.

    @Column(unique = true, nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true)
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
