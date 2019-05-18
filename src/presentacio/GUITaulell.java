package presentacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
ImageIcon kek = new ImageIcon(this.getClass().getResource("/icons8-bishop-40(1).png"));
                Button02.setIcon(kek);
 */
public class GUITaulell {
    private JPanel MyTaulell;
    private JButton Button00;
    private JButton Button02;
    private JButton Button10;
    private JButton Button20;
    private JButton Button30;
    private JButton Button40;
    private JButton Button50;
    private JButton Button60;
    private JButton Button70;
    private JButton Button01;
    private JButton Button11;
    private JButton Button21;
    private JButton Button31;
    private JButton Button41;
    private JButton Button51;
    private JButton Button61;
    private JButton Button71;
    private JButton Button12;
    private JButton Button22;
    private JButton Button32;
    private JButton Button42;
    private JButton Button52;
    private JButton Button62;
    private JButton Button72;
    private JButton Button03;
    private JButton Button04;
    private JButton Button05;
    private JButton Button06;
    private JButton Button07;
    private JButton Button13;
    private JButton Button14;
    private JButton Button15;
    private JButton Button16;
    private JButton Button17;
    private Boolean first;
    private Icon lol;
    private JButton temp;

    public GUITaulell() {
        first = true;

        Button00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (first) {
                    lol = Button00.getIcon();

                    first = false;
                    temp = Button00;
                }
                else {

                    Button00.setIcon(lol);

                    first = true;
                }
            }
        });
        Button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (first) {
                    lol = Button02.getIcon();

                    first = false;
                }
                else {

                    Button02.setIcon(lol);
                    temp.setIcon(null);
                    first = true;
                }

            }
        });
    }






    public JPanel getMyTaulell() {
        return MyTaulell;
    }
}

