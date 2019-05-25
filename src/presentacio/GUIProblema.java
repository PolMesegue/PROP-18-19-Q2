package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIProblema {
    private JPanel MyGUIProblema;
    private JButton esborrarProblemaButton;
    private JButton consultarProblemaButton;
    private JButton afergirProblemaButton;
    private JButton CarregarProblemaButton;
    private JButton tornarEnrereButton;
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();

    public GUIProblema() {

        afergirProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame registrarP = frame.getInstance();
                GUISeleccionarAfegirProblema prob2 = new GUISeleccionarAfegirProblema();

                registrarP.setContentPane(prob2.getMySeleccionarAfegirProblema());
                registrarP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registrarP.setVisible(true);
            }
        });

        CarregarProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (CtrlP.CarregarProblemas()) {
                        JOptionPane.showMessageDialog(null, "Problemas afegits");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Almenys un FEN és incorrente \n Alguns problemes poden no haver-se afegit");

                    }
                }catch (Exception B) {
                    B.printStackTrace();
                }
            }
        });

        esborrarProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tornarEnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame main = frame.getInstance();
                main.setContentPane(new GUIMain().getMyGUIMain());
                main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                main.setVisible(true);
            }
        });
        consultarProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame consultarP = frame.getInstance();
                ConsultarProblema consultarP2 = new ConsultarProblema();

                consultarP.setContentPane(consultarP2.getMyConsultarProblema());
                consultarP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                consultarP.setVisible(true);



            }
        });
    }

    public JPanel getMyGUIProblema() {
        return MyGUIProblema;
    }


}
