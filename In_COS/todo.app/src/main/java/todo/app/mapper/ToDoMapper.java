package todo.app.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;
import todo.app.dto.ToDoDto;
import todo.app.entity.ToDo;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ToDoMapper {
    ToDo toDoPostToToDo(ToDoDto.Post toDoPost);
    ToDo toDoPatchToToDo(ToDoDto.Patch toDotPatch);
    ToDoDto.Response toDoToToDoResponse(ToDo todo);

    ToDoDto.Response toDoToToDoResponseDto(ToDo todo);

    List<ToDoDto.Response> toDosToToDoResponseDtos(List<ToDo> todos);
}
