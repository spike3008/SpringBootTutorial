import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface ToDoRepository extends Repository<ToDo, String> {

    void delete(ToDo deleted);

    List<ToDo> findAll();

    Optional<ToDo> findOne(String id);

    ToDo save(ToDo saved);
}
