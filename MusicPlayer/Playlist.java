import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Playlist extends SongCollection{
    private List<Song> songs = new ArrayList<>();
    //private int songcount;
    private String name;
    private int totalLength;

    public Playlist() {
        super.setName("Untitled Playlist");
    }

    public Playlist(String n) {
        super.setName(n);
    }

    // List methods
    public void addSong(Song s)
    {super.addSong(s);}

    public Song getSong(int i) {return super.getSong(i);}

    public boolean removeSong(Song s)
    {return super.removeSong(s);}

    // setters
    public void setName(String n){
        super.setName(n);
    }

    // getters
    public String getName() {return super.getName();}
    public List<Song> getSongs(){
        return super.getSongs();
    }
    // rewrite
    public int getTotalLength() {
        return super.getTotalLength();
    }

    public boolean equals(Object o){
        if (o instanceof Playlist) {
            Playlist p = (Playlist) o;
            return this.name == p.name;
        }
        return false;}

    public int hashCode(){
        return name.hashCode()+ Integer.hashCode(totalLength);
    }
/*
    public int compareTo(Song b) {
        return title.compareTo(b.title);
    }
*/
public String toString() {
    return "Playlist: " + super.toString();
    }

    public ListIterator<Song>  iterator() {
        return super.iterator();
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

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Song previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {
            songs.remove(this);

        }

        @Override
        public void set(Song song) {

        }

        @Override
        public void add(Song song) {

        }

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


