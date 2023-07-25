package exam.softuni.instagraphlite.repository;

import exam.softuni.instagraphlite.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    •	Export all users with their posts ordered by count of posts descending, then by user id
//      •	Order the posts, inside each user, by the post's picture size in ascending order

    Optional<User> findFirstByUsername(String username);

    @Query("SELECT COUNT(u) FROM User u " +
            "JOIN Post p")
    Set<User> allUsersWithTheirPostsOrderedByCountOfPostsDesc();
}
