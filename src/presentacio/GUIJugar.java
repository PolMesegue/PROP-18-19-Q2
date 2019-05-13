package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIJugar {
    private JPanel MyJugar;
    private JButton crearPartidaButton;
    private JButton jugarButton;


    public GUIJugar() {
        crearPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame registrarP = frame.getInstance();

                RegistrarPartida registrarP1 = new RegistrarPartida();

                registrarP.setContentPane(registrarP1.getMyRegistrarPartida());
                registrarP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registrarP.setSize(250,250);
                registrarP.setVisible(true);


        }
        });
    }

    public JPanel getMyJugar() { return MyJugar;}
}
