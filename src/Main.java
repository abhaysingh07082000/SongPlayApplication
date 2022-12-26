import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
public class Main {



    public static ArrayList<Album>albums=new ArrayList<>();
    public static LinkedList<Songs>playlist_1=new LinkedList<>();
    public static void main(String[] args) {

        Album album=new Album("Album1","AB");

        album.addSongToAlbum("kya karun haye kuch kuch hota hai",5.42);
        album.addSongToAlbum("chand sifaris",4.58);
        album.addSongToAlbum("kash aap hmare hote",5.24);
        album.addSongToAlbum("tal se tal milayo",6.23);

        albums.add(album);


        album=new Album("Album2","CD");

        album.addSongToAlbum("kesariya tera",3.54);
        album.addSongToAlbum("hum tere bin ab rah nhi sakte",4.02);
        album.addSongToAlbum("meri ashiqui ab tum hi ho",3.24);
        album.addSongToAlbum("muskurane ki bajah tum ho",4.38);

        albums.add(album);

        Album album2=new Album("Album2","arijit");


        album.addToPlayList(1,playlist_1);
        album.addToPlayList(2,playlist_1);
        album.addToPlayList(3,playlist_1);
        album.addToPlayList(4,playlist_1);
        album.addToPlayList(5,playlist_1);
        album.addToPlayList(6,playlist_1);

        albums.get(0).addToPlayList("kya karun haye kuch kuch hota hai",playlist_1);
        albums.get(1).addToPlayList("kesariya tera",playlist_1);
        albums.get(0).addToPlayList("chand sifaris",playlist_1);
        albums.get(1).addToPlayList("hum tere bin ab rah nhi sakte",playlist_1);


        play(playlist_1);


    }


    public static  void play(LinkedList<Songs>playlist)
    {

        printMenu();

        Scanner sc=new Scanner(System.in);

        boolean quite=false;
         boolean forward=true;
      ListIterator<Songs>listIterator=playlist.listIterator();

        if(playlist.size()>0){

            System.out.println("Playing the first song");
            System.out.println(listIterator.next().toString());

        }else{
            System.out.println("PlayList is empty");
            return;
        }
        System.out.println("Enter your option");
//
//        boolean quit = false;
//        Scanner sc = new Scanner(System.in);


        while(!quite)
      {
          int option=sc.nextInt();
          switch(option)
          {
              case 0:{
                  quite=true;
                  break;
              }
              case 1:{
                  if(forward==false)
                  {
                      listIterator.next();
                      forward=true;
                  }
                  if(listIterator.hasNext())
                  {
                      System.out.println("Next Song playing =>"+listIterator.next().toString());
                      forward=true;

                  }
                  else {
                      System.out.println("You are at the last song");
                      forward=false;
                  }
                  break;
              }
              case 2:{
                  if(forward==true) {
                      listIterator.previous();
                      forward=false;
                  }
                  if(listIterator.hasNext())
                  {
                      System.out.println("Previous song playing =>"+listIterator.previous().toString());
                      forward=false;

                  }
                  break;
              }
              case 3:{

                  if(forward==true)
                  {
                      if(listIterator.hasPrevious())
                      {
                          System.out.println("Replay the current song =>"+listIterator.previous().toString());
                          forward=false;
                      }
                  }
                  else {
                      if(listIterator.hasNext())
                      {
                          System.out.println("Replay the current song =>"+listIterator.next().toString());
                          forward=true;
                      }
                  }
                  break;
              }
              case 4:{
                  printingSongList(playlist);
//                  break;
              }
              case 5:{
                  printMenu();
                  break;
              }
              case 6:
              {

              }
          }
      }

    }

    public static void printingSongList(LinkedList<Songs>playlist)
    {
        System.out.println("Printing the list of songs ");
        for(Songs s:playlist)
        {
            System.out.println(s.toString()+" ");
        }
    }
    public static void printMenu()
    {
        System.out.println("Available options \n to press");
        System.out.println("0   to exit\n" +
                "1 : to play next song\n" +
                "2 : to play previous song\n" +
                "3:  to replay the current song\n" +
                "4 :  list of all song\n" +
                "5 : print all available options\n" +
                "6 : delete current song");
    }
}