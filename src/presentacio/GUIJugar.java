package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIJugar {
    private JPanel MyJugar;
    private JButton crearPartidaButton;
    private JButton jugarButton;
    private JButton tornarButton;
    private JButton esborrarPartidaButton;
    private JButton MvsMButton;


    public GUIJugar() {
        crearPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame registrarP = frame.getInstance();

                RegistrarPartida registrarP1 = new RegistrarPartida();

                registrarP.setContentPane(registrarP1.getMyRegistrarPartida());
                registrarP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                registrarP.setVisible(true);


        }
        });
        tornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame main = frame.getInstance();
                main.setContentPane(new GUIMain().getMyGUIMain());
                main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                main.setVisible(true);
            }
        });
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame seleccionarP = frame.getInstance();

                GUISeleccionarPartida seleccionarP1 = new GUISeleccionarPartida();

                seleccionarP.setContentPane(seleccionarP1.getMySeleccionarPartida());
                seleccionarP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               // seleccionarP.setBounds(250,100,725,600);

                seleccionarP.setVisible(true);



/*


                */


            }
        });
        esborrarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame esborrar = frame.getInstance();
                GUIEsborrarPartida part = new GUIEsborrarPartida();

                esborrar.setContentPane(part.getMyGUIEsborrarPartida());
                esborrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                esborrar.setVisible(true);

            }
        });

        MvsMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame mvm = frame.getInstance();
                GUIMvsM part = new GUIMvsM();

                mvm.setContentPane(part.getMyGUIMvsM());
                mvm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                mvm.setVisible(true);


            }
        });
    }

    public JPanel getMyJugar() { return MyJugar;}
}
