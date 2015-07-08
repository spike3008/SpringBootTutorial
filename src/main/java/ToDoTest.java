import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ToDoTest {
    private String title = "Sample Title";
    private String description = "Desc asdasdasd asd";
    public ToDo toDo;

    @Test(expected = NullPointerException.class)
    public void testGetBuilderWithoutTitle() {
        toDo = ToDo.getBuilder().description(description).build();
    }

    @Test(expected = NullPointerException.class)
    public void testGetBuilderWithoutDescription() {
        toDo = ToDo.getBuilder().title(title).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBuilderWithEmptyTitle() {
        toDo = ToDo.getBuilder().description(description).title("").build();
    }

    @Test
    public void testGetDescription() {
        toDo = ToDo.getBuilder().description(description).title(title).build();
        assertThat(toDo.getDescription(), is(equalTo(description)));
    }

    @Test
    public void testGetTitle() {
        toDo = ToDo.getBuilder().description(description).title(title).build();
        assertThat(toDo.getTitle(), is(equalTo(title)));
    }

    @Test
    public void testUpdate() throws Exception {
        toDo = ToDo.getBuilder().description(description).title(title).build();
        String changedTitle = "Changed Title";
        String changedDescription = "Changed Description";
        toDo.update(changedTitle, changedDescription);
        assertThat(toDo.getDescription(), is(equalTo(changedDescription)));
        assertThat(toDo.getTitle(), is(equalTo(changedTitle)));
    }
}