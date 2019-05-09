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

}
