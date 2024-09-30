public class PlayByArtistCommand {
    private SongCollection queue;
    private String artist;
    public PlayByArtistCommand(SongCollection sc, String a){
        this.queue = sc;
        this.artist = a;;
    }

    public void execute(){

        System.out.println("\nHere are the songs in our collection:");
        ListIterator<Song> iter = queue.iterator();
        while (iter.hasNextOfSameArtist(artist))
        {
            Song b = iter.nextOfSameArtist(artist);
            System.out.println(b.getTitle()+" by " +b.getArtist());
        }
    }
}
