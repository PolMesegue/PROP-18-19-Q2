package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISeleccionarAfegirProblema {
    private JButton manualButton;
    private JPanel MySeleccionarAfegirProblema;
    private JButton interactiuButton;
    private JButton tornarEnrereButton;
    private JFrame interact = new JFrame();

    public GUISeleccionarAfegirProblema() {
        manualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame registrarP = frame.getInstance();
                RegistrarProblema prob2 = new RegistrarProblema();

                registrarP.setContentPane(prob2.getMyRProblema());
                registrarP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registrarP.setVisible(true);

            }
        });

        tornarEnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame prob = frame.getInstance();

                GUIProblema prob1 = new GUIProblema();

                prob.setContentPane(prob1.getMyGUIProblema());
                prob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                prob.setVisible(true);

            }
        });
        interactiuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                GUICreaProblema prob1 = new GUICreaProblema();
                interact.setBounds(250,100,700,500);
                interact.setContentPane(prob1.getMyTaulell());

                interact.setVisible(true);




            }
        });
    }




    public JPanel getMySeleccionarAfegirProblema() {
        return MySeleccionarAfegirProblema;
    }
}
