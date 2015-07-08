import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
final class MongoToDoService implements ToDoService {
    private final ToDoRepository repository;

    @Autowired
    public MongoToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ToDoDTO create(ToDoDTO toDo) {
        ToDo persisted = ToDo.getBuilder()
                .title(toDo.getTitle())
                .description(toDo.getDescription())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public ToDoDTO delete(String id) {
        ToDo deleted = findTodoById(id).get();
        repository.delete(deleted);
        return convertToDTO(deleted);

    }

    @Override
    public List<ToDoDTO> findAll() {
        List<ToDo> toDos = repository.findAll();
        return convertToDTOs(toDos);
    }

    @Override
    public ToDoDTO findById(String id) {
        Optional<ToDo> found = repository.findOne(id);
        return convertToDTO(found.get());
    }

    @Override
    public ToDoDTO update(ToDoDTO toDo) {
        ToDo updated = findTodoById(toDo.getId()).get();
        updated.update(toDo.getTitle(), toDo.getDescription());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    private Optional<ToDo> findTodoById(String id) {
        return repository.findOne(id);

    }

    private ToDoDTO convertToDTO(ToDo model) {
        ToDoDTO dto = new ToDoDTO();

        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setDescription(model.getDescription());

        return dto;
    }

    private List<ToDoDTO> convertToDTOs(List<ToDo> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }
}
