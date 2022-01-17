package memory_game;

import javax.swing.*;

/**
 * Klasa Card predstavlja karte u memory igri.
 */

public class Card extends JButton {
    private int id;
    private boolean match;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

}
