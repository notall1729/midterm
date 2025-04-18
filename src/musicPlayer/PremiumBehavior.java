package musicPlayer;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month){
       this.month = month;
    }

    private void createPlaylist (String Title, User Owner){
        Playlist newPlayList = new Playlist(Title, Owner);
        Owner.playlists.add(newPlayList);
    }

    private void playMusic (Music music){
        music.play();
    }

    private void buyPremium (User owner, int month){
     this.month += month;
    }
}
