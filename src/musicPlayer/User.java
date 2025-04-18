package musicPlayer;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password) {
        if(allUsers.contains(username)) {
            throw new InvalidOperationException("This username is already exist.");
        }

        if(password.length() < 8) {
            throw new InvalidOperationException("Password at least must have 8 characters long.");
        }
        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    public void follow(User user){
        if(followingList.contains(user)) {
            throw new InvalidOperationException("You are already following this user.");
        }

        if(user == this){
            throw new InvalidOperationException("Sorry you cannot follow yourself :)");
        }
        user.followerList.add(this);
        followingList.add(user);
    }

    public void createPlaylist(String Title, User Owner){
        this.behavior.createPlaylist(Title, Owner);
    }

    public void playMusic(Music music){
        this.behavior.playMusic(music);
    }

    public void buyPremium(User owner, int month){
        this.behavior.buyPremium(owner, month);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }
}
