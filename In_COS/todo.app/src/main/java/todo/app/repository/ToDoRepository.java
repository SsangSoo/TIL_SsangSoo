package todo.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import todo.app.entity.ToDo;

import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    Optional<ToDo> findByTitle(String title);
    }
