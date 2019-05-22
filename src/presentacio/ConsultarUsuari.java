package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarUsuari {
    private JComboBox comboBox1;
    private JPanel MyConsultarUsuari;
    private JButton tornarEnrereButton;
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();

    public ConsultarUsuari() {

        for(int i=0; i<CtrlP.consultar_usuaris().size();i++){
            String aux= CtrlP.consultar_usuaris().get(i);
            comboBox1.addItem(aux);
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
    }

    public JPanel getMyConsultarUsuari() {
        return MyConsultarUsuari;
    }
}
