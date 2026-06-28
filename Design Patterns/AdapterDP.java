
//The Adapter Design Pattern is a structural design pattern that allows two incompatible interfaces to work together.

//It acts as a bridge (translator) between a client and an existing class whose interface doesn't match what the client expects.


// Components
// 1. Target

// The interface the client expects.

// interface MediaPlayer {
//     void play(String fileName);
// }
// 2. Adaptee

// Existing class with an incompatible interface.

// class VLCPlayer {
//     void playVLC(String fileName){
//     }
// }
// 3. Adapter

// Implements Target and internally calls Adaptee.

// class VLCAdapter implements MediaPlayer{

//     private VLCPlayer player;

//     public VLCAdapter(){
//         player = new VLCPlayer();
//     }

//     public void play(String fileName){
//         player.playVLC(fileName);
//     }
// }
// 4. Client

// Uses only the Target interface.

// Client
//    │
// MediaPlayer
//    │
// Adapter
//    │
// VLCPlayer

// The client doesn't know that a VLC player is behind the adapter.

interface MediaPlayer {
    void play(String fileName);
}

// Adaptee
class VLCPlayer {

    public void playVLC(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

// Adapter
class VLCAdapter implements MediaPlayer {

    private VLCPlayer vlcPlayer;

    public VLCAdapter() {
        vlcPlayer = new VLCPlayer();
    }

    @Override
    public void play(String fileName) {
        vlcPlayer.playVLC(fileName);
    }
}

// Client
public class AdapterPatternDemo {

    public static void main(String[] args) {

        MediaPlayer player = new VLCAdapter();

        player.play("movie.vlc");
    }
}
