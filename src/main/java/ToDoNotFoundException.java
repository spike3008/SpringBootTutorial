public class ToDoNotFoundException extends Exception {
    public ToDoNotFoundException(String id) {
        super(String.format("No todo entry found with id: <%s>", id));
    }
}
