package exam.softuni.instagraphlite.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostSeedRootDto {

    @XmlElement(name = "post")
    List<PostSeedDto> posts;

    public List<PostSeedDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostSeedDto> posts) {
        this.posts = posts;
    }
}
