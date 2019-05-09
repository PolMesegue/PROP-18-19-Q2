package presentacio;

import javax.swing.*;
import domini.Ctrl_Domini;


import java.util.Collection;
public class CtrlPresentacio {

    private Ctrl_Domini ctrldom = new Ctrl_Domini();


    public void afegirUsuari(String nom){

    }



    public static void main(String[] args){
        CtrlPresentacio CtrlP = new CtrlPresentacio();

        frame main = frame.getInstance();
        main.setContentPane(new GUIMain().getMyGUIMain());
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setBounds(500,300,250,250);

        main.setVisible(true);


    }

}
