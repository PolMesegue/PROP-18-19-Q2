package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarProblema {
    private JButton tornarEnrereButton;
    private JPanel MyConsultarProblema;
    private JComboBox comboBox1;
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();



    public ConsultarProblema() {

        for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
            String aux= CtrlP.consultar_Problemas().get(i);
            comboBox1.addItem(aux);
        }

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
    }


    public JPanel getMyConsultarProblema() {
        return MyConsultarProblema;
    }
}
