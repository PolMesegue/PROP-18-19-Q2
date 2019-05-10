package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarProblema {
    private JTextField textField1;
    private JButton confirmarButton;
    private JPanel MyRProblema;
    private JButton tornarButton;

    public RegistrarProblema() {
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               // ctrlP.afegirProblema(textField1.getText());

                JOptionPane.showMessageDialog(null,"Afegit correctament");

                frame prob = frame.getInstance();

                GUIProblema prob1 = new GUIProblema();

                prob.setContentPane(prob1.getMyGUIProblema());
                prob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                prob.setBounds(500,300,250,250);
                prob.setVisible(true);



            }
        });
        tornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame prob = frame.getInstance();

                GUIProblema prob1 = new GUIProblema();

                prob.setContentPane(prob1.getMyGUIProblema());
                prob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                prob.setBounds(500,300,250,250);
                prob.setVisible(true);
            }
        });
    }

    public JPanel getMyRProblema() {
        return MyRProblema;
    }
}
