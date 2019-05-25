package presentacio;

import javax.swing.*;
import domini.Ctrl_Domini;
import persistencia.ControladorPersistencia;

import java.sql.Timestamp;
import java.util.*;

public class CtrlPresentacio {

    private static CtrlPresentacio pr;

    private  static Ctrl_Domini ctrldom = new Ctrl_Domini();

    public CtrlPresentacio(){}

    public static CtrlPresentacio getInstance(){
        if(pr==null) pr= new CtrlPresentacio();
            return pr;
    }

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
    public ArrayList<Integer> get_pecas(){
        // 0 1 2 3 4 5 peces blancas: peon alfil cavall torre reina rey
        // 6 7 8 9 10 11 peces negres: peon alfil cavall torre reina rey
        return ctrldom.getPecas();
    }
    public boolean mourePeca(int xO,int yO, int xD, int yD){
        return ctrldom.mourePeca(xO,yO, xD, yD);
    }

    public void selecionar_Partida(Timestamp fecha){
        ctrldom.selecionar_Partida(fecha);
    }
    public ArrayList<Integer> PosiblesMoviments(int x, int y){
        return ctrldom.PosiblesMoviments(x,y);
    }

    //cargar
    public void CarregarProblemas() throws Exception{
        ctrldom.CarregarProblemas();
    }
    public void CarregarUsuaris() throws Exception{
        ctrldom.CarregarUsuaris();
    }
    public ArrayList<Integer> turnMaquina(){
        return ctrldom.moureMaquina();

    }
    public String getDefensor(){
        return ctrldom.getDefensor();
    }
    public int getN(){
        return ctrldom.getN();

    }
    public ArrayList<Integer> mostrarTaulell(String FEN){
        return ctrldom.mostrarTaulell(FEN);
    }

    public ArrayList<String> getUsersRanking(){
        return ctrldom.getUsersRanking();
    }
    public ArrayList<Integer> getUsersRankingPoints(){
        return ctrldom.getUsersRankingPoints();
    }
    public void addtoranking(String nom){
        ctrldom.addtoranking(nom);
    }

    public static void main(String[] args){
            frame main = frame.getInstance();
            ctrldom.crearMaquina();
            main.setContentPane(new GUIMain().getMyGUIMain());
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setBounds(300, 200, 600, 400);

            main.setVisible(true);
    }

}
