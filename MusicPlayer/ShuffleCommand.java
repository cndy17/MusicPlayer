import java.util.Collections;
// make so it can only work with queue
public class ShuffleCommand implements Command{
    private SongCollection queue;
    private PlayerState playerState;
    public ShuffleCommand(SongCollection sc, PlayerState st){
        this.queue = sc;
        this.playerState = st;
    }
    public void execute(){
        Collections.shuffle(queue.getSongs());

        if (this.playerState instanceof PausedState){
            this.playerState = this.playerState.changeState();
            System.out.println("\nChanging state to playing."+ playerState.getPlayMode()+playerState.getState());
        }
        else {System.out.println("\nAlready playing.");}
        while (this.playerState.getPlayMode()) {
            System.out.println("\nShuffling it up!");
            ListIterator<Song> iter = queue.iterator();
            while (iter.hasNext()) {
                Song b = iter.next();
                System.out.println(b.getTitle() + " by " + b.getArtist());
            }
            this.playerState = this.playerState.changeState();
        }
    }
}
