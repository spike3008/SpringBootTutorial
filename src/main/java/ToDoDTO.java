import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public final class ToDoDTO {

    private String id;

    @Size(max = ToDo.MAX_LENGTH_DESCRIPTION)
    private String description;

    @NotEmpty
    @Size(max = ToDo.MAX_LENGTH_TITLE)
    private String title;

    public ToDoDTO() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}