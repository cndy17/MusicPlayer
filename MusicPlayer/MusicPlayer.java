// Context Class for State
public class MusicPlayer {
    private PlayerState state;
    public MusicPlayer(PlayerState s)
    {
        this.state = s;
    }
    public String getState()
    {
        return state.getState();
    }
    public boolean getPlayMode()
    {
        return state.getPlayMode();
    }
    public PlayerState changeState()
    {
        return state.changeState();
    }
}