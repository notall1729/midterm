package musicPlayer;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month){
       this.month = month;
    }

    @Override
    public void createPlaylist (String Title, User Owner){
        Playlist newPlayList = new Playlist(Title, Owner);
        Owner.getPlaylists().add(newPlayList);
    }

    @Override
    public void playMusic (Music music){
        music.play();
    }

    @Override
    public void buyPremium (User owner, int month){
     this.month += month;
    }
}
