package musicPlayer;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month){
       this.month = month;
    }

    public void createPlaylist (String Title, User Owner){
        Playlist newPlayList = new Playlist(Title, Owner);
        Owner.playlists.add(newPlayList);
    }

    public void playMusic (Music music){
        music.play();
    }

    public void buyPremium (User owner, int month){
     this.month += month;
    }
}
