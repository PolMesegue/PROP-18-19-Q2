package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarProblema {
    private JTextField textField1;
    private JButton confirmarButton;
    private JPanel MyRProblema;
    private JButton tornarButton;
    private JTextField Matfield;
    private CtrlPresentacio ctrlP = CtrlPresentacio.getInstance();

    public RegistrarProblema() {
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int mat = Integer.parseInt(Matfield.getText());
                if(ctrlP.afegirProblema(textField1.getText(),mat)) {

                    JOptionPane.showMessageDialog(null, "Afegit correctament");

                    frame prob = frame.getInstance();

                    GUIProblema prob1 = new GUIProblema();

                    prob.setContentPane(prob1.getMyGUIProblema());
                    prob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    prob.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error al afegir problema \n Revisa el FEN \n Revisa que no existeixi un problema igual \n");
                }



            }
        });
        tornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame registrarP = frame.getInstance();
                GUISeleccionarAfegirProblema prob2 = new GUISeleccionarAfegirProblema();

                registrarP.setContentPane(prob2.getMySeleccionarAfegirProblema());
                registrarP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registrarP.setVisible(true);
            }
        });
    }

    public JPanel getMyRProblema() {
        return MyRProblema;
    }
}
