package todo.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import todo.app.entity.ToDo;
import todo.app.exception.BusinessLogicException;
import todo.app.exception.ExceptionCode;
import todo.app.repository.ToDoRepository;
import todo.app.utils.CustomBeanUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final CustomBeanUtils<ToDo> customBeanUtils;

    public ToDoService(ToDoRepository toDoRepository,
                       CustomBeanUtils<ToDo> customBeanUtls) {
        this.toDoRepository = toDoRepository;
        this.customBeanUtils = customBeanUtls;
    }

    // 생성
    public ToDo createToDo(ToDo toDo) {

        return toDoRepository.save(toDo);
    }

    // get 한개
    public ToDo findByToDo(long toDoId) {
        return findVerifiedTodo(toDoId);
    }

    // get전체
    public Page<ToDo> findAllToDo(int page, int size) {
        return toDoRepository.findAll(PageRequest.of(page, size,
                Sort.by("memberId").descending()));

    }

    // patch
    public ToDo updateByToDo(ToDo todo) {
        ToDo findToDo = findVerifiedTodo(todo.getToDoId());

        ToDo updatedToDo = customBeanUtils.copyNonNullProperties(todo, findToDo);

        return updatedToDo;
    }

    // delete 전체
    public void deleteAllToDo() {
        List<ToDo> findToDos = toDoRepository.findAll()
                .stream()
                .filter(toDo -> toDo.isCompleted()==true)
                .collect(Collectors.toList());

        toDoRepository.deleteAll(findToDos);

    }

    // delete 한개
   public void deleteToDo(long toDoId) {
        ToDo findToDo = findVerifiedTodo(toDoId);

        toDoRepository.delete(findToDo);
   }


    // 존재하는 Todo인지 확인, Id를 기준으로 찾음.
    public ToDo findVerifiedTodo(long toDoId) {
        Optional<ToDo> optionalToDo =
                toDoRepository.findById(toDoId);
        ToDo findToDo =
                optionalToDo.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));
        return findToDo;
    }

    // title이 존재하면 존재하는 예외 던짐.
    private void verifyExistsTitle(String title) {
        Optional<ToDo> todo = toDoRepository.findByTitle(title);
        if(todo.isPresent())
            throw new BusinessLogicException(ExceptionCode.TODO_EXISTS);
    }
}
