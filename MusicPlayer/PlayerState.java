public interface PlayerState {
    String getState();
    boolean getPlayMode();
    PlayerState changeState();
}
