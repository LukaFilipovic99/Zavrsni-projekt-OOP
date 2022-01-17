package memory_game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Klasa ScorePanel za memory igre.
 */

public class ScorePanel extends JPanel {
    private JLabel scoreLbl;
    private JLabel pl1Lbl;
    private JLabel pl2Lbl;
    private JTextField pl1Score;
    private JTextField pl2Score;
    private JLabel turnLbl;
    private JTextField turnText;
    private JButton btnNG;
    private JButton btnEG;

    public ScorePanel() {
        initComps();
        setLayout(new GridBagLayout());
        Border border = BorderFactory.createLineBorder(Color.BLACK, 10);
        setBorder(border);
        layoutComps();
        setPl1Score("0");
        setPl2Score("0");
    }


    private void initComps(){
        Font font1=new Font("Comic Sans MS",Font.BOLD,32);
        Font font2=new Font("Comis Sans MS",Font.ITALIC,24);
        Font font3=new Font("Comis Sans MS",Font.BOLD,20);
        scoreLbl=new JLabel("SCORE:");
        scoreLbl.setFont(font1);
        pl1Lbl=new JLabel("Player 1:");
        pl2Lbl=new JLabel("Player 2:");
        pl1Lbl.setFont(font2);
        pl2Lbl.setFont(font2);
        pl1Score=new JTextField(2);
        pl2Score=new JTextField(2);
        pl1Score.setFont(font1);
        pl2Score.setFont(font1);
        turnLbl=new JLabel("Playing: ");
        turnLbl.setFont(font2);
        turnText=new JTextField(6);
        turnText.setFont(font1);
        btnNG=new JButton("New Game");
        btnNG.setFont(font3);
        btnEG=new JButton("Exit Game");
        btnEG.setFont(font3);
    }
    private void layoutComps(){
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.weighty=0.5;
        gbc.weightx=0;
        gbc.gridx=0;
        gbc.gridy=0;
        add(scoreLbl,gbc);

        gbc.weighty=0;
        gbc.weightx=0;
        gbc.gridy++;
        gbc.insets=new Insets(0,0,0,10);
        gbc.anchor=GridBagConstraints.LINE_END;
        add(pl1Lbl,gbc);
        gbc.gridx++;
        gbc.anchor=GridBagConstraints.LINE_START;
        add(pl1Score,gbc);

        gbc.gridx=0;
        gbc.weighty=0;
        gbc.weightx=0;
        gbc.gridy++;
        gbc.anchor=GridBagConstraints.LINE_END;
        add(pl2Lbl,gbc);
        gbc.gridx++;
        gbc.anchor=GridBagConstraints.LINE_START;
        add(pl2Score,gbc);

        gbc.gridx=0;
        gbc.weighty=1.2;
        gbc.weightx=0;
        gbc.gridy++;
        gbc.anchor=GridBagConstraints.LINE_END;
        add(turnLbl,gbc);
        gbc.gridx++;
        gbc.anchor=GridBagConstraints.LINE_START;
        add(turnText,gbc);

        gbc.gridx=0;
        gbc.weighty=1;
        gbc.weightx=0;
        gbc.gridy++;
        gbc.anchor=GridBagConstraints.LINE_END;
        add(btnNG,gbc);

        gbc.gridx++;
        gbc.anchor=GridBagConstraints.LINE_END;
        add(btnEG,gbc);


    }

    public void setPl1Score(String pl1Score) {
        this.pl1Score.setText(pl1Score);
    }

    public void setPl2Score(String pl2Score) {
        this.pl2Score.setText(pl2Score);
    }

    public void setTurnText(String turnText) {
        this.turnText.setText(turnText);
    }

    public JButton getBtnNG() {
        return btnNG;
    }

    public JButton getBtnEG() {
        return btnEG;
    }


}
