import java.util.NoSuchElementException;

public interface ListIterator<T> {
    boolean hasNext();
    T next();
    boolean hasPrevious();
    Song previous();
    int nextIndex();

    int previousIndex();

    void remove();

    void set(Song song);

    void add(Song song);
    boolean hasNextOfSameArtist(String a);
    T nextOfSameArtist(String a);

}
