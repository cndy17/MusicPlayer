import java.util.Scanner;

public class DesignTest {
    public static void main(String[] args) throws Exception {

        // Create songs and albums
        System.out.println("Reading input from console using Scanner in Java ");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to upload (1) or listen to music? (2)?");
        String uploadOrListen = scanner.nextLine();
        System.out.println("Basic Music Player (1) or Premium Music Player (2)?");
        String userType = scanner.nextLine();
        System.out.println("User Input from console: " + userType);

        // If Upload:
        System.out.println("Are you adding a song(1) or an album(2) ?");
        String uploadMedia = scanner.nextLine();
    // Song
        Song song1 = new Song("Hotline Bling", "Drake", "Hotline Bing - Single", 267000);
        Song song2 = new Song("What Do You Mean?", "Justin Bieber", "What Do You Mean? - Single", 207000);
        Song song3 = new Song("Watch Me", "Silento", "Watch Me (Whip / Nae Nae) - Single", 185000);
        Song song4 = new Song("679", "Fetty Wap ft. Remy Boyz", "Fetty Wap", 185000);
        Song song5 = new Song("Can't Feel My Face", "The Weeknd", "Beauty Behind the Madness", 213000);
        Song song6 = new Song("Good for You", "Selena Gomez ft. A$AP Rocky", "Good for You - Single", 221000);
        Song song7 = new Song("If You", "Big Bang", "MADE", 264000);

        // Album
        SongCollectionMaker scm = new PlaylistMaker();
        SongCollection c = scm.makeSongCollection("Me");
        System.out.println("Playlist: " + c.getName());
        SongCollectionMaker scm2 = new AlbumMaker();
        SongCollection a = scm2.makeSongCollection("hi");
        System.out.println("Album: " + a.getName());

        SongCollection a1 = scm2.makeSongCollection("hi", "TS");
        System.out.println(a1);

        c.addSong(song1);
        c.addSong(song2);
        c.addSong(song3);
        c.addSong(song4);
        c.addSong(song5);
        c.addSong(song6);
        c.addSong(song7);

        System.out.println(c);

        // use iterator to traverse
        System.out.println("\nHere are the songs in our collection:");
        ListIterator<Song> iter = c.iterator();
        while (iter.hasNext())
        {
            Song b = iter.next();
            System.out.println(b.getTitle()+" by " +b.getArtist());
        }


        // iterator by artist
        String artist = "Selena Gomez";
        System.out.println("\nLet's see what songs we have by " + artist);
        while (iter.hasNextOfSameArtist(artist))
        {
            Song s = iter.next();
            System.out.print(s);
        }

        // get song at specified index
        System.out.println("\nWhat is the seventh song of the playlist:");
        System.out.println(c.getSong(6));

        // Playing Music
        System.out.println("\nLet's play some music.");

        // Singleton Queue Test
        Queue queue = null;

        try{
            queue = Queue.createQueue();
        }
        catch(QueueLimitException e){
            System.out.println(e.getMessage());
        }
        System.out.println(queue);
        // Shuffle Command Test
        queue.addSong(song1);
        queue.addSong(song2);
        queue.addSong(song3);
        queue.addSong(song4);
        queue.addSong(song5);
        queue.addSong(song6);
        queue.addSong(song7);

        System.out.println(queue);

        PlayerState state = new PausedState();
        MusicPlayer j = new MusicPlayer(state);
        System.out.println("The music player is playing music in");
        System.out.println("state: " + j.getState());
        System.out.println("isPlaying: " + j.getPlayMode());

// Basic User Facade
        BasicUserFacade basicUser = new BasicUserFacade();
        try {
            Command b1 = new PlayInOrderCommand(queue, state);
            basicUser.addToCommandList(b1);
            Invoker.invokeExecute();
        }
        catch (BasicUserException e) {
            System.out.println(e.getMessage());
        }

        try {
            //BasicUserFacade basicUser = new BasicUserFacade();
            basicUser.makeSongCollection();
            Command b2 = new ShuffleCommand(queue, state);
            basicUser.addToCommandList(b2);
            basicUser.invokeExecute();
        }
        catch (BasicUserException e) {
            System.out.println(e.getMessage());
        }

        // Premium User Facade
        // Premium User can play music in order
        PremiumUserFacade premUser = new PremiumUserFacade();
        System.out.println("Premium User");
        Command p1 = new PlayInOrderCommand(queue, state);
        premUser.addToCommandList(p1);
        // Premium user can shuffle music
        Command p2 = new ShuffleCommand(queue, state);
        premUser.addToCommandList(p2);
        premUser.invokeExecute();

    }

}


