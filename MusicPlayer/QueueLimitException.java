public class QueueLimitException extends Exception{
    public QueueLimitException() {

    }
    public QueueLimitException(String title) {

    }

    public String getMessage() {
        String message = "You can only have one queue.";
        return message;
    }
}
