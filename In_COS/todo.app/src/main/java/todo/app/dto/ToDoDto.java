package todo.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
public class ToDoDto {

    @Getter
    public static class Post {
        private String title;   // null이거나, 명확한 타이틀이거나,
        private Integer todoOrder;  // null이거나, 아니거나,
        private boolean completed;  // 어차피 처음은 false
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private long toDoId;
        private String title;
        private int todoOrder;
        private Boolean completed;

        public void setToDoId(long toDoId) {
            this.toDoId = toDoId;
        }
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public class Response {
        private int toDoId;
        private String title;
        private int todoOrder;
        private boolean completed;
    }
}