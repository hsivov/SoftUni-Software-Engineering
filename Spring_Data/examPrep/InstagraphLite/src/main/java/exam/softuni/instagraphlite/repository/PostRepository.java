package exam.softuni.instagraphlite.repository;

import exam.softuni.instagraphlite.models.entity.Post;
import exam.softuni.instagraphlite.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> getPostByUserOrderByPicture_Size(User user);
}
