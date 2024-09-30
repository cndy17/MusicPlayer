public abstract class Facade {

    public abstract void addToCommandList(Command p1) throws BasicUserException;

    public abstract void invokeExecute();

    public abstract SongCollection makeSongCollection();

    public abstract boolean removeSong(SongCollection sc, Song s) throws BasicUserException;
}
