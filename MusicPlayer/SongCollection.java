import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SongCollection{
    private List<Song> songs = new ArrayList<>();
    private String name;
    private int totalLength;

    public SongCollection() {

    }

    public SongCollection(String n) {

    }

    public SongCollection(String n, String a) {

    }

    // List methods
    public void addSong(Song s) {
        songs.add(s);
    }

    public Song getSong(int i) {
        return songs.get(i);
    }

    public boolean removeSong(Song s) {
        return songs.remove(s);
    }

    public List<Song> getSongs(){
        return songs;
    }

    // setters
    public void setName(String n) {
        this.name = n;
    }

    // getters
    public String getName() {
        return name;
    }

    // rewrite
    public int getTotalLength() {
        for (int i = 0; i < songs.size(); i++) {
            this.totalLength += songs.get(i).getLength();
        }
        return this.totalLength;
    }

    public boolean equals(Object o) {
        if (o instanceof SongCollection) {
            SongCollection p = (SongCollection) o;
            return this.name == p.name && this.totalLength == p.totalLength;
        }
        return false;
    }

    public int hashCode() {
        return name.hashCode() + Integer.hashCode(totalLength);
    }

    /*
        public int compareTo(Song b) {
            return title.compareTo(b.title);
        }
    */
    public String toString() {
        return  getName() + " Songs: " + songs.size();
    }

    public ListIterator<Song> iterator() {
        return new SongIterator();
    }


    // Iterator
    private class SongIterator implements ListIterator<Song> {
        private static int count;
        public SongIterator() {
            count = 0;
        }

        public boolean hasNext() {
            return count < songs.size();
        }

        public Song next() {
            if (hasNext()) {
                return songs.get(count++);
            } else {
                throw new NoSuchElementException("That was the last song!");
            }
        }

        public boolean hasPrevious() {
            return count > 0;
        }
        public Song previous() {
            if (hasPrevious()){
                return songs.get(count--);
            }
            else {
            throw new NoSuchElementException("That was the first song!");}
        }

        public int nextIndex() {
            return count + 1;
        }

        public int previousIndex() {
            return count - 1;
        }

        public void remove() {
            songs.remove(this);
        }

        public void set(Song song) {

        }

        public void add(Song song) {

        }
            // Iterate by Artist
        public boolean hasNextOfSameArtist(String a) {
            boolean b = false;
            // increase count until the hasnext is true
            // iterate through songs and
            // return true if next song after has the same color
            while (b == false) {
                int i = count;
                if (i < (songs.size()-1)) {
                    b = songs.get(++i).getArtist().contains(a);
                }
                else {return b;}
            }
            return b;
        }

        public Song nextOfSameArtist(String a) {
            if (hasNextOfSameArtist(a)) {
                return songs.get(count++);
            } else {
                throw new NoSuchElementException("No other songs by " + a + " in here.");
            }
        }

    }
}