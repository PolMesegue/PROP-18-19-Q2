package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain {


    private JPanel MyGUIMain;
    private JButton jugarButton;
    private JButton rankingButton;
    private JButton gestióUsuariButton;
    private JButton gestióProblemaButton;

    public GUIMain() {

        gestióUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        gestióProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    public JPanel getMyGUIMain() {
        return MyGUIMain;
    }
}
