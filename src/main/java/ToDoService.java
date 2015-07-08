import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

import java.util.List;

public interface ToDoService {

    ToDoDTO create(ToDoDTO toDo);

    ToDoDTO delete(String id);

    List<ToDoDTO> findAll();

    ToDoDTO findById(String id);

    ToDoDTO update(ToDoDTO toDo);
}
