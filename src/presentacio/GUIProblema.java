package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIProblema {
    private JPanel MyGUIProblema;
    private JButton esborrarProblemaButton;
    private JButton consultarProblemaButton;
    private JButton afergirProblemaButton;
    private JButton modificarProblemaButton;

    public GUIProblema() {

        afergirProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"kek");
            }
        });

        modificarProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"kek2");
            }
        });

        esborrarProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modificarProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"kek4");
            }
        });


    }

    public void main() {
        JFrame main = new JFrame("User");
        main.setContentPane(new GUIProblema().MyGUIProblema);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setBounds(500,300,250,250);
        main.setVisible(true);
    }


}
