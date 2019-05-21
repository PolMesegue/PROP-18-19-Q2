package presentacio;

import javax.swing.*;
import domini.Ctrl_Domini;

import java.sql.Timestamp;
import java.util.*;

public class CtrlPresentacio {

    private Ctrl_Domini ctrldom = new Ctrl_Domini();


    public void afegirUsuari(String nom){
        ctrldom.AddHuma(nom);
    }
    public ArrayList<String> consultar_usuaris(){
        ArrayList<String> llistaUsuaris = ctrldom.getUsuaris();
        return llistaUsuaris;
    }
    public void afegirProblema(String problema, int mat ){
        ctrldom.AddProblem(problema,mat);
    }
    public ArrayList<String> consultar_Problemas(){
        ArrayList<String> llistaProblemas = ctrldom.getProblemas();
        return llistaProblemas;
    }
    public void crearPartida(String atac, String def, String problem){
        ctrldom.crearPartida(atac,def,problem);
    }


    public ArrayList<Timestamp> consultar_Partidas(){
        ArrayList<Timestamp> llistaPartides = ctrldom.getPartidas();
        return llistaPartides;
    }

    public ArrayList<Integer> get_pecas(String FEN){
        return null;
    }
    public boolean mourePeca(int xO,int yO, int xD, int yD){

        return ctrldom.mourePeca(xO,yO, xD, yD);
    }





    public static void main(String[] args){
        CtrlPresentacio CtrlP = new CtrlPresentacio();

        frame main = frame.getInstance();
        main.setContentPane(new GUIMain().getMyGUIMain());
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setBounds(300,200,600,400);

        main.setVisible(true);


    }

}
