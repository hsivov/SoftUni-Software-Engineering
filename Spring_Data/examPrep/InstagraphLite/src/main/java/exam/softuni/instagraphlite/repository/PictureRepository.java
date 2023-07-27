package exam.softuni.instagraphlite.repository;

import exam.softuni.instagraphlite.models.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Optional<Picture> findFirstByPath(String path);

    List<Picture> findAllBySizeGreaterThanOrderBySize(Double size);
}
