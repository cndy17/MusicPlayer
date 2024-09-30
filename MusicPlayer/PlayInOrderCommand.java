public class PlayInOrderCommand implements Command{
    private SongCollection queue;
    private PlayerState playerState;
    public PlayInOrderCommand(SongCollection sc, PlayerState ps){
        this.queue = sc;
        this.playerState = ps;
    }

    public void execute(){
        if (this.playerState instanceof PausedState){
            this.playerState = this.playerState.changeState();
            System.out.println("\nChanging state to playing."+playerState.getPlayMode()+playerState.getState());
        }
        else {System.out.println("\nAlready playing.");}
        while (this.playerState.getPlayMode()) {
            System.out.println("\nNow playing the songs in order:");
            ListIterator<Song> iter = queue.iterator();
            while (iter.hasNext()) {
                Song b = iter.next();
                System.out.println(b.getTitle() + " by " + b.getArtist());
            }
            this.playerState = this.playerState.changeState();
        }
    }


}
