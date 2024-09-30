public class Song {
    private String title;
    private String artist;
    private String album;
    private int length;
    private Genre genre;
        // length inprivate Genre genre;

    public Song(String t, String a, String al) {
        title = t;
        artist = a;
        album = al;
    }
    public Song(String t, String a, String al,int l) {
        title = t;
        artist = a;
        album = al;
        length = l;
    }
        // try a builder here for optional params
    public Song(String t, String a, int l) {
        title = t;
        artist = a;
        length = l;
}
    public Song(String t, String a, Genre g) {
        title = t;
        artist = a;
        genre = g;
    }
    public Song(String t, String a, int l, Genre g) {
        title = t;
        artist = a;
        length = l;
        genre = g;
    }
    public Song(String t, String a, String al, int l, Genre g) {
        title = t;
        artist = a;
        album =al;
        length = l;
        genre = g;
    }

    public Song() {

    }

    // setters
    public void setTitle(String t){
        this.title = t;
    }
    public void setArtist(String a){
            this.artist = a;
        }

    public  void setLength(int l){
        this.length = l;
        }
    public  void setGenre(Genre g){
        this.genre = g;
        }

        // getter
    public String getTitle() {return title;}
    public String getArtist() {return artist;}
    public int getLength() {return length;}
    public Genre getGenre() {return genre;}


    public boolean equals(Object o){
        if (o instanceof Song) {
            Song s = (Song) o;
            return this.title == s.title;
        }
        return false;}

    public int hashCode(){
        return title.hashCode()+ artist.hashCode() + Integer.hashCode(length);
    }

    public int compareTo(Song b) {
        return title.compareTo(b.title);
    }

    public String toString() {
        if (this.length == 0 && this.genre == null) {
            return "Song Title:\t" + title + "\tby " + artist + "\n\tAlbum:\t" + album;
        }
        else if (this.length == 0 && this.genre != null) {
            return "Song Title:\t" + title + "\tby " + artist + "\n\tAlbum:\t" + album+"\n"+"\nGenre:\t" + genre;
        }
        else if (this.length != 0 && this.genre == null) {
            return "Song Title:\t" + title + "\tby " + artist + "\n\tAlbum:\t" + album+"\n"+ length+"min";
        }
        return "Song Title:\t" + title + " \tby " + artist + "\n\tAlbum:\t" + album + length+" min" + "\nGenre:\t" + genre;
    }
}