/*
// Test Code for Design Patterns
        // Song
        Song song1 = new Song("Hotline Bling", "Drake", "Hotline Bing - Single", 267000);
        Song song2 = new Song("What Do You Mean?", "Justin Bieber", "What Do You Mean? - Single", 207000);
        Song song3 = new Song("Watch Me", "Silento", "Watch Me (Whip / Nae Nae) - Single", 185000);
        Song song4 = new Song("679", "Fetty Wap ft. Remy Boyz", "Fetty Wap", 185000);
        Song song5 = new Song("Can't Feel My Face", "The Weeknd", "Beauty Behind the Madness", 213000);
        Song song6 = new Song("Good for You", "Selena Gomez ft. A$AP Rocky", "Good for You - Single", 221000);
        Song song7 = new Song("If You", "Big Bang", "MADE", 264000);

        // Album
        SongCollectionMaker scm1 = new PlaylistMaker();
        SongCollection c = scm1.makeSongCollection("Me");
        System.out.println("Playlist: " + c.getName());
        SongCollectionMaker scm2 = new AlbumMaker();
        SongCollection a = scm2.makeSongCollection("hi");
        System.out.println("Album: " + a.getName());
//while loop
        System.out.println("Add a song to the album(1) or Exit(2)");
        int option = scanner.nextInt();
        while (option == 1){
            System.out.println("Add a song to the album(1) or Finish(2)");
            option = scanner.nextInt();
        }


// Playlist
        SongCollection a1 = scm2.makeSongCollection("hi", "TS");
        System.out.println(a1);

        c.addSong(song1);
        c.addSong(song2);
        c.addSong(song3);
        c.addSong(song4);
        c.addSong(song5);
        c.addSong(song6);
        c.addSong(song7);

        System.out.println(c);

        // use iterator to traverse
        System.out.println("\nHere are the songs in your playlist " + c.getName()+ ": ");
        ListIterator<Song> iter = c.iterator();
        while (iter.hasNext())
        {
            Song b = iter.next();
            System.out.println(b.getTitle()+" by " +b.getArtist());
        }


        // iterator by artist
        String artist = "Selena Gomez";
        System.out.println("\nLet's see what songs we have by " + artist);
        while (iter.hasNextOfSameArtist(artist))
        {
            Song s = iter.next();
            System.out.print(s);
        }

        // get song at specified index
        System.out.println("\nWhat is the seventh song of the playlist:");
        System.out.println(c.getSong(6));

        // Playing Music
        System.out.println("\nLet's play some music.");

        // Singleton Queue Test
        Queue queue = null;

        try{
            queue = Queue.createQueue();
        }
        catch(QueueLimitException e){
            System.out.println(e.getMessage());
        }
        System.out.println(queue);
        // Shuffle Command Test
        queue.addSong(song1);
        queue.addSong(song2);
        queue.addSong(song3);
        queue.addSong(song4);
        queue.addSong(song5);
        queue.addSong(song6);
        queue.addSong(song7);

        System.out.println(queue);

        PlayerState state = new PausedState();
        MusicPlayer j = new MusicPlayer(state);
        System.out.println("The music player is playing music in");
        System.out.println("state: " + j.getState());
        System.out.println("isPlaying: " + j.getPlayMode());

// Basic User Facade
        BasicUserFacade basicUser = new BasicUserFacade();
        try {
            Command playQueue = new PlayInOrderCommand(queue, state);
            basicUser.addToCommandList(playQueue);
            Invoker.invokeExecute();
        }
        catch (BasicUserException e) {
            System.out.println(e.getMessage());
        }

        try {
            //BasicUserFacade basicUser = new BasicUserFacade();
            basicUser.makeSongCollection();
            Command shuffleQueue= new ShuffleCommand(queue, state);
            basicUser.addToCommandList(shuffleQueue);
            basicUser.invokeExecute();
        }
        catch (BasicUserException e) {
            System.out.println(e.getMessage());
        }

        // Premium User Facade
        // Premium User can play music in order
        PremiumUserFacade premUser = new PremiumUserFacade();
        System.out.println("Premium User");
        Command p1 = new PlayInOrderCommand(queue, state);
        premUser.addToCommandList(p1);
        // Premium user can shuffle music
        Command p2 = new ShuffleCommand(queue, state);
        premUser.addToCommandList(p2);
        premUser.invokeExecute();
    }
}*/