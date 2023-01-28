package Sort;

public class Song implements Comparable<Song> {
    private String name;
    private String artist;
    private String rating;
    private String bpm;
    private String duration;

    Song(String n, String a, String r, String b, String d) {
        name = n;
        artist = a;
        rating = r;
        bpm = b;
        duration = d;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String getDuration() {
        return duration;
    }

    public String toString() {
        String result = ("\nНазвание: " + name + " Артист: " + artist + " Рейтинг: " + rating
                + " БПМ: " + bpm + " Длительность: " + duration);
        return result;
    }

    @Override
    public int compareTo(Song song) {
        return name.compareTo(song.getName());
    }
}
