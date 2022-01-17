package memory_game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Klasa CardPanel za memory igru.
 */

public class CardPanel extends JPanel{

    private static final int NUM_PAIRS=10;
    private ArrayList<Integer> cardIds=new ArrayList<>();
    private ArrayList<Card> cards=new ArrayList<>();
    private Card card1;
    private Card card2;
    private Card selectedCard;
    private HashMap<Integer,ImageIcon> images=new HashMap<>();
    private Timer t;
    private int playing;
    private int pl1Score;
    private int pl2Score;
    private FormListener listener;

    public CardPanel() {
        playing= ThreadLocalRandom.current().nextInt(1,3);
        pl1Score=0;
        pl2Score=0;
        setLayout(new GridLayout(4, 5));
        setCardIds();
        setCards();
        initImages();
        playGame();
    }

    /**
     * Metoda koja kartama postavlja id.
     */
    private void setCardIds(){
        for (int i = 0; i < NUM_PAIRS; i++) {
            cardIds.add(i);
            cardIds.add(i);
        }
        Collections.shuffle(cardIds);
    }

    /**
     * Metoda koja postavlja karte na CardPanel.
     */

    private void setCards(){
        for (int id : cardIds) {
            Card card = new Card();
            card.setId(id);
            cards.add(card);
        }
        for (Card card : cards) {
            try {
                BufferedImage icon= ImageIO.read(getClass().getResource("/images/mark.jpg"));
                card.setIcon(new ImageIcon(icon));
            } catch (IOException e) {
                e.printStackTrace();
            }
            add(card);
        }
    }


    /**
     * Metoda koja provjerava je li id prve karte jednak id-u druge karte.
     */

    private void checkCardIds(){
        if (card1.getId()==card2.getId()){
            card1.setEnabled(false);
            card2.setEnabled(false);
            if (playing%2==0){
                pl2Score++;
            }else{
                pl1Score++;
            }
            card1.setMatch(true);
            card2.setMatch(true);
        }else{
            try {
                BufferedImage icon= ImageIO.read(getClass().getResource("/images/mark.jpg"));
                card1.setIcon(new ImageIcon(icon));
                card2.setIcon(new ImageIcon(icon));
            } catch (IOException e) {
                e.printStackTrace();
            }
            playing++;
        }
        card1 = null;
        card2 = null;
    }

    /**
     * Metoda koja otvara prvu i drugu kartu te poziva metodu checkCardIds.
     */

    private void openCard(){
        if (card1 == null && card2 == null){
            card1=selectedCard;
            card1.setIcon(images.get(card1.getId()));
        }

        if (card1 != null && card1 != selectedCard && card2 == null){
            card2 = selectedCard;
            card2.setIcon(images.get(card2.getId()));
            t.start();
        }
        t = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCardIds();
                FormEvent obj=new FormEvent(this);
                obj.setPl1Score(String.valueOf(pl1Score));
                obj.setPl2Score(String.valueOf(pl2Score));
                obj.setPlaying(playing);
                if (listener!=null) {
                    listener.showScore(obj);
                }

            }
        });
        t.setRepeats(false);
    }

    /**
     * Metoda koja provjerava je li igra završena.
     * @return vraća false ako igra nije gotova, a true ako je gotova.
     */

        public boolean isGameOver(){
            for(Card card: this.cards){
                if (!card.isMatch()){
                    return false;
                }
            }
            return true;
        }

    /**
     * Metoda koja kartama postavlja slike.
     */

    private void initImages(){
            for (Card card:cards){
                switch (card.getId()){
                    case 0:
                        try {
                            BufferedImage icon0 = ImageIO.read(getClass().getResource("/images/logo1.jpg"));
                            images.put(card.getId(),new ImageIcon(icon0));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        try {
                            BufferedImage icon1 = ImageIO.read(getClass().getResource("/images/logo2.jpg"));
                            images.put(card.getId(),new ImageIcon(icon1));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            BufferedImage icon2 = ImageIO.read(getClass().getResource("/images/logo3.jpg"));
                            images.put(card.getId(),new ImageIcon(icon2));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            BufferedImage icon3 = ImageIO.read(getClass().getResource("/images/logo4.jpg"));
                            images.put(card.getId(),new ImageIcon(icon3));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            BufferedImage icon4 = ImageIO.read(getClass().getResource("/images/logo5.jpg"));
                            images.put(card.getId(),new ImageIcon(icon4));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            BufferedImage icon5 = ImageIO.read(getClass().getResource("/images/logo6.jpg"));
                            images.put(card.getId(),new ImageIcon(icon5));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            BufferedImage icon6 = ImageIO.read(getClass().getResource("/images/logo7.jpg"));
                            images.put(card.getId(),new ImageIcon(icon6));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            BufferedImage icon7 = ImageIO.read(getClass().getResource("/images/logo8.jpg"));
                            images.put(card.getId(),new ImageIcon(icon7));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 8: try {
                        BufferedImage icon8 = ImageIO.read(getClass().getResource("/images/logo9.jpg"));
                        images.put(card.getId(),new ImageIcon(icon8));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                        break;
                    case 9:
                        try {
                            BufferedImage icon9 = ImageIO.read(getClass().getResource("/images/logo10.jpg"));
                            images.put(card.getId(),new ImageIcon(icon9));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }

        private void playGame(){
            for (Card card:cards){
                card.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectedCard=card;
                        openCard();
                    }
                });
            }
        }

    public void setFormListener(FormListener list){
        this.listener=list;

    }


    public int getPlaying() {
        return playing;
    }

}
