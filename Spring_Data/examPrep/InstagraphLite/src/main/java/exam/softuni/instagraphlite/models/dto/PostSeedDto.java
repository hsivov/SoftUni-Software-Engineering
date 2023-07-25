package exam.softuni.instagraphlite.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostSeedDto {
    //    •	caption – a char sequence. Cannot be null. Must be at least 21 characters, inclusive.
    @XmlElement
    private String caption;

    @XmlElement
    private UserNameDto user;

    @XmlElement
    private PicturePathDto picture;

    @NotNull
    @Size(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UserNameDto getUser() {
        return user;
    }

    public void setUser(UserNameDto user) {
        this.user = user;
    }

    public PicturePathDto getPicture() {
        return picture;
    }

    public void setPicture(PicturePathDto picture) {
        this.picture = picture;
    }
}
