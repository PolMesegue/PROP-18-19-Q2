package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarPartida {
    private JPanel MyRegistrarPartida;
    private JButton acceptarButton;
    private JButton tornarButton;
    private JScrollPane AtackPane;
    private JScrollPane DefPane;
    private JScrollPane ProbPane;
    private JList list1;
    private JList list2;
    private JList list3;
    private CtrlPresentacio ctrlP = new CtrlPresentacio();






    public RegistrarPartida() {

        /*
        DefaultListModel dlm1 = new DefaultListModel();

        for (int i = o; i < ctrlP.numUsers; ++i) {
            dlm1.addElement(ctrlP.getUser(i));
        }
        list1.setModel(dlm1);
        */

        acceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //  ctrlP.afegirPartida(list1.getSelectedValue(),list2.getSelectedValue(),list3.getSelectedValue());

                        JOptionPane.showMessageDialog(null,"Afegit correctament");

                frame jugar = frame.getInstance();

                GUIJugar jugar1 = new GUIJugar();

                jugar.setContentPane(jugar1.getMyJugar());
                jugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jugar.setSize(250,250);
                jugar.setVisible(true);


            }
        });
        tornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame jugar = frame.getInstance();

                GUIJugar jugar1 = new GUIJugar();

                jugar.setContentPane(jugar1.getMyJugar());
                jugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jugar.setBounds(500,300,250,250);
                jugar.setVisible(true);
            }
        });
    }

    public JPanel getMyRegistrarPartida() {
        return MyRegistrarPartida;
    }
}
