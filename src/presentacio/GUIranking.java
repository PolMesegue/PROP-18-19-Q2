package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIranking {
    private JTextArea JugadorsArea;
    private JTextArea PuntsArea;
    private JButton tornarEnrerraButton;
    private JPanel MyRankingPanel;

    public JPanel getMyRankingPanel() {
        return MyRankingPanel;
    }

    public GUIranking() {
        tornarEnrerraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame main = frame.getInstance();
                main.setContentPane(new GUIMain().getMyGUIMain());
                main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                main.setVisible(true);
            }
        });
    }
}
