public class PlayingState implements PlayerState{
    private boolean isPlaying = true;

    public String getState() {
        return "Music is Playing";
    }

    public boolean getPlayMode() {
        return isPlaying;
    }

    public PlayerState changeState() {
        return new PausedState();
    }
}
