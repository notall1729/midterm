package musicPlayer;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month){
       this.month = month;
    }

    private void createPlaylist (String Title, User Owner){
        Playlist newPlayList = new PlayList();
        Owner.playlists.add(newPlayList);
    }

    public void playMusic (Music music){
        music.play();
    }

    private void buyPremium (User owner, int month){
     this.month += month;
    }
}
