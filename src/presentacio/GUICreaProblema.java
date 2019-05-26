package presentacio;

import domini.Torre;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUICreaProblema {
    private JPanel MyTaulell;
    private JButton Button10;
    private JButton Button30;
    private JButton Button50;
    private JButton Button70;
    private JButton Button01;
    private JButton Button21;
    private JButton Button41;
    private JButton Button61;
    private JButton Button72;
    private JButton Button52;
    private JButton Button12;
    private JButton Button03;
    private JButton Button23;
    private JButton Button43;
    private JButton Button63;
    private JButton Button74;
    private JButton Button54;
    private JButton Button34;
    private JButton Button14;
    private JButton Button05;
    private JButton Button25;
    private JButton Button45;
    private JButton Button65;
    private JButton Button76;
    private JButton Button56;
    private JButton Button36;
    private JButton Button16;
    private JButton Button07;
    private JButton Button27;
    private JButton Button47;
    private JButton Button67;
    private JButton Button00;
    private JButton Button20;
    private JButton Button40;
    private JButton Button60;
    private JButton Button71;
    private JButton Button51;
    private JButton Button31;
    private JButton Button11;
    private JButton Button02;
    private JButton Button22;
    private JButton Button42;
    private JButton Button62;
    private JButton Button73;
    private JButton Button53;
    private JButton Button33;
    private JButton Button13;
    private JButton Button04;
    private JButton Button24;
    private JButton Button44;
    private JButton Button64;
    private JButton Button75;
    private JButton Button35;
    private JButton Button15;
    private JButton Button06;
    private JButton Button26;
    private JButton Button46;
    private JButton Button66;
    private JButton Button77;
    private JButton Button57;
    private JButton Button37;
    private JButton Button17;
    private JButton Button32;
    private JButton Button55;
    private JButton sortirButton;
    private JButton ButtonPeoBlanc;
    private JButton ButtonAlfilBlanc;
    private JButton ButtonBasura;
    private JButton ButtonReiBlanc;
    private JButton ButtonReinaBlanca;
    private JButton ButtonTorreBlanca;
    private JButton ButtonCavallBlanc;
    private JButton ButtonPeoNegre;
    private JButton ButtonAlfilNegre;
    private JButton ButtonCavallNegre;
    private JButton ButtonTorreNegre;
    private JButton ButtonReinaNegre;
    private JButton ButtonReiNegre;
    private JTextField textField1;

    private JButton[][] matriu = new JButton[8][8];
    private JButton[] selector = new JButton[12];

    private JPanel MyPanel;

    private  JButton bSelec;
    private JButton bMat;

    private ImageIcon AlfilB = new ImageIcon(this.getClass().getResource("/icons/icons8-bishop-40.png"));
    private ImageIcon ReyB = new ImageIcon(this.getClass().getResource("/icons/icons8-king-40.png"));
    private ImageIcon CavallB = new ImageIcon(this.getClass().getResource("/icons/icons8-knight-40.png"));
    private  ImageIcon PeoB = new ImageIcon(this.getClass().getResource("/icons/icons8-pawn-40.png"));
    private  ImageIcon ReinaB = new ImageIcon(this.getClass().getResource("/icons/icons8-queen-40.png"));
    private  ImageIcon TorreB = new ImageIcon(this.getClass().getResource("/icons/icons8-rook-40.png"));

    private  ImageIcon AlfilN = new ImageIcon(this.getClass().getResource("/icons/icons8-bishop-48.png"));
    private  ImageIcon ReyN = new ImageIcon(this.getClass().getResource("/icons/icons8-king-48.png"));
    private  ImageIcon CavallN = new ImageIcon(this.getClass().getResource("/icons/icons8-knight-48.png"));
    private  ImageIcon PeoN = new ImageIcon(this.getClass().getResource("/icons/icons8-pawn-48.png"));
    private  ImageIcon ReinaN = new ImageIcon(this.getClass().getResource("/icons/icons8-queen-48.png"));
    private  ImageIcon TorreN = new ImageIcon(this.getClass().getResource("/icons/icons8-rook-48.png"));
    // 0 1 2 3 4 5 peces blancas: peon alfil cavall torre reina rey
    // 6 7 8 9 10 11 peces negres: peon alfil cavall torre reina rey

    private CtrlPresentacio ctrlP = CtrlPresentacio.getInstance();

    private boolean basuraPressed;
    private boolean selectorPressed;

    private Icon icon = null;

    public GUICreaProblema() {
        iniciaMatriu();
        iniciaSelector();




        for(int f = 0; f < 12; ++f) {
            selector[f].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bSelec = (JButton)e.getSource();

                    netejaSelector();
                    bSelec.setBackground(Color.CYAN);
                    icon = bSelec.getIcon();

                }
            });
        }

        for(int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {

                matriu[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bMat = (JButton) e.getSource();

                        bMat.setIcon(icon);

                    }
                });
            }
        }

        ButtonBasura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                netejaSelector();
                ButtonBasura.setBackground(Color.cyan);
                icon = null;
            }
        });


        sortirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Integer> peces = llegeixTauler();
                int mat = Integer.parseInt(textField1.getText());
               if (ctrlP.addTaulell(peces,mat)) {

                   JOptionPane.showMessageDialog(null, "Afegit correctament");


                   JFrame f1 = (JFrame) SwingUtilities.windowForComponent(MyTaulell);
                   f1.dispose();
               }
               else {
                   JOptionPane.showMessageDialog(null, "El taulell no és correcte o no te solució");
               }
            }
        });
    }

    private ArrayList<Integer> llegeixTauler() {


        ArrayList<Integer> peces = new ArrayList<>();

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {

                if (matriu[i][j].getIcon() != null) {
                    peces.add(i);
                    peces.add(j);

                    if (matriu[i][j].getIcon() == PeoB) peces.add(0);
                    else if (matriu[i][j].getIcon() == AlfilB) peces.add(1);
                    else if (matriu[i][j].getIcon() == CavallB) peces.add(2);
                    else if (matriu[i][j].getIcon() == TorreB) peces.add(3);
                    else if (matriu[i][j].getIcon() == ReinaB) peces.add(4);
                    else if (matriu[i][j].getIcon() == ReyB) peces.add(5);

                    else if (matriu[i][j].getIcon() == PeoN) peces.add(6);
                    else if (matriu[i][j].getIcon() == AlfilN) peces.add(7);
                    else if (matriu[i][j].getIcon() == CavallN) peces.add(8);
                    else if (matriu[i][j].getIcon() == TorreN) peces.add(9);
                    else if (matriu[i][j].getIcon() == ReinaN) peces.add(10);
                    else if (matriu[i][j].getIcon() == ReyN) peces.add(11);


                }

            }
        }

        return peces;

    }

    private void netejaSelector() {

        for(int i = 0; i < 13; ++i) {

            selector[0].setBackground(new Color(222, 184, 135));
            selector[1].setBackground( new Color(139, 69, 19));
            selector[2].setBackground(new Color(222, 184, 135));
            selector[3].setBackground( new Color(139, 69, 19));
            selector[4].setBackground(new Color(222, 184, 135));
            selector[5].setBackground( new Color(139, 69, 19));

            selector[6].setBackground( new Color(139, 69, 19));
            selector[7].setBackground(new Color(222, 184, 135));
            selector[8].setBackground( new Color(139, 69, 19));
            selector[9].setBackground(new Color(222, 184, 135));
            selector[10].setBackground( new Color(139, 69, 19));
            selector[11].setBackground(new Color(222, 184, 135));

            ButtonBasura.setBackground(Color.white);

        }

    }


    private void iniciaSelector() {
        selector[0] = ButtonPeoBlanc;
        selector[0].setIcon(PeoB);

        selector[1] = ButtonAlfilBlanc;
        selector[1].setIcon(AlfilB);

        selector[2] = ButtonCavallBlanc;
        selector[2].setIcon(CavallB);

        selector[3] = ButtonTorreBlanca;
        selector[3].setIcon(TorreB);

        selector[4] = ButtonReinaBlanca;
        selector[4].setIcon(ReinaB);

        selector[5] = ButtonReiBlanc;
        selector[5].setIcon(ReyB);

        selector[6] = ButtonPeoNegre;
        selector[6].setIcon(PeoN);

        selector[7] = ButtonAlfilNegre;
        selector[7].setIcon(AlfilN);

        selector[8] = ButtonCavallNegre;
        selector[8].setIcon(CavallN);

        selector[9] = ButtonTorreNegre;
        selector[9].setIcon(TorreN);

        selector[10] = ButtonReinaNegre;
        selector[10].setIcon(ReinaN);

        selector[11] = ButtonReiNegre;
        selector[11].setIcon(ReyN);





    }

    private void iniciaMatriu() {

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
    }

    public JPanel getMyTaulell() {
        return MyTaulell;
    }
}
