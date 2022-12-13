package todo.app.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import todo.app.dto.TodoDto;
import todo.app.entity.Todo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-13T23:11:59+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public Todo todoPostDtoToTodo(TodoDto.Post toDoPostDto) {
        if ( toDoPostDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTitle( toDoPostDto.getTitle() );
        todo.setTodoOrder( toDoPostDto.getTodoOrder() );

        return todo;
    }

    @Override
    public Todo todoPatchDtoToTodo(TodoDto.Patch toDotPatchDto) {
        if ( toDotPatchDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        if ( toDotPatchDto.getCompleted() != null ) {
            todo.setCompleted( toDotPatchDto.getCompleted() );
        }
        todo.setId( toDotPatchDto.getId() );
        todo.setTitle( toDotPatchDto.getTitle() );
        todo.setTodoOrder( toDotPatchDto.getTodoOrder() );

        return todo;
    }

    @Override
    public TodoDto.Response todoToTodoResponseDto(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        long id = 0L;
        String title = null;
        int todoOrder = 0;
        boolean completed = false;

        if ( todo.getId() != null ) {
            id = todo.getId();
        }
        title = todo.getTitle();
        todoOrder = todo.getTodoOrder();
        completed = todo.isCompleted();

        TodoDto.Response response = new TodoDto.Response( id, title, todoOrder, completed );

        return response;
    }

    @Override
    public List<TodoDto.Response> todosToTodoResponseDtos(List<Todo> todos) {
        if ( todos == null ) {
            return null;
        }

        List<TodoDto.Response> list = new ArrayList<TodoDto.Response>( todos.size() );
        for ( Todo todo : todos ) {
            list.add( todoToTodoResponseDto( todo ) );
        }

        return list;
    }
}
