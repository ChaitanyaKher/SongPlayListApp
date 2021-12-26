package com.chaitanya;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Origins","Imagine Dragons");

        album.addSong("Natural",3.09);
        album.addSong("Boomerang",3.07);
        album.addSong("Machine",3.01);
        album.addSong("Cool Out",3.37);
        album.addSong("Bad Liar",4.20);
        album.addSong("West Coast",3.37);
        album.addSong("Zero",3.30);
        album.addSong("Bullet in a Gun",3.24);
        album.addSong("Digital",3.21);
        album.addSong("Only",3.00);
        album.addSong("Stuck",3.10);
        album.addSong("Love",2.46);
        albums.add(album);

        album = new Album("Master of Puppets","Metallica");

        album.addSong("Battery",5.13);
        album.addSong("Master of Puppets",8.36);
        album.addSong("The Thing That Should Not Be",6.36);
        album.addSong("Welcome Home(Sanitarium)",6.27);
        album.addSong("Disposable Heroes",8.17);
        album.addSong("Leper Messiah",5.40);
        album.addSong("Orion(Instrumental)",8.27);
        album.addSong("Damage Inc.",5.32);
        album.addSong("Battery(Live)",4.53);
        album.addSong("The Thing That Should Not Be(Live)",7.02);
        albums.add(album);

        LinkedList<Song> PlayList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("West Coast",PlayList_1);
        albums.get(1).addToPlayList("Master of Puppets",PlayList_1);
        albums.get(1).addToPlayList("Battery",PlayList_1);
        albums.get(1).addToPlayList("Disposable Heroes",PlayList_1);
        albums.get(0).addToPlayList("Zero",PlayList_1);
        albums.get(0).addToPlayList("Love",PlayList_1);

        play(PlayList_1);
    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward =true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0){
            System.out.println("This playlist has no song");
        } else {
            System.out.println("Now playing "+ listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward =true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    } else {
                        System.out.println("no song available, reached to the end of the list :(");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.hasPrevious();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());
                    } else {
                        System.out.println("You are at the first song :)");
                        forward =false;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing "+ listIterator.previous().toString());
                            forward =false;
                        } else {
                            System.out.println("You are at the start of the playlist! :)");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next().toString());
                            forward =true;
                        } else {
                            System.out.println("You have now reached to the end of the playlist! :(");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious()){
                                System.out.println("Now playing "+ listIterator.previous().toString());
                            }
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press \n");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n"+
                "2 - play previous song\n"+"" +
                "3 - replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("---------------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("---------------------");
    }
}
