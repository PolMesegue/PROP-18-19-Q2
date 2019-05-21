package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISeleccionarPartida {
    private JComboBox comboBox1;
    private JPanel MySeleccionarPartida;
    private JButton tornarEnreraButton;
    private JButton jugarButton;
    private CtrlPresentacio CtrlP = new CtrlPresentacio();


    public GUISeleccionarPartida() {
        comboBox1.addItem(CtrlP.consultar_Partidas());


        tornarEnreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   CtrlP.selecionar_Partida(comboBox1.getSelectedItem());
            }
        });
    }

    public JPanel getMySeleccionarPartida() {

        return MySeleccionarPartida;
    }
}
