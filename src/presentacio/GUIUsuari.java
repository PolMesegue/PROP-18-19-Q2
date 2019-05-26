package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIUsuari {
    private JPanel MyGUIUsuari;
    private JButton registrarUsuariButton;
    private JButton consultarUsuariButton;
    private JButton CarregarUsuariButton;
    private JButton tornarEnrereButton;
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();

    public GUIUsuari(){

        registrarUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame registrar = frame.getInstance();
                RegistrarUsuari usuari2 = new RegistrarUsuari();

                registrar.setContentPane(usuari2.getMyRegistrar());
                registrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registrar.setVisible(true);


            }
        });

        consultarUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame consultar = frame.getInstance();
                ConsultarUsuari consultar2 = new ConsultarUsuari();

                consultar.setContentPane(consultar2.getMyConsultarUsuari());
                consultar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                consultar.setVisible(true);

            }
        });

        CarregarUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    if (CtrlP.CarregarUsuaris()) {
                        JOptionPane.showMessageDialog(null, "Usuaris afegits");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Error al Aafegir \n Almenys 1 usuari repetit \n Alguns usuaris poden no haver-se afegir");
                    }
                }catch (Exception B) {
                    B.printStackTrace();
                }
            }
        });


        tornarEnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame main = frame.getInstance();
                main.setContentPane(new GUIMain().getMyGUIMain());
                main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                main.setVisible(true);
            }
        });
    }

    public JPanel getMyGUIUsuari() {
        return MyGUIUsuari;
    }
}
