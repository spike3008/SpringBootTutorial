import org.springframework.data.annotation.Id;

import static utils.PreCondition.isTrue;
import static utils.PreCondition.notEmpty;
import static utils.PreCondition.notNull;

final class ToDo {

    static final int MAX_LENGTH_DESCRIPTION = 500;
    static final int MAX_LENGTH_TITLE = 100;

    @Id
    private String id;

    private String description;

    private String title;

    public ToDo() {
    }

    private ToDo(Builder builder) {
        this.description = builder.description;
        this.title = builder.title;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    //Other getters are omitted

    public void update(String title, String description) {
        checkTitleAndDescription(title, description);

        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    /**
     * We don't have to use the builder pattern here because the constructed
     * class has only two String fields. However, I use the builder pattern
     * in this example because it makes the code a bit easier to read.
     */
    static class Builder {

        private String description;

        private String title;

        private Builder() {
        }

        Builder description(String description) {
            this.description = description;
            return this;
        }

        Builder title(String title) {
            this.title = title;
            return this;
        }

        ToDo build() {
            ToDo build = new ToDo(this);

            build.checkTitleAndDescription(build.getTitle(), build.getDescription());

            return build;
        }
    }

    private void checkTitleAndDescription(String title, String description) {
        notNull(title, "Title cannot be null");
        notEmpty(title, "Title cannot be empty");
        isTrue(title.length() <= MAX_LENGTH_TITLE,
                "Title cannot be longer than %d characters",
                MAX_LENGTH_TITLE
        );
        if (description != null) {
            isTrue(description.length() <= MAX_LENGTH_DESCRIPTION,
                    "Description cannot be longer than %d characters",
                    MAX_LENGTH_DESCRIPTION
            );
        } else {
            throw new NullPointerException("Description cannot be null");
        }
    }
}