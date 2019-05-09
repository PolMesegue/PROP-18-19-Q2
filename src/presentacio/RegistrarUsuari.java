package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarUsuari {
    private JTextField textField1;
    private JButton confirmarButton;
    private CtrlPresentacio ctrlP = new CtrlPresentacio();


    public RegistrarUsuari() {
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ctrlP.afegirUsuari(textField1.getText());
                
            }
        });
    }
}

