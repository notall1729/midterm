package musicPlayer;

public class RegularBehavior implements UserBehavior{
    private int playingLimit;

    public RegularBehavior(){
        this.playingLimit = 5;
    }

    public void createPlaylist (String Title, User Owner){
      throw new InvalidOperationException("You are a regular user. regular users cannot create a playlist.");
    }

    public void playMusic (Music music){
        if(playingLimit > 0) {
            music.play();
            playingLimit--;
        }
        if(playingLimit == 0){
            throw new InvalidOperationException("You can only play 5 songs per day.");
        }

    }

     public void buyPremium (User owner, int month){
        PremiumBehavior premiumBehavior = new PremiumBehavior(month);
        premiumBehavior = (PremiumBehavior) owner.behavior;
    }
}
