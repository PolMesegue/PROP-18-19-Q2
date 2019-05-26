package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarProblema {
    private JButton tornarEnrereButton;
    private JPanel MyConsultarProblema;
    private JComboBox comboBox1;
    private JButton veureTaulellButton;
    private JButton modificarTaulellButton;
    private JButton refrescaLlistaButton;
    private JButton esborrarTaulellButton;
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();
    private JFrame taulerCons = new JFrame();;
    private JFrame taulerMod = new JFrame();;

    public ConsultarProblema() {

        for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
            String aux= CtrlP.consultar_Problemas().get(i);
            comboBox1.addItem(aux);
        }

        tornarEnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taulerCons.setVisible(false);
                taulerMod.setVisible(false);
                frame prob = frame.getInstance();

                GUIProblema prob1 = new GUIProblema();

                prob.setContentPane(prob1.getMyGUIProblema());
                prob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                prob.setVisible(true);
            }
        });
        veureTaulellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GUIVeureTauler tauler2 = new GUIVeureTauler((String) comboBox1.getSelectedItem());
                taulerCons.setBounds(250,100,525,500);
                taulerCons.setContentPane(tauler2.getMyTaulellPreview());
                taulerCons.setVisible(true);
            }
        });
        modificarTaulellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GUICreaProblema tauler2 = new GUICreaProblema((String) comboBox1.getSelectedItem());

                taulerMod.setBounds(250,100,700,500);
                taulerMod.setContentPane(tauler2.getMyTaulell());
                taulerMod.setVisible(true);



            }
        });
        refrescaLlistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox1.removeAllItems();
                for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
                    String aux= CtrlP.consultar_Problemas().get(i);
                    comboBox1.addItem(aux);
                }
            }
        });
        
        esborrarTaulellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlP.delProblema((String)comboBox1.getSelectedItem());
                comboBox1.removeAllItems();
                for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
                    String aux= CtrlP.consultar_Problemas().get(i);
                    comboBox1.addItem(aux);
                }
            }
        });
    }


    public JPanel getMyConsultarProblema() {
        return MyConsultarProblema;
    }
}
