package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIUsuari {
    private JPanel MyGUIUsuari;
    private JButton registrarUsuariButton;
    private JButton consultarUsuariButton;
    private JButton esborrarUsuariButton;
    private JButton modificarUsuariButton;

    public GUIUsuari() {

        registrarUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        consultarUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"kek2");
            }
        });

        esborrarUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyGUIUsuari.setVisible(false);

            }
        });
        modificarUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"kek4");
            }
        });


    }

    public JPanel getMyGUIUsuari() {
        return MyGUIUsuari;
    }
}
