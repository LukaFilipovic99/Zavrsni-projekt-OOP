package memory_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa MainFrame za memory igru.
 */

public class MainFrame extends JFrame {
    private CardPanel cards;
    private ScorePanel sPanel;


    public MainFrame(){
        super("Memory game");
        initComps();
        setLayout(new BorderLayout());
        setSize(1300, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        add(cards,BorderLayout.WEST);
        cards.setPreferredSize(new Dimension(900,700));
        add(sPanel,BorderLayout.CENTER);
        sPanel.setBackground(Color.LIGHT_GRAY);
        setPlaying();
        playGame();
    }

    private void initComps(){
        cards=new CardPanel();
        sPanel=new ScorePanel();
    }

    /**
     * Metoda koja služi za bilježenje rezultata na ScorePanel. Klikom na New game button resetira igru, a klikom na End game button zatvara igru.
     */
    private void playGame() {
        cards.setFormListener(new FormListener() {
            @Override
            public void showScore(FormEvent obj) {
                String pl1S = obj.getPl1Score();
                String pl2S = obj.getPl2Score();
                String playing = obj.getPlaying();
                sPanel.setPl1Score(pl1S);
                sPanel.setPl2Score(pl2S);
                sPanel.setTurnText(playing);
                if (cards.isGameOver()){
                    if (Integer.parseInt(obj.getPl1Score())>Integer.parseInt(obj.getPl2Score())){
                        JOptionPane.showMessageDialog(cards,"Game over!\nWinner: Player 1");
                    }else if(Integer.parseInt(obj.getPl2Score())>Integer.parseInt(obj.getPl1Score())){
                        JOptionPane.showMessageDialog(cards,"Game over!\nWinner: Player 2");
                    }else{
                        JOptionPane.showMessageDialog(cards,"Game over!\nDraw");
                    }
                }
            }
        });
        sPanel.getBtnNG().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(cards);
                remove(sPanel);
                cards = new CardPanel();
                add(cards, BorderLayout.WEST);
                cards.setPreferredSize(new Dimension(900, 700));
                sPanel = new ScorePanel();
                add(sPanel, BorderLayout.CENTER);
                sPanel.setBackground(Color.LIGHT_GRAY);
                revalidate();
                setPlaying();
                playGame();
            }
        });
        sPanel.getBtnEG().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * Metoda koja prikazuje koji je igrač prvi na redu.
     */

    private void setPlaying(){
        if (cards.getPlaying() == 1) {
            sPanel.setTurnText("Player 1");
            JOptionPane.showMessageDialog(this, "This is a memory game. \nMatch two same car logos to get point. \nPlayer with more points win.\nPlayer 1 will play first.");
        } else {
            sPanel.setTurnText("Player 2");
            JOptionPane.showMessageDialog(this, "This is a memory game.\nMatch two same car logos to get point.\nPlayer with more points win.\nPlayer 2 will play first.");
        }
    }
}

