package domini;

import java.sql.Timestamp;
import java.util.*;
import persistencia.ControladorPersistencia;

public class Ctrl_Domini {
    private Fabrica fa= new Fabrica();
    private BD_Problemas bdp= new BD_Problemas();
    private BD_Usuaris bdu= new BD_Usuaris();

    private Partida joc;

    private ControladorPersistencia CtrlPer = new ControladorPersistencia();

    public void crearMaquina(){
        Maquina m1= new Maquina("M1");
        bdu.AddMaquina(m1);
    }

    public void AddHuma(String nom){
        Huma h= new Huma(nom);
        if(bdu.existsHuma(nom)){
            System.out.println("Ya existe usuario con el nombre introducido. \n");
        }
        else{
            System.out.println("afegit \n");
            bdu.AddHuma(h);
        }
    }
    public void AddProblem(String fen,int mat){
        Problema p= new Problema(fen);
        p.setN(mat);

        Maquina virtual = new Maquina("VIRTUAL");
        if(virtual.te_solucio(p.FENtoHuman().getPeces_blanques(), p.FENtoHuman().getPeces_negres(),mat)){
            if(bdp.existsProblema(fen)){
                System.out.println("Ya existe el problema con este FEN \n");
            }
            else {
                System.out.println("domini.Problema afegit amb exit\n");
                bdp.AddProblem(p);
            }

        }
        else {
            System.out.println("No es pot assolir el mat indicat \n");
        }


    }
    public void crearPartida(String Atacant, String defensor,String problema){
        Usuari a= bdu.getHuma(Atacant);
        Usuari d= bdu.getHuma(defensor);
        Problema p= bdp.getProblema(problema);
        Tauler t= p.FENtoHuman();
        fa.CrearPartida(a,d,p,t);
    }

    public ArrayList<String> getProblemas(){
        ArrayList<String> problemas = new ArrayList<>();
        for(Problema elem : bdp.getCollectionProblems()) {
            problemas.add(elem.getFEN());
        }
        return problemas;
    }

    public ArrayList<String> getUsuaris(){
        ArrayList<String> Usuaris = new ArrayList<>();
        for(Usuari elem : bdu.getCollectionHumans()) {
            Usuaris.add(elem.getNom());

        }
        return Usuaris;
    }

    public ArrayList<Timestamp> getPartidas(){
        ArrayList<Timestamp> partidas = new ArrayList<>();
        for(Partida elem : fa.getCollectionPartidas()) {
            partidas.add(elem.getFecha());
        }
        return partidas;

    }

    public Tauler getTauler(String fen){
        Problema p= bdp.getProblema(fen);
        Tauler t= p.FENtoHuman();
        return t;

    }
    public Partida getPartida(Timestamp fecha){
        Partida p= fa.getPartida(fecha);
        return p;

    }
    public void selecionar_Partida(Timestamp fecha){
        joc=getPartida(fecha);
    }

    public ArrayList<Integer> getPecas() {

        String aux = joc.getT().HumantoFEN(joc.getT().getPeces_blanques(),joc.getT().getPeces_negres());
        Problema problemaAuxiliar = new Problema(aux);
        Tauler T = problemaAuxiliar.FENtoHuman();

        ArrayList<Integer> peces = new ArrayList<>();
        Peca[] pecesBlanc = T.getPeces_blanques();
        Peca[] pecesNegre = T.getPeces_negres();
        // 0 1 2 3 4 5 peces blancas: peon alfil cavall torre reina rey
        for (int i = 0; i < 16; i++) {
            if (pecesBlanc[i] != null) {
                peces.add(pecesBlanc[i].getX());
                peces.add(pecesBlanc[i].getY());
                if (i < 8) {
                    peces.add(0);
                } else if (i == 8 || i == 9) {
                    peces.add(1);
                } else if (i == 10 || i == 11) {
                    peces.add(2);
                } else if (i == 12 || i == 13) {
                    peces.add(3);
                } else if (i == 14) {
                    peces.add(4);
                } else if (i == 15) {
                    peces.add(5);
                }
            }
            // 6 7 8 9 10 11 peces negres: peon alfil cavall torre reina rey
            if (pecesNegre[i] != null) {
                peces.add(pecesNegre[i].getX());
                peces.add(pecesNegre[i].getY());
                if (i < 8) {
                    peces.add(6);
                } else if (i == 8 || i == 9) {
                    peces.add(7);
                } else if (i == 10 || i == 11) {
                    peces.add(8);
                } else if (i == 12 || i == 13) {
                    peces.add(9);
                } else if (i == 14) {
                    peces.add(10);
                } else if (i == 15) {
                    peces.add(11);
                }
            }
        }
        return peces;
    }
    public ArrayList<Integer> moureMaquina(){
        Jugada j = joc.moureMaquina(joc.getP().getN());
        ArrayList<Integer> aux = new ArrayList<>();
        if (j != null) {
            joc.mourePeca(j.getPeca().getX(), j.getPeca().getY(), j.getPos_fin_x(), j.getPos_fin_y());
            aux.add(j.getPeca().getX());
            aux.add(j.getPeca().getY());
            aux.add(j.getPos_fin_x());
            aux.add(j.getPos_fin_y());
        }
        else {
            System.out.println("La Maquina no mou");
        }
        return aux;

    }


    public boolean mourePeca(int xO,int yO, int xD, int yD){
        return joc.mourePeca(xO, yO, xD, yD);
    }

    public ArrayList<Integer> PosiblesMoviments( int x, int y){
        joc.getT().actualitzar();
        Peca p= joc.getT().getPeca(x,y);
        ArrayList<IntPair> aux =p.getMoviments();
        ArrayList<Integer> moviments= new ArrayList<>();
        for(int i=0;i<aux.size();i++){
            moviments.add(aux.get(i).getX());
            moviments.add(aux.get(i).getY());
        }
        return moviments;
    }


    public void CarregarProblemas() throws Exception{
        Vector<String> FENS = CtrlPer.LlegirProblema();
        for(int i=0;i< FENS.size();i+=2){
            AddProblem(FENS.get(i),Integer.valueOf(FENS.get(i+1)));
        }
    }
    public void CarregarUsuaris() throws Exception{
        Vector<String> Users =CtrlPer.LlegirUsuari();
        for(int i=0;i< Users.size();i++) {
            AddHuma(Users.get(i));
        }
    }




}