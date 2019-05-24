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
    private JLabel nMov;
    private JLabel nMat;
    private JButton sortirButton;
    private Boolean first;
    private Icon ico;
    private JButton temp;
    private JButton b;
    private Color colour;
    private int xO, yO, xD, yD;
    private int k, l;
    private ArrayList<Integer> movimentMaquina;
    private CtrlPresentacio ctrlP = CtrlPresentacio.getInstance();
    private JButton[][] matriu = new JButton[8][8];


    public GUITaulell() {

        first = true;
        matriu = iniciaMatriu(matriu);

        ImageIcon AlfilB = new ImageIcon(this.getClass().getResource("/icons/icons8-bishop-40.png"));
        ImageIcon ReyB = new ImageIcon(this.getClass().getResource("/icons/icons8-king-40.png"));
        ImageIcon CavallB = new ImageIcon(this.getClass().getResource("/icons/icons8-knight-40.png"));
        ImageIcon PeoB = new ImageIcon(this.getClass().getResource("/icons/icons8-pawn-40.png"));
        ImageIcon ReinaB = new ImageIcon(this.getClass().getResource("/icons/icons8-queen-40.png"));
        ImageIcon TorreB = new ImageIcon(this.getClass().getResource("/icons/icons8-rook-40.png"));

        ImageIcon AlfilN = new ImageIcon(this.getClass().getResource("/icons/icons8-bishop-48.png"));
        ImageIcon ReyN = new ImageIcon(this.getClass().getResource("/icons/icons8-king-48.png"));
        ImageIcon CavallN = new ImageIcon(this.getClass().getResource("/icons/icons8-knight-48.png"));
        ImageIcon PeoN = new ImageIcon(this.getClass().getResource("/icons/icons8-pawn-48.png"));
        ImageIcon ReinaN = new ImageIcon(this.getClass().getResource("/icons/icons8-queen-48.png"));
        ImageIcon TorreN = new ImageIcon(this.getClass().getResource("/icons/icons8-rook-48.png"));
        // 0 1 2 3 4 5 peces blancas: peon alfil cavall torre reina rey
        // 6 7 8 9 10 11 peces negres: peon alfil cavall torre reina rey

        ArrayList<Integer> pecesTauler = ctrlP.get_pecas();
        for(int i=0;i<pecesTauler.size();i+=3){
            //blancas
            if(pecesTauler.get(i+2)==0){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(PeoB);
            }
            if(pecesTauler.get(i+2)==1){
               matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(AlfilB);
            }
            if(pecesTauler.get(i+2)==2){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(CavallB);
            }
            if(pecesTauler.get(i+2)==3){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(TorreB);
            }
            if(pecesTauler.get(i+2)==4){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(ReinaB);
            }
            if(pecesTauler.get(i+2)==5){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(ReyB);
            }
            //negres
            // 6 7 8 9 10 11 peces negres: peon alfil cavall torre reina rey
            if(pecesTauler.get(i+2)==6){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(PeoN);
            }
            if(pecesTauler.get(i+2)==7){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(AlfilN);
            }
            if(pecesTauler.get(i+2)==8){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(CavallN);
            }
            if(pecesTauler.get(i+2)==9){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(TorreN);
            }
            if(pecesTauler.get(i+2)==10){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(ReinaN);
            }
            if(pecesTauler.get(i+2)==11){
                matriu[pecesTauler.get(i)][pecesTauler.get(i+1)].setIcon(ReyN);
            }
        }
        nMat.setText("3");
        nMov.setText("0");


        k = 1; l = 2;
        movimentMaquina = new ArrayList<>(4);

        for(int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {

                matriu[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        b = (JButton)e.getSource();
                        if (first) {
                            if (b.getIcon() != null) {
                                for (int q = 0; q < 8; ++q) {
                                    for (int w = 0; w < 8; ++w) {
                                        if (matriu[q][w] == b) {
                                            xO = q;
                                            yO = w;
                                        }
                                    }
                                }
                                //en marca els colors del moviments posibles de la peça
                                ArrayList<Integer> moviments= ctrlP.PosiblesMoviments(xO,yO);
                                for(int i=0;i<moviments.size();i+=2){
                                    matriu[moviments.get(i)][moviments.get(i+1)].setBackground(Color.GREEN);
                                }
                                ////////////////////////////////////
                                b.setBackground(Color.CYAN);

                                ico = b.getIcon();
                                first = false;
                                temp = (JButton)e.getSource();
                            }
                        }
                        else {
                            if (temp != b) {
                                for (int q = 0; q < 8; ++q) {
                                    for (int w = 0; w < 8; ++w) {
                                        if (matriu[q][w] == b) {
                                            xD = q;
                                            yD = w;
                                        }
                                    }
                                }
                                if (ctrlP.mourePeca(xO,yO, xD, yD)){

                                    b.setIcon(ico);

                                    temp.setIcon(null);

                                    first = true;
                                    nMov.setText(""+k);
                                    netejaTaulell();

                                    mourePecaMaquina(ctrlP.turnMaquina());
                                    /*movimentMaquina.add(0, 0);
                                    movimentMaquina.add(1, k);
                                    movimentMaquina.add(2, 0);
                                    movimentMaquina.add(3, l);*/
                                    ++l;
                                    ++k;
                                    //mourePecaMaquina(movimentMaquina);
                                }
                            }
                            else {
                                netejaTaulell();
                                first = true;

                            }


                        }
                    }
                });

            }
        }

        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //loqueisgui Guardar

                frame jugar = frame.getInstance();

                GUIJugar jugar1 = new GUIJugar();

                jugar.setContentPane(jugar1.getMyJugar());
                jugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jugar.setBounds(300,200,600,400);
                jugar.setVisible(true);

            }
        });
    }



    private void mourePecaMaquina(ArrayList<Integer> moviment) {

        Integer xOrg = moviment.get(0);
        Integer yOrg = moviment.get(1);
        Integer xDest = moviment.get(2);
        Integer yDest = moviment.get(3);

        matriu[xDest][yDest].setIcon(matriu[xOrg][yOrg].getIcon());
        matriu[xOrg][yOrg].setIcon(null);


    }

    private void netejaTaulell() {

        for(int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {

                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0))
                    matriu[i][j].setBackground(new Color(222, 184, 135));
                else matriu[i][j].setBackground(new Color(139, 69, 19));
            }
        }
    }


    private JButton[][] iniciaMatriu(JButton[][] matriu) {

        matriu[0][0] = Button00;
        matriu[0][1] = Button01;
        matriu[0][2] = Button02;
        matriu[0][3] = Button03;
        matriu[0][4] = Button04;
        matriu[0][5] = Button05;
        matriu[0][6] = Button06;
        matriu[0][7] = Button07;

        matriu[1][0] = Button10;
        matriu[1][1] = Button11;
        matriu[1][2] = Button12;
        matriu[1][3] = Button13;
        matriu[1][4] = Button14;
        matriu[1][5] = Button15;
        matriu[1][6] = Button16;
        matriu[1][7] = Button17;

        matriu[2][0] = Button20;
        matriu[2][1] = Button21;
        matriu[2][2] = Button22;
        matriu[2][3] = Button23;
        matriu[2][4] = Button24;
        matriu[2][5] = Button25;
        matriu[2][6] = Button26;
        matriu[2][7] = Button27;

        matriu[3][0] = Button30;
        matriu[3][1] = Button31;
        matriu[3][2] = Button32;
        matriu[3][3] = Button33;
        matriu[3][4] = Button34;
        matriu[3][5] = Button35;
        matriu[3][6] = Button36;
        matriu[3][7] = Button37;

        matriu[4][0] = Button40;
        matriu[4][1] = Button41;
        matriu[4][2] = Button42;
        matriu[4][3] = Button43;
        matriu[4][4] = Button44;
        matriu[4][5] = Button45;
        matriu[4][6] = Button46;
        matriu[4][7] = Button47;

        matriu[5][0] = Button50;
        matriu[5][1] = Button51;
        matriu[5][2] = Button52;
        matriu[5][3] = Button53;
        matriu[5][4] = Button54;
        matriu[5][5] = Button55;
        matriu[5][6] = Button56;
        matriu[5][7] = Button57;

        matriu[6][0] = Button60;
        matriu[6][1] = Button61;
        matriu[6][2] = Button62;
        matriu[6][3] = Button63;
        matriu[6][4] = Button64;
        matriu[6][5] = Button65;
        matriu[6][6] = Button66;
        matriu[6][7] = Button67;

        matriu[7][0] = Button70;
        matriu[7][1] = Button71;
        matriu[7][2] = Button72;
        matriu[7][3] = Button73;
        matriu[7][4] = Button74;
        matriu[7][5] = Button75;
        matriu[7][6] = Button76;
        matriu[7][7] = Button77;


        return matriu;
    }





    public JPanel getMyTaulell() {
        return MyTaulell;
    }



}









/*



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



                    }


                }
            }
        });

         */