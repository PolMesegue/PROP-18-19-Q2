package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class GUIEsborrarPartida {
    private JComboBox comboBox1;
    private JPanel MyGUIEsborrarPartida;
    private JButton esborrarButton;
    private JButton tornarEnreraButton;
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();


    public GUIEsborrarPartida() {

        for(int i=0; i<CtrlP.consultar_Partidas().size();i++){
            Timestamp aux= CtrlP.consultar_Partidas().get(i);
            comboBox1.addItem(aux);
        }

        esborrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlP.deletePartida((Timestamp)comboBox1.getSelectedItem());
                comboBox1.removeAllItems();

                for(int i=0; i<CtrlP.consultar_Partidas().size();i++){
                    Timestamp aux= CtrlP.consultar_Partidas().get(i);
                    comboBox1.addItem(aux);
                }

            }
        });

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
    }

    public JPanel getMyGUIEsborrarPartida() {
        return MyGUIEsborrarPartida;
    }
}
