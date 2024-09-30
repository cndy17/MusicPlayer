import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Album extends SongCollection{
        private List<Song> songs = new ArrayList<>();
        private String name;
        private String artist;
        private int totalLength;
        private Genre genre;

        public Album() {
            super();
            songs = new ArrayList<>();
        }

        public Album(String n, String a) {
            songs = new ArrayList<>();
            super.setName(n);
            this.artist = a;
        }

    public Album(String n) {
        songs = new ArrayList<>();
        super.setName(n);
    }

    // List methods
        public void addSong(Song s) {super.addSong(s);}

        public Song getSong(int i) {return songs.get(i);}

        public boolean removeSong(Song s)
        {return songs.remove(s);}

        // setters
        public void setName(String n){
            super.setName(n);
        }
        public void setArtist(String c){
            this.artist = c;
        }
        public  void setGenre(Genre g){
            this.genre = g;
        }

        // getters
        public String getName() {return super.getName();}
        public String getArtist() {return artist;}
        public Genre getGenre() {return genre;}

        public int getTotalLength() {
            return super.getTotalLength();
        }

    public List<Song> getSongs(){
        return super.getSongs();
    }

        public boolean equals(Object o){
            if (o instanceof Album) {
                Album p = (Album) o;
                return this.name == p.name && this.artist == p.artist;
            }
            return false;}

        public int hashCode(){
            return name.hashCode()+ artist.hashCode() + Integer.hashCode(totalLength);
        }
        /*
            public int compareTo(Song b) {
                return title.compareTo(b.title);
            }
        */
        public String toString() {
            return "Album: " + super.getName() + " by: " + this.getArtist();
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
