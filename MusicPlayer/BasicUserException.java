public class BasicUserException extends Exception {
    public BasicUserException() {

    }
    public BasicUserException(String title) {

    }

    public String getMessage() {
        String message = "Upgrade to Premium for this feature. Basic users can only listen to music on shuffle and can't skip songs.";
        return message;
    }
}
