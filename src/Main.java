import musicPlayer.InvalidOperationException;
import musicPlayer.Music;
import musicPlayer.Playlist;
import musicPlayer.User;

public class Main {
    public static void main(String[] args) {
        try {
            User Adele = new User("Adele", "AZYF56ESD");
            User Farhad = new User("Farhad Mehrad", "AEGKFRTUKLK");
            User Bomrani = new User("Bomrani", "123dfk6790");

                User maryam = new User("Marmay17", "1729QQQQQ");
                User maryam2 = new User("Maryam17", "128734567");
                User danial = new User("danial", "QXXXUzzzzfg");
            try {
                User shervin = new User("Shervin67", "ghdfg");
            }catch (InvalidOperationException e){
                System.out.println("Error: " +e.getMessage());
                System.out.println();
            }

            Music music1 = new Music("Someone like you", Adele);
            Music music2 = new Music("Jomeh", Farhad);
            Music music3 = new Music("Ayne", Farhad);
            Music music4 = new Music("Donyaye gondeye birahme khoshgel", Bomrani);
            Music music5 = new Music("Gisoo", Bomrani);

            maryam.getBehavior().playMusic(music1);

            try {
                maryam.getBehavior().createPlaylist("my playlist #1", maryam);
                Playlist playlist1 = maryam.getPlaylists().get(0);
                playlist1.addMusic(music4, maryam);
                playlist1.addMusic(music4, maryam);
                playlist1.addMusic(music3, maryam);
                playlist1.playPlaylist();
            }catch (InvalidOperationException e){
                System.out.println("Error: " + e.getMessage());
                System.out.println();
            }

            danial.getBehavior().buyPremium(danial, 3);
            danial.getBehavior().playMusic(music1);
            danial.getBehavior().playMusic(music2);
            danial.getBehavior().playMusic(music3);
            danial.getBehavior().playMusic(music4);
            danial.getBehavior().playMusic(music5);
            danial.getBehavior().playMusic(music1);

            danial.follow(maryam);
            danial.follow(Bomrani);
            maryam.follow(Adele);
            maryam.follow(Farhad);
        }catch (InvalidOperationException e){
            System.out.println("Error: " + e.getMessage());
            System.out.println();
        }
    }
}