package musicPlayer;

public class RegularBehavior implements UserBehavior{
    private int playingLimit = 5;

    @Override
    public void createPlaylist (String Title, User Owner){
      throw new InvalidOperationException("You are a regular user. regular users cannot create a playlist.");
    }

    @Override
    public void playMusic (Music music){
        if(playingLimit > 0) {
            music.play();
            playingLimit --;
        }
        if(playingLimit == 0){
            throw new InvalidOperationException("You can only play 5 songs per day.");
        }

    }

    @Override
    public void buyPremium (User owner, int month){
       owner.setBehavior(new PremiumBehavior(month));
    }
}
