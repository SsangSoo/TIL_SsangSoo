package todo.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoId;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private int todoOrder;

    @Column(nullable = false)
    private boolean completed = false;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 30, nullable = false)
    private ToDoStatus toDoStatus = ToDoStatus.TODO_ACTIVE;

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ToDo(String Title) {
        this.title = title;
    }

    public ToDo(String title, int todoOrder) {
        this.title = title;
        this.todoOrder = todoOrder;
    }

    public enum ToDoStatus {
        TODO_EXISTS("등록됨"),
        TODO_ACTIVE("진행 중");

        @Getter
        private String status;

        ToDoStatus(String status) {
            this.status = status;
        }
    }
}
