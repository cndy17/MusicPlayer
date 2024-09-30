import javax.swing.plaf.basic.BasicColorChooserUI;

public class BasicUserFacade extends Facade {
    private Queue queue;
    private ShuffleCommand shuffle;
    private Playlist playlist;
    private PlaylistMaker playlistMaker;
    private Invoker invoker;
    private PlayerState state;
    public BasicUserFacade() {
        queue = new Queue();
        playlist = new Playlist();
        shuffle = new ShuffleCommand(queue, state);
        playlistMaker = new PlaylistMaker();
        invoker = new Invoker();
    }

    // Basic User can add songs to queue, but can't skipsongs (remove from queue)
    public void addSong(Song s) {
        queue.addSong(s);
    }

    public boolean removeSong(SongCollection sc, Song s) throws BasicUserException{
         throw new BasicUserException();
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

    // basic user can shuffle music
    public void execute() {
        shuffle.execute();
    }

    public void addToCommandList( Command c ) throws BasicUserException {
        if (c instanceof PlayInOrderCommand){
            throw new BasicUserException();
        }
        else{invoker.addToCommandList(c);}
    }
    public void invokeExecute(){
        invoker.invokeExecute();
    }


}
