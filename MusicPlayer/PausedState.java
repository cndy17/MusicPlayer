public class PausedState implements PlayerState{

    private boolean isPlaying = false;
    public String getState() {
        return "Music is Paused";
    }

    public boolean getPlayMode() {
        return isPlaying;
    }

    public PlayerState changeState() {
        return new PlayingState();
    }
}
