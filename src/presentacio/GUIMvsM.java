package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMvsM {
    private JComboBox comboBoxAtac;
    private JComboBox comboBoxDef;
    private JComboBox comboBox5;
    private JButton tornarButton;
    private JPanel MyGUIMvsM;
    private JButton jugarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton veureTaulell1Button;
    private JButton veureTaulell2Button;
    private JButton veureTaulell3Button;
    private JButton veureTaulell4Button;
    private JButton veureTaulell5Button;
    private JFrame taulerCons = new JFrame();
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();

    private int guanyaAtac = 0;
    private int guanyaDef = 0;
    private boolean guanyPrimer, guanyaSegon,guanyaTercer,guanyaQuart,guanyaCinque;


    public GUIMvsM() {

        comboBoxAtac.addItem("M1");
        comboBoxDef.addItem("M1");
        comboBoxAtac.addItem("M2");
        comboBoxDef.addItem("M2");

        comboBox1.addItem(null);
        comboBox2.addItem(null);
        comboBox3.addItem(null);
        comboBox4.addItem(null);
        comboBox5.addItem(null);

        for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
            String aux= CtrlP.consultar_Problemas().get(i);
            comboBox1.addItem(aux);
        }
        for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
            String aux= CtrlP.consultar_Problemas().get(i);
            comboBox2.addItem(aux);
        }

        for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
            String aux= CtrlP.consultar_Problemas().get(i);
            comboBox3.addItem(aux);
        }
        for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
            String aux= CtrlP.consultar_Problemas().get(i);
            comboBox4.addItem(aux);
        }
        for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
            String aux= CtrlP.consultar_Problemas().get(i);
            comboBox5.addItem(aux);
        }


        tornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame jugar = frame.getInstance();

                GUIJugar jugar1 = new GUIJugar();

                jugar.setContentPane(jugar1.getMyJugar());
                jugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                jugar.setVisible(true);
            }
        });

        veureTaulell1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox1.getSelectedItem() != null) {
                    GUIVeureTauler tauler2 = new GUIVeureTauler((String) comboBox1.getSelectedItem());
                    taulerCons.setBounds(250, 100, 525, 500);
                    taulerCons.setContentPane(tauler2.getMyTaulellPreview());

                    taulerCons.setVisible(true);
                }


            }
        });

        veureTaulell2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox2.getSelectedItem() != null) {
                    GUIVeureTauler tauler2 = new GUIVeureTauler((String) comboBox2.getSelectedItem());
                    taulerCons.setBounds(250, 100, 525, 500);
                    taulerCons.setContentPane(tauler2.getMyTaulellPreview());

                    taulerCons.setVisible(true);
                }
            }
        });

        veureTaulell3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox3.getSelectedItem() != null) {
                    GUIVeureTauler tauler2 = new GUIVeureTauler((String) comboBox3.getSelectedItem());
                    taulerCons.setBounds(250, 100, 525, 500);
                    taulerCons.setContentPane(tauler2.getMyTaulellPreview());

                    taulerCons.setVisible(true);
                }

            }
        });
        veureTaulell4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox4.getSelectedItem() != null) {
                    GUIVeureTauler tauler2 = new GUIVeureTauler((String) comboBox4.getSelectedItem());
                    taulerCons.setBounds(250, 100, 525, 500);
                    taulerCons.setContentPane(tauler2.getMyTaulellPreview());

                    taulerCons.setVisible(true);
                }
            }
        });
        veureTaulell5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox5.getSelectedItem() != null) {
                    GUIVeureTauler tauler2 = new GUIVeureTauler((String) comboBox5.getSelectedItem());
                    taulerCons.setBounds(250, 100, 525, 500);
                    taulerCons.setContentPane(tauler2.getMyTaulellPreview());

                    taulerCons.setVisible(true);
                }
            }
        });
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox1.getSelectedItem() != null) {

                    if (CtrlP.jugarMVM((String) comboBoxAtac.getSelectedItem(), (String) comboBoxDef.getSelectedItem(),(String) comboBox1.getSelectedItem())) {
                        ++guanyaAtac;
                        guanyPrimer = true;
                    }
                    else {
                        ++guanyaDef;
                        guanyPrimer = false;
                    }

                }
                if (comboBox2.getSelectedItem() != null) {
                    if (CtrlP.jugarMVM((String) comboBoxAtac.getSelectedItem(), (String) comboBoxDef.getSelectedItem(),(String) comboBox2.getSelectedItem())) {
                        ++guanyaAtac;
                        guanyaSegon = true;
                    }
                    else {
                        ++guanyaDef;
                        guanyaSegon = false;
                    }


                }
                if (comboBox3.getSelectedItem() != null) {
                    if (CtrlP.jugarMVM((String) comboBoxAtac.getSelectedItem(), (String) comboBoxDef.getSelectedItem(),(String) comboBox3.getSelectedItem())) {
                        ++guanyaAtac;
                        guanyaTercer = true;

                    }
                    else {
                        ++guanyaDef;
                        guanyaTercer = false;

                    }

                }
                if (comboBox4.getSelectedItem() != null) {
                    if (CtrlP.jugarMVM((String) comboBoxAtac.getSelectedItem(), (String) comboBoxDef.getSelectedItem(),(String) comboBox4.getSelectedItem())) {
                        ++guanyaAtac;
                        guanyaQuart = true;

                    }
                    else {
                        ++guanyaDef;
                        guanyaQuart = false;

                    }

                }

                if (comboBox5.getSelectedItem() != null) {
                    if (CtrlP.jugarMVM((String) comboBoxAtac.getSelectedItem(), (String) comboBoxDef.getSelectedItem(),(String) comboBox5.getSelectedItem())) {
                        ++guanyaAtac;
                        guanyaCinque = true;


                    }
                    else {
                        ++guanyaDef;
                        guanyaCinque = false;

                    }


                }

                JOptionPane.showMessageDialog(null, "Resultats:\n Atacant: " + guanyaDef + "\n Defensor " + guanyaAtac + "\n");

                guanyaDef = 0;
                guanyaAtac = 0;


            }
        });
    }




    public JPanel getMyGUIMvsM() {
        return MyGUIMvsM;
    }
}


