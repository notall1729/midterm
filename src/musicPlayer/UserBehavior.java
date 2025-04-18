package musicPlayer;

public interface UserBehavior {
    void createPlaylist (String Title);
    void playMusic (Music music);
    void buyPremium (User owner, int month);
}
