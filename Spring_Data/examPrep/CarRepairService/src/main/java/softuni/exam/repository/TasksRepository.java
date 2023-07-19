package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.CarType;
import softuni.exam.models.entity.Task;

import java.util.Set;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {

    Set<Task> findAllByCarCarTypeOrderByPriceDesc(CarType carType);
}
