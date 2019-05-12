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
    private JButton tornarEnrereButton;

    public GUIProblema() {

        afergirProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame registrarP = frame.getInstance();
                RegistrarProblema prob2 = new RegistrarProblema();

                registrarP.setContentPane(prob2.getMyRProblema());
                registrarP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             //   registrarP.setBounds(500,300,250,250);
                registrarP.setVisible(true);
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


        tornarEnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame main = frame.getInstance();
                main.setContentPane(new GUIMain().getMyGUIMain());
                main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                main.setBounds(500,300,250,250);

                main.setVisible(true);
            }
        });
    }

    public JPanel getMyGUIProblema() {
        return MyGUIProblema;
    }


}
