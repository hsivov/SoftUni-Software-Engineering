package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;

import java.util.Optional;
import java.util.Set;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    Optional<Star> findFirstByName(String starName);

    Optional<Star> findById(Long starId);

    @Query(value = "SELECT * FROM stars s " +
            "LEFT JOIN astronomers a ON s.id = a.observing_star_id " +
            "WHERE s.star_type = 'RED_GIANT' AND a.id IS NULL " +
            "ORDER BY s.light_years ", nativeQuery = true)
    Set<Star> findAllByStarTypeAndAstronomerNull();
}
