package todo.app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import todo.app.dto.ToDoDto;
import todo.app.entity.ToDo;
import todo.app.mapper.ToDoMapper;
import todo.app.repository.ToDoRepository;
import todo.app.response.MultiResponseDto;
import todo.app.response.SingleResponseDto;
import todo.app.service.ToDoService;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;



@RestController
@RequestMapping("/todos")
@Validated
@Slf4j
public class ToDoController {
    private final ToDoRepository toDoRepository;
    private final ToDoService toDoService;
    private final ToDoMapper toDoMapper;

    public ToDoController(ToDoService toDoService,
                          ToDoMapper toDoMapper,
                          ToDoRepository toDoRepository) {
        this.toDoService = toDoService;
        this.toDoMapper = toDoMapper;
        this.toDoRepository = toDoRepository;
    }


    @PostMapping
    public ResponseEntity postToDo(@Valid @RequestBody ToDoDto.Post requestBody) {
        ToDo toDo = toDoMapper.toDoPostToToDo(requestBody);

        ToDo createdTodo = toDoService.createToDo(toDo);

        return new ResponseEntity<>(new SingleResponseDto<>(toDoMapper.toDoToToDoResponseDto(createdTodo)) ,HttpStatus.CREATED);
    }


    @PatchMapping("/{id}")
    public ResponseEntity patchToDo(
            @PathVariable("id") @Positive long toDoId,
            @Valid @RequestBody ToDoDto.Patch requestBody) {
        requestBody.setToDoId(toDoId);

        ToDo todo =
                toDoService.updateByToDo(toDoMapper.toDoPatchToToDo(requestBody));

        return new ResponseEntity<>(
                new SingleResponseDto<>(toDoMapper.toDoToToDoResponseDto(todo)),
                HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getTodos(@Positive @RequestParam int page,
                                   @Positive @RequestParam int size) {
        Page<ToDo> pageTodos = toDoService.findAllToDo(page - 1, size);
        List<ToDo> todos = pageTodos.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(toDoMapper.toDosToToDoResponseDtos(todos),
                        pageTodos),
                HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity getTodo(
            @PathVariable("id") @Positive long toDoId) {
        ToDo todo = toDoService.findByToDo(toDoId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(toDoMapper.toDoToToDoResponseDto(todo))
                , HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity deleteToDo() {

        toDoService.deleteAllToDo();

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteToDo(
            @RequestBody @PathVariable("{id}") long toDoId) {
        toDoService.deleteToDo(toDoId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
