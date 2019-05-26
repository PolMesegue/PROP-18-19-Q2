package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarUsuari {
    private JComboBox comboBox1;
    private JPanel MyConsultarUsuari;
    private JButton tornarEnrereButton;
    private JButton esborrarUsuariButton;
    private JButton modificarUsuariButton;
    private JButton refrescaLlistaButton;
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();

    private JFrame modi = new JFrame();

    public ConsultarUsuari() {

        for(int i=0; i<CtrlP.consultar_usuaris().size();i++){
            String aux= CtrlP.consultar_usuaris().get(i);

            if (!aux.equals("M1") && !aux.equals("M2"))comboBox1.addItem(aux);
        }
        tornarEnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame user = frame.getInstance();

                GUIUsuari user1 = new GUIUsuari();

                user.setContentPane(user1.getMyGUIUsuari());
                user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                user.setVisible(true);

            }
        });
        esborrarUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modi.setVisible(false);
                CtrlP.delUsuari((String)comboBox1.getSelectedItem());
                comboBox1.removeAllItems();
                for(int i=0; i<CtrlP.consultar_usuaris().size();i++){
                    String aux= CtrlP.consultar_usuaris().get(i);
                    comboBox1.addItem(aux);
                }
            }
        });


    }

    public JPanel getMyConsultarUsuari() {
        return MyConsultarUsuari;
    }
}
