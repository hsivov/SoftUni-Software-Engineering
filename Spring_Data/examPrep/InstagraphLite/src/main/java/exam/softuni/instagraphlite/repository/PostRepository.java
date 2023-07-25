package exam.softuni.instagraphlite.repository;

import exam.softuni.instagraphlite.models.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
