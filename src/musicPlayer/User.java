package musicPlayer;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    public ArrayList<User> followerList = new ArrayList<>();
    public ArrayList<User> followingList = new ArrayList<>();
    public UserBehavior behavior;
    public ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        if(!(allUsers.contains(username))) {
            this.username = username;
        }
        else {
            throw new InvalidOperationException("This username is already exist.");
        }

        if(password.length() >= 8) {
            this.password = password;
        }
        else{
            throw new InvalidOperationException("Password at least must have 8 characters long.");
        }
         RegularBehavior regularBehavior = new RegularBehavior();
        this.behavior = regularBehavior;
    }

    private void follow(User user){
        if(followingList.contains(user))
            throw new InvalidOperationException("You are already following this user.");

        followingList.add(user);
    }

    private void createPlaylist(String Title, User Owner){
        this.behavior.createPlaylist(Title, Owner);
    }

    private void playMusic(Music music){
        this.behavior.playMusic(music);
    }

    private void buyPremium(User owner, int month){
        this.behavior.buyPremium(owner, month);
    }
}
