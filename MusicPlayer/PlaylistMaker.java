public class PlaylistMaker extends SongCollectionMaker {

    public SongCollection makeSongCollection() {
        return new Playlist();
    }

    public SongCollection makeSongCollection(String name) {
        return new Playlist(name);
    }

    // WHAT TO DO HERE?
    public SongCollection makeSongCollection(String name, String creator) {
        return null;
    }
}
