import java.util.ArrayList;
import java.util.LinkedList;

public class Album {


      String name;

      String artistName;

      ArrayList<Songs>song;

    public Album(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
        this.song = new ArrayList<>();
    }

    public boolean searchSong(String title)
    {
        for(Songs s:song)
        {
            if(s.getTitle().equals(title))return true;
        }
        return false;
    }

    public void addSongToAlbum(String title,double duration)
    {
        //if song already exist

        if(searchSong(title)==true)
            System.out.println("Song is already exists");

        else {
            Songs newsongs=new Songs(title, duration);
             song.add(newsongs);

            System.out.println("song added successfully");

        }
    }


    public void addToPlayList(int trackNo, LinkedList<Songs> playlist)
    {
        //adding from another
        int index=trackNo-1;

        if(index>=0 && index<song.size())
        {
            Songs s=this.song.get(index);
            playlist.add(s);
        }
    }


    public void addToPlayList(String title,LinkedList<Songs>playlist)
    {
        //adding from Songs list
        for(Songs s:this.song)
        {
            if(s.getTitle().equals(title))
            {
                playlist.add(s);
            }
        }
    }
}
