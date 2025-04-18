package musicPlayer;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist = new ArrayList<>();
    private User owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }

    private void editTitle(String newTitle, User user){
        if(user.getUsername().equals(owner.getUsername()) && user.getPassword().equals(owner.getUsername)) {
            if (newTitle.equals(title)) {
                throw new InvalidOperationException("The playlist title is the same right now.");
            }

            title = newTitle;
        }
        else if(!(user.getUsername().equals(owner.getUsername()))){
            throw new InvalidOperationException("This is not your playlist.");
        }
        else{
            throw new InvalidOperationException("Your password is not correct.");
        }
    }

    private void addMusic(Music music, User user){
        if(user.getUsername().equals(owner.getUsername()) && user.getPassword().equals(owner.getUsername)) {
            if (playlist.contains(music)) {
                throw new InvalidOperationException("This song is already exists.");
            }

            playlist.add(music);
        }
        else if(!(user.getUsername().equals(owner.getUsername()))){
            throw new InvalidOperationException("This is not your playlist.");
        }
        else{
            throw new InvalidOperationException("Your password is not correct.");
        }
    }

    private void removeMusic(Music music, User user){
        if(user.getUsername().equals(owner.getUsername()) && user.getPassword().equals(owner.getUsername)) {
            if (!(playlist.contains(music))) {
                throw new InvalidOperationException("This song is not in your playlist.");
            }

            playlist.remove(music);
        }
        else if(!(user.getUsername().equals(owner.getUsername()))){
            throw new InvalidOperationException("This is not your playlist.");
        }
        else{
            throw new InvalidOperationException("Your password is not correct.");
        }
    }

    private ArrayList<Music> searchInPlaylist(String musicName){
        ArrayList<Music> result = new ArrayList<>();
        for (int i = 0; i < playlist.size(); ++i){
            if(playlist.get(i).getTitle().equals(musicName))
                result.add(playlist.get(i));
        }
        if(result.size() == 0) {
            return null;
        }
        return result;
    }

    private Music searchInPlaylist(String musicName, String singerName){
        for (int i = 0; i < playlist.size(); ++i){
            Music music = playlist.get(i);
            if(music.getTitle().equals(musicName) && music.getSinger().equals(singerName)){
                return music;
            }
        }
        return null;
    }

    private void playPlaylist(){
        for(int i = 0; i < playlist.size(); ++i){
            playlist.get(i).play();
        }
    }

    private void shuffle(){
        for (int i = 0; i < playlist.size(); ++i){
            Random random = new Random();
            int rand = random.nextInt(playlist.size());
            playlist.get(rand).play();
        }
    }
}
