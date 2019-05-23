package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class GUISeleccionarPartida {
    private JComboBox comboBox1;
    private JPanel MySeleccionarPartida;
    private JButton tornarEnreraButton;
    private JButton jugarButton;
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();


    public GUISeleccionarPartida() {

        for(int i=0; i<CtrlP.consultar_Partidas().size();i++){
            Timestamp aux= CtrlP.consultar_Partidas().get(i);
            comboBox1.addItem(aux);
        }
        tornarEnreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame jugar = frame.getInstance();

                GUIJugar jugar1 = new GUIJugar();

                jugar.setContentPane(jugar1.getMyJugar());
                jugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                jugar.setVisible(true);

            }
        });
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CtrlP.selecionar_Partida((Timestamp)comboBox1.getSelectedItem());

                frame jugarP = frame.getInstance();

                GUITaulell jugarP1 = new GUITaulell();

                jugarP.setContentPane(jugarP1.getMyTaulell());
                jugarP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jugarP.setBounds(250,100,725,600);

                jugarP.setVisible(true);
            }
        });
    }

    public JPanel getMySeleccionarPartida() {

        return MySeleccionarPartida;
    }
}
