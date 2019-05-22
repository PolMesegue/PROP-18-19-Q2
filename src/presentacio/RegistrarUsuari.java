package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarUsuari {
    private JTextField textField1;
    private JButton confirmarButton;
    private JPanel MyRegistrar;
    private JButton tornarButton;
    private CtrlPresentacio ctrlP = CtrlPresentacio.getInstance();


    public RegistrarUsuari() {
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String aux = textField1.getText();
                ctrlP.afegirUsuari(textField1.getText());

                JOptionPane.showMessageDialog(null,"Afegit correctament");

                frame user = frame.getInstance();

                GUIUsuari user1 = new GUIUsuari();

                user.setContentPane(user1.getMyGUIUsuari());
                user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                user.setVisible(true);
            }
        });
        tornarButton.addActionListener(new ActionListener() {
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

    public JPanel getMyRegistrar() {
        return MyRegistrar;
    }
}

