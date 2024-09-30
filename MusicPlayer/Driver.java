import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) throws Exception {
        // User
        Facade userFacade = new BasicUserFacade();

        // Singleton Queue
        Queue queue = null;
        try {
            queue = Queue.createQueue();
        } catch (QueueLimitException e) {
            System.out.println(e.getMessage());
        }

        // Create songs and albums
        System.out.println("Welcome to the Music Player!");
        Scanner scanner = new Scanner(System.in);
        SongCollectionMaker scm = new PlaylistMaker();

        // Store Complete Music Library
        SongCollection allSongs = scm.makeSongCollection("All Songs");
        List<SongCollection> allAlbums = new ArrayList<>();
        List<SongCollection> allPlaylists = new ArrayList<>();

        // Pre-add songs and albums and a playlist that come with the music player
        // so that we can test the program without adding new content each time
        // Songs
        Song song1 = new Song("Rockin' Around the Christmas Tree", "Brenda Lee", "Merry Christmas From Brenda Lee", 2);
        Song song2 = new Song("Let It Snow!", "Nat King Cole", "The Christmas Song", 1);
        Song song3 = new Song("A Holly Jolly Christmas", "Burl Ives", "Have A Holly Jolly Christmas", 2);
        Song song4 = new Song("White Christmas", "Bing Crosby, Ken Darby Singers, John Scott Trotter & His Orchestra", "White Christmas", 3);
        Song song5 = new Song("Feliz Navidad", "Jose Feliciano", "Feliz Navidad", 3);
        Song song6 = new Song("Jingle Bells", "Frank Sinatra", "A Jolly Christmas From Frank Sinatra", 2);
        Song song7 = new Song("Deck The Halls", "Nat King Cole", "The Christmas Song", 1);
        Song track1 = new Song("Santa Claus Is Back In Town", "Elvis Presley", "Elvis' Christmas Album", 2);
        Song track2 = new Song("White Christmas", "Elvis Presley", "Elvis' Christmas Album", 2);
        Song track3 = new Song("Here Comes Santa Clause", "Elvis Presley", "Elvis' Christmas Album", 2);
        Song track4 = new Song("I'll Be Home for Christmas", "Elvis Presley", "Elvis' Christmas Album",2);
        Song track5 = new Song("Blue Christmas","Elvis Presley", "Elvis' Christmas Album", 2);
        Song track6 = new Song("Santa Bring My Baby Back", "Elvis Presley", "Elvis' Christmas Album",2);
        Song track7 = new Song("O Little Town of Bethlehem", "Elvis Presley", "Elvis' Christmas Album", 3);
        Song track8 = new Song("Silent Night", "Elvis Presley", "Elvis' Christmas Album", 3);
        Song track9 = new Song("Peace In the Valley", "Elvis Presley", "Elvis' Christmas Album", 2);
        Song track10 = new Song("I Believe", "Elvis Presley", "Elvis' Christmas Album", 3);
        Song track11 = new Song("Take My Hand, Precious Lord", "Elvis Presley", "Elvis' Christmas Album", 3);
        Song track12 = new Song("It Is No Secret", "Elvis Presley", "Elvis' Christmas Album", 3);
        allSongs.addSong(song1);
        allSongs.addSong(song2);
        allSongs.addSong(song3);
        allSongs.addSong(song4);
        allSongs.addSong(song5);
        allSongs.addSong(song6);
        allSongs.addSong(song7);
        allSongs.addSong(track1);
        allSongs.addSong(track2);
        allSongs.addSong(track3);
        allSongs.addSong(track4);
        allSongs.addSong(track5);
        allSongs.addSong(track6);
        allSongs.addSong(track7);
        allSongs.addSong(track8);
        allSongs.addSong(track9);
        allSongs.addSong(track10);
        allSongs.addSong(track11);
        allSongs.addSong(track12);

        // Album
        SongCollectionMaker amaker = new AlbumMaker();
        SongCollection testalbum1 = amaker.makeSongCollection("Built In Album1");
        SongCollection testalbum2 = amaker.makeSongCollection("Built In Album - Single");
        allAlbums.add(testalbum1);
        allAlbums.add(testalbum2);
        testalbum1.addSong(track1);
        testalbum1.addSong(track2);
        testalbum1.addSong(track3);
        testalbum1.addSong(track4);
        testalbum1.addSong(track5);
        testalbum1.addSong(track6);
        testalbum2.addSong(track7);
        testalbum2.addSong(track8);
        testalbum2.addSong(track9);
        testalbum2.addSong(track10);
        testalbum2.addSong(track11);
        testalbum2.addSong(track12);

        // Playlist
        SongCollectionMaker pmaker = new PlaylistMaker();
        SongCollection testplaylist = pmaker.makeSongCollection("Built In Playlist");
        allPlaylists.add(testplaylist);
        testplaylist.addSong(song1);
        testplaylist.addSong(song2);
        testplaylist.addSong(song3);
        testplaylist.addSong(song4);
        testplaylist.addSong(song5);
        testplaylist.addSong(song6);
        testplaylist.addSong(song7);

// INTERACTIVE PORTION
        PlayerState state = new PausedState();
        MusicPlayer j = new MusicPlayer(state);
        System.out.println(j.getState());

        System.out.println("Select your plan to get started. Enter 1 or 2: \n");
        System.out.println("1. Premium: \n - Listen to music in order\n - Listen to music on shuffle\n - Skip songs in the queue");
        System.out.println("2. Basic: \n - Listen to music on shuffle\n - No skipping songs");
        int userType = scanner.nextInt();

        // if premium user
        if (userType == 1) {
            userFacade = new PremiumUserFacade();
        }
        // if basic user
        else if (userType == 2) {
            userFacade = new BasicUserFacade();
        }

        // First Menu: Release music or Listen
        System.out.println("1. Release music. 2. Listen to music." + "\n Enter 1 or 2:");
        int uploadOrListen = scanner.nextInt();
        //1. Release Music (Artist):
        while (uploadOrListen == 1) {
            // Release Music Menu
            System.out.println("""
                    What would you like to do? Enter a number:
                    1. Create new song.
                    2. Create new album.
                    3. Add song to existing album.
                    4. Exit back to menu.""");

            int upload = scanner.nextInt();
            // while not 4. Exit
            while (upload != 4) {
                // 1: Create New Song
                if (upload == 1) {
                    System.out.println("Song Name: ");
                    scanner.nextLine();
                    String songTitle = scanner.nextLine();
                    System.out.println("Artist/s: ");
                    String songArtist = scanner.nextLine();
                    System.out.println("Album Name: ");
                    String songAlbum = scanner.nextLine();
                    System.out.println("Length in minutes: ");
                    int songLength = scanner.nextInt();
                    Song songA = new Song(songTitle, songArtist, songAlbum, songLength);
                    allSongs.addSong(songA); // add song to master list
                    System.out.println("Here is your song: " + songA);
                    System.out.println("""
                            1. Create new song.
                            2. Create new album.
                            3. Add song to existing album.
                            4. Exit back to menu.""");
                    upload = scanner.nextInt();
                }
                // 2: Create new album
                else if (upload == 2) {
                    SongCollectionMaker scmA = new AlbumMaker();
                    System.out.println("Album Name: ");
                    scanner.nextLine();
                    String albumName = scanner.nextLine();
                    System.out.println("Artist: ");
                    String albumArtist = scanner.nextLine();
                    SongCollection a = scmA.makeSongCollection(albumName, albumArtist);
                    allAlbums.add(a); // add album to master list
                    System.out.println("Here is your album: " + a);
                    System.out.println("""
                            1. Create new song.
                            2. Create new album.
                            3. Add songs to existing album.
                            4. Exit back to menu.""");
                    upload = scanner.nextInt();
                }
                // 3: Add existing song to existing album.
                else if (upload == 3) {
                    // print out list of albums they can add to
                    for (SongCollection sc : allAlbums) {
                        System.out.println(sc.getName());
                    }
                    System.out.println("Which album do you want to add to? Type in the name of the album:");
                    scanner.nextLine();
                    String albumName = scanner.nextLine();
                    // print out list of songs they can add
                    ListIterator<Song> iterS = allSongs.iterator();
                    while (iterS.hasNext())
                    {
                        Song b = iterS.next();
                        System.out.println(b.getTitle()+" by " +b.getArtist());
                    }
                    System.out.println("Which song are you adding? Choose from the songs in your music library above.");
                    scanner.nextLine();
                    String songName = scanner.nextLine();
                    ListIterator<Song> iter = allSongs.iterator();
                    Song tempSong = null;
                    while (iter.hasNext()) {
                        Song b = iter.next();
                        if (b.getTitle().equals(songName)) {
                            tempSong = b;
                            break;
                        }
                    }
                    // iterate through albumNames to find album
                    for (SongCollection sc : allAlbums) {
                        if (sc.getName().equals(albumName)) {
                            sc.addSong(tempSong);
                            System.out.println("Here is your album: " + sc);
                            break;
                        }
                    }
                    System.out.println("""
                            1. Create new song.
                            2. Create new album.
                            3. Add another song.
                            4. Exit.""");
                    upload = scanner.nextInt();
                }
            }
            System.out.println("1. Upload music.\n" + "2. Listen to music.");
            uploadOrListen = scanner.nextInt();
        }


// Listen
        while (uploadOrListen == 2) {
            // Menu
            System.out.println("Select an option from the menu: \n1.Play music from the queue \n2.Modify queue  \n3.Create new playlist  \n4.Add song to playlist\n5. Exit");
            int queueOrPlaylist = scanner.nextInt();
            // 1. Play Queue
            if (queueOrPlaylist == 1) {
                System.out.println("1.Play music in order \n2.Shuffle Play");
                int playOrder = scanner.nextInt();
                if (playOrder == 1) {
                    try {
                        Command playQueue = new PlayInOrderCommand(queue, state);
                        userFacade.addToCommandList(playQueue);
                        Invoker.invokeExecute();
                    } catch (BasicUserException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (playOrder == 2) {
                    try {
                        userFacade.makeSongCollection();
                        Command shuffleQueue = new ShuffleCommand(queue, state);
                        userFacade.addToCommandList(shuffleQueue);
                        Invoker.invokeExecute();
                    } catch (BasicUserException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }
            // 2. Modify Queue
            else if (queueOrPlaylist == 2) {
                System.out.println("How would you like to modify the queue? \n1.Add song to queue \n2.Add playlist to queue  \n3.Add Album to queue \n4.Skip song in queue");
                int modifyQueue = scanner.nextInt();
                // 1. Add Song
                if (modifyQueue == 1) {
                     // print out list of songs they can add
                    System.out.println("Here is a list of all songs in your music library:");
                    ListIterator<Song> iterS = allSongs.iterator();
                    while (iterS.hasNext())
                    {
                        Song b = iterS.next();
                        System.out.println(b.getTitle()+" by " +b.getArtist());
                    }
                    System.out.println("Which song are you adding? Enter the name of the song:");
                    scanner.nextLine();
                    String songName = scanner.nextLine();
                    ListIterator<Song> i = allSongs.iterator();
                    while (i.hasNext()) {
                        Song b = i.next();
                        if (b.getTitle().equals(songName)) {
                            queue.addSong(b);
                            System.out.println(b + " has been added to the queue");
                            break;
                        }
                    }
                }
                // 2. Add Playlist to Queue
                else if (modifyQueue == 2) {
                    System.out.println("Here is a list of all playlists in your music library:");
                    for (SongCollection sc : allPlaylists) {
                        System.out.println(sc.getName());
                    }
                    System.out.println("Which playlist do you want to add to the queue?");
                    scanner.nextLine();
                    String playlistName = scanner.nextLine();
                    for (SongCollection sc : allPlaylists) {
                        if (sc.getName().equals(playlistName)) {
                            queue.addCollection(sc);
                            System.out.println(sc.getName() + " has been added to the queue");
                            break;
                        }
                    }
                }
                //3. Add Album to Queue
                else if (modifyQueue == 3) {
                    // print out list of albums they can add to
                    System.out.println("Here is a list of all albums in your music library:");
                    for (SongCollection sc : allAlbums) {
                        System.out.println(sc.getName());
                    }
                    System.out.println("Which album do you want to add to the queue? Enter the name of the album:");
                    scanner.nextLine();
                    String albumName = scanner.nextLine();
                    for (SongCollection sc : allAlbums) {
                        //System.out.println(sc.getName());
                        if (sc.getName().equals(albumName)) {
                            queue.addCollection(sc);
                            System.out.println(sc.getName() + " has been added to the queue");
                            break;
                        }
                    }
                }
                // 4. Skip Song
                else if (modifyQueue == 4) {
                    System.out.println("Here are the songs currently in your queue: ");
                    ListIterator<Song> iterQ = queue.iterator();
                    while (iterQ.hasNext()) {
                        Song b = iterQ.next();
                        System.out.println(b.getTitle());
                    }
                    System.out.println("Which song would you like to skip?");
                    scanner.nextLine();
                    String songToSkip = scanner.nextLine();
                    ListIterator<Song> i = queue.iterator();
                    while (i.hasNext()) {
                        Song b = i.next();
                        if (b.getTitle().equals(songToSkip)) {
                            try {
                                userFacade.removeSong(queue, b);
                                System.out.println("Skipping: " + b + " is no longer in the queue.");
                            }
                            catch(BasicUserException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    }
                }

            }
            // 3. Create new playlist
            else if (queueOrPlaylist == 3) {
                System.out.println("Give your playlist a name:");
                scanner.nextLine();
                String playlistName = scanner.nextLine();
                SongCollectionMaker pm = new PlaylistMaker();
                SongCollection playlist = pm.makeSongCollection(playlistName);
                allPlaylists.add(playlist);

            }
            // 4. Add Song/s to Existing Playlist
            else if (queueOrPlaylist == 4) {
                // print out all playlist options for reference
                System.out.println("Here is a list of all playlists in your music library:");
                for (SongCollection sc : allPlaylists) {
                    System.out.println(sc.getName());
                }
                System.out.println("Which playlist do you want to add to? Enter the name of the playlist:");
                scanner.nextLine();
                String playlistName = scanner.nextLine();
                // print out all song options for reference
                System.out.println("Here is a list of all songs in your music library:");
                ListIterator<Song> iterS = allSongs.iterator();
                while (iterS.hasNext())
                {
                    Song b = iterS.next();
                    System.out.println(b.getTitle()+" by " +b.getArtist());
                }
                System.out.println("Which song are you adding? Enter the name of the song: ");
                String songName = scanner.nextLine();
                ListIterator<Song> i = allSongs.iterator();
                Song tempSong = null;
                while (i.hasNext()) {
                    Song b = i.next();
                    if (b.getTitle().equals(songName)) {
                        tempSong = b;
                        break;
                    }
                }
                // iterate through albumNames to find album
                for (SongCollection sc : allPlaylists) {
                    if (sc.getName().equals(playlistName)) {
                        sc.addSong(tempSong);
                        System.out.println("Here is your playlist: " + sc);
                        break;
                    }
                }
            }
        }
        System.out.println("1. Upload music.\n" + "2.Listen to music.");
        uploadOrListen = scanner.nextInt();
        }
    }