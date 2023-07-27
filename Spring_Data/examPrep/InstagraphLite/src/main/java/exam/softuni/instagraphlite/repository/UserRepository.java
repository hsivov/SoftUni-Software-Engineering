package exam.softuni.instagraphlite.repository;

import exam.softuni.instagraphlite.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    •	Export all users with their posts ordered by count of posts descending, then by user id
//      •	Order the posts, inside each user, by the post's picture size in ascending order

    Optional<User> findFirstByUsername(String username);

    @Query(value = "SELECT u from User u " +
            "ORDER BY (SELECT COUNT(*) FROM Post p WHERE p.user.id = u.id) DESC ")
    List<User> allUsersWithTheirPostsOrderedByCountOfPostsDesc();
}
