package domini;

import java.sql.Timestamp;
import java.util.*;

public class Ctrl_Domini {
    private Fabrica fa= new Fabrica();
    private BD_Problemas bdp= new BD_Problemas();
    private BD_Usuaris bdu= new BD_Usuaris();

    private Partida joc;

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

    public boolean mourePeca(int xO,int yO, int xD, int yD){
        return true;

    }



}