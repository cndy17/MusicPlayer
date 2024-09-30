public class AlbumMaker extends SongCollectionMaker {

    public SongCollection makeSongCollection() {
        return new Album();
    }

    public SongCollection makeSongCollection(String name) {
        return new Album(name);
    }

    public SongCollection makeSongCollection(String name, String artist) {
        return new Album(name, artist);
    }
}