package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIranking {
    private JTextArea JugadorsArea;
    private JTextArea PuntsArea;
    private JButton tornarEnrerraButton;
    private JPanel MyRankingPanel;

    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();

    public JPanel getMyRankingPanel() {
        return MyRankingPanel;
    }

    public GUIranking() {

        for(int i=0; i<CtrlP.getUsersRanking().size();i++){
            JugadorsArea.append(CtrlP.getUsersRanking().get(i)+"\n");
        }
        for(int i=0; i<CtrlP.getUsersRankingPoints().size();i++) {
            PuntsArea.append(CtrlP.getUsersRankingPoints().get(i).toString()+ "\n");
        }
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
