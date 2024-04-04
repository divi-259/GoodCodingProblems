/*
Problem Statement:
Design a Playlist where each time a user requests to shuffle Tracks inside it, the playlist should be shuffled in a non-predictive manner.

Follow up: Make the shuffle such that no two artists have songs appearing back to back.

*/

public class Playlist {

    List<Song> list = new ArrayList<>();
    Song latestSong;
    Song prevSong = -1;

    public playSong() {
        
        while(song.artist.id == prevSong.artist.id)
        {
            // to get the random number from 1 to size of the list
        int songnum = RandomNumber.getRandomNumber(list.size()); 
        }
        Song song = list.get(songnum);
        latestSong = song;

        // play song logic

    }
    public pauseSong() {
        prevSong = latestSong; // as soon as the song is paused we can save it 
    }
 

}