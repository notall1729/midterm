package musicPlayer;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream;
    private static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title, User singer) {
        this.title = title;
        this.singer = singer;
        this.numberOfStream = 0;
    }

    public void play(){
        System.out.println("Music: " + title + " by " + singer + "is playing...\n\n");
        numberOfStream ++;
    }

    private ArrayList<Music> search(String musicName){
        ArrayList<Music> result = new ArrayList<>();
      for (int i = 0; i < allMusics.size(); ++i){
          if(allMusics.get(i).title.equals(musicName))
              result.add(allMusics.get(i));
      }
      if(result.size() == 0) {
          return null;
      }
      return result;
    }

    private Music search(String musicName, String singerName){
        for (int i = 0; i < allMusics.size(); ++i){
            Music music = allMusics.get(i);
            if(music.title.equals(musicName) && music.singer.equals(singerName)){
                return music;
            }
        }
        return null;
    }

    public String getTitle() {
        return title;
    }

    public User getSinger() {
        return singer;
    }
}
