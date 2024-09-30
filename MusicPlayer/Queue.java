import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Queue extends SongCollection {
    protected List<Song> songs = new ArrayList<>();
    // Singleton: only one queue
    protected static Queue queue;
    private String name;

    protected Queue(){
        super.setName("queue");
    }
    // singleton
public static Queue createQueue() throws QueueLimitException{
        if (queue== null) {
            queue = new Queue();
            return queue;
        }
        throw new QueueLimitException();
    }

    public void addSong(Song s) {
        super.addSong(s);
    }

    public void addCollection(SongCollection sc) {
        ListIterator<Song> iter = sc.iterator();
        while (iter.hasNext()) {
            Song b = iter.next();
            super.addSong(b);
        }
    }

    public Song getSong(int i) {
        return super.getSong(i);
    }

    public boolean removeSong(Song s) {
        return super.removeSong(s);
    }


    // setters
    public void setName(String n) {
        super.setName(n);
    }

    // getters
    public String getName() {
        return "queue";
    }

    public List<Song> getSongs() {
        return super.getSongs();
    }

    // rewrite
    public int getTotalLength() {
        return super.getTotalLength();
    }

    public boolean equals(Object o) {
        if (o instanceof Queue) {
            Queue p = (Queue) o;
            return this.name == p.name;
        }
        return false;
    }

    public int hashCode() {
        return name.hashCode();
    }

    /*
        public int compareTo(Song b) {
            return title.compareTo(b.title);
        }
    */
    public String toString() {
        return "There are " + super.getSongs().size() + " songs in the " + getName();
    }

    public ListIterator<Song> iterator() {
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
            return 0;
        }

        public int previousIndex() {
            return 0;
        }


        public void remove() {
            songs.remove(this);
        }


        public void set(Song song) {

        }

        public void add(Song song) {

        }
        public boolean hasNextOfSameArtist(String a) {
            return false;
        }
        public Song nextOfSameArtist(String a) {
            return null;
        }
    }
}
