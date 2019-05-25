package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarPartida {
    private JPanel MyRegistrarPartida;
    private JButton acceptarButton;
    private JButton tornarButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton veureTaulellButton;
    private CtrlPresentacio CtrlP = CtrlPresentacio.getInstance();
    private JFrame tauler;

    public RegistrarPartida() {

        for(int i=0; i<CtrlP.consultar_usuaris().size();i++){
            String aux= CtrlP.consultar_usuaris().get(i);
            comboBox1.addItem(aux);
        }
        for(int i=0; i<CtrlP.consultar_usuaris().size();i++){
            String aux= CtrlP.consultar_usuaris().get(i);
            comboBox2.addItem(aux);
        }
        for(int i=0; i<CtrlP.consultar_Problemas().size();i++){
            String aux= CtrlP.consultar_Problemas().get(i);
            comboBox3.addItem(aux);
        }

        acceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tauler.setVisible(false);
                CtrlP.crearPartida((String)comboBox1.getSelectedItem(),(String)comboBox2.getSelectedItem(),(String)comboBox3.getSelectedItem());

                JOptionPane.showMessageDialog(null,"Afegit correctament");

                frame jugar = frame.getInstance();

                GUIJugar jugar1 = new GUIJugar();

                jugar.setContentPane(jugar1.getMyJugar());
                jugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

                jugar.setVisible(true);
            }
        });
        veureTaulellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tauler = new JFrame();
                GUIVeureTauler tauler2 = new GUIVeureTauler((String) comboBox3.getSelectedItem());
                tauler.setBounds(250,100,525,500);
                tauler.setContentPane(tauler2.getMyTaulellPreview());
                tauler.setVisible(true);

            }
        });
    }

    public JPanel getMyRegistrarPartida() {
        return MyRegistrarPartida;
    }
}
