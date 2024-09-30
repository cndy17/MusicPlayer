public class PremiumUserFacade extends Facade{
    private Queue queue;
    private ShuffleCommand shuffle;
    private PlayInOrderCommand playinorder;
    private Invoker invoker;
    private Playlist playlist;
    private PlaylistMaker playlistMaker;
    private PlayerState state;

    public PremiumUserFacade() {
        queue = new Queue();
        playlist = new Playlist();
        shuffle = new ShuffleCommand(queue, state);
        playlistMaker = new PlaylistMaker();
    }

    // Premium User can add songs to queue, remove songs from queue
    public void addSong(Song s) {
        queue.addSong(s);
    }

    public boolean removeSong(SongCollection sc, Song s) {
        return sc.removeSong(s);
    }
    public void addCollection(SongCollection sc) {
        queue.addCollection(sc);
    }

    // can make playlists
    public SongCollection makeSongCollection() {
        return playlistMaker.makeSongCollection();
    }

    public SongCollection makeSongCollection(String name) {
        return playlistMaker.makeSongCollection(name);
    }

    // Premium user can use all the commands: playinorder, shuffle
    public void addToCommandList(Command c ) {
        invoker.addToCommandList( c );
    }
    public void invokeExecute(){
        invoker.invokeExecute();
    }

}
