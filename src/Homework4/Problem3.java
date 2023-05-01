package Homework4;

public class Problem3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Song song2=new Song(2021,"Korea","BTS","Dynamite");
        song2.show();
    }

}


class Song{
    private String title,artist,country;
    private int year;

    public Song(int y,String c,String a,String t) {
        title=t;
        artist=a;
        country=c;
        year=y;
    }

    public Song() {
        title = artist = country = null;
        year = -1;
    }

    public void show() {
        System.out.printf("%d year, %s of %s song %s\n",year,artist,country,title);
    }

}
