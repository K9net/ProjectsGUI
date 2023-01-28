package Sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class JukeBox {
    ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args) {
        new JukeBox().go();
    }

    class ArtistCompare implements Comparator<Song>{

        @Override
        public int compare(Song o1, Song o2) {
            return o1.getBpm().compareTo(o2.getBpm());
        }
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);
        System.out.println(songList);
    }

    void getSongs() {
        try {
            File file = new File("songs.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addSong(String str) {
        String[] tokens = str.split("/");
        ArrayList<String> result = new ArrayList<>();
        for (String token:tokens){
            String res1 = token.trim();
            result.add(res1);
        }

        int bpm = Integer.parseInt(result.get(3));

        Song song = new Song(result.get(0), result.get(1), result.get(2), bpm, result.get(4));
        songList.add(song);
    }
}
