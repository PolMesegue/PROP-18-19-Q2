package presentacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
ImageIcon kek = new ImageIcon(this.getClass().getResource("/icons8-bishop-40(1).png"));
                Button02.setIcon(kek);

  if (ctrlP.turnoMaquina(x,y,z,c)) {
  if (ctrP.mourePeca(x,y,0,2)) {
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
    private JButton Button23;
    private JButton Button24;
    private JButton Button25;
    private JButton Button26;
    private JButton Button27;
    private JButton Button33;
    private JButton Button34;
    private JButton Button35;
    private JButton Button36;
    private JButton Button37;
    private JButton Button43;
    private JButton Button44;
    private JButton Button45;
    private JButton Button46;
    private JButton Button47;
    private JButton Button53;
    private JButton Button54;
    private JButton Button55;
    private JButton Button56;
    private JButton Button57;
    private JButton Button62;
    private JButton Button63;
    private JButton Button64;
    private JButton Button65;
    private JButton Button66;
    private JButton Button67;
    private JButton Button73;
    private JButton Button74;
    private JButton Button75;
    private JButton Button76;
    private JButton Button77;
    private Boolean first;
    private Icon ico;
    private JButton temp;
    private JButton b;
    private Color colour;
    private int x, y;
    private ArrayList<Integer> movimentMaquina;
    private CtrlPresentacio ctrlP  = new CtrlPresentacio();
    private JButton[] matriu;

    public GUITaulell() {
        first = true;

        for(int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                matriu[x][y] = Button00;
            }
        }



        Button00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = (JButton)e.getSource();
                if (first) {
                    if (b.getIcon() != null) {
                        x = 0;
                        y = 0;
                        colour = b.getBackground();
                        b.setBackground(Color.CYAN);

                        ico = b.getIcon();
                        first = false;
                        temp = (JButton)e.getSource();
                    }
                }

                else {
                    if (temp != b) {

                        b.setIcon(ico);

                        temp.setIcon(null);
                        temp.setBackground(colour);
                        first = true;
                    }
                    else {

                      //  ctrlP.moure(x,y,0,0);

                        temp.setBackground(colour);
                        first = true;






                    }


                }
            }
        });

        Button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = (JButton)e.getSource();
                if (first) {
                    if (b.getIcon() != null) {

                        colour = b.getBackground();
                        b.setBackground(Color.CYAN);

                        ico = b.getIcon();
                        first = false;
                        temp = (JButton)e.getSource();
                    }
                }

                else {
                    if (temp != b) {

                        b.setIcon(ico);

                        temp.setIcon(null);
                        temp.setBackground(colour);
                        first = true;
                    }
                    else {

                        temp.setBackground(colour);
                        first = true;

                    }


                }
            }
        });
        Button01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = (JButton)e.getSource();
                if (first) {
                    if (b.getIcon() != null) {

                        colour = b.getBackground();
                        b.setBackground(Color.CYAN);

                        ico = b.getIcon();
                        first = false;
                        temp = (JButton)e.getSource();
                    }
                }

                else {
                    if (temp != b) {

                        b.setIcon(ico);

                        temp.setIcon(null);
                        temp.setBackground(colour);
                        first = true;
                    }
                    else {

                        temp.setBackground(colour);
                        first = true;

                        movimentMaquina.set(0,0);
                        movimentMaquina.set(1,0);
                        movimentMaquina.set(2,0);
                        movimentMaquina.set(3,1);

                        mourePecaMaquina(movimentMaquina);

                    }


                }
            }
        });
    }

    private void mourePecaMaquina(ArrayList<Integer> moviment) {

        Integer xOrg = moviment.get(0);
        Integer yOrg = moviment.get(1);
        Integer xDest = moviment.get(2);
        Integer yDest = moviment.get(3);




    }






    public JPanel getMyTaulell() {
        return MyTaulell;
    }



}

