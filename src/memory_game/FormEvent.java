package memory_game;

import java.util.EventObject;

/**
 * Klasa FormEvent za memory igru.
 */

public class FormEvent extends EventObject {
    private String pl1Score;
    private String pl2Score;
    private String playing;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public FormEvent(Object source) {
        super(source);
    }

    public String getPl1Score() {
        return pl1Score;
    }

    public void setPl1Score(String pl1Score) {
        this.pl1Score = pl1Score;
    }

    public String getPl2Score() {
        return pl2Score;
    }

    public void setPl2Score(String pl2Score) {
        this.pl2Score = pl2Score;
    }

    public String getPlaying() {
        return playing;
    }

    /**
     * Meotoda koja prati koji je igrač na redu za igrati.
     * @param n Prima parametar n tipa int koji služi za praćenje koji je igrač na redu.
     */

    public void setPlaying(int n) {
        if (n%2==0){
            this.playing="Player 2";
        }else{
            this.playing="Player 1";
        }
    }
}
