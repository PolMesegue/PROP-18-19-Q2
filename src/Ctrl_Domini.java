
import java.lang.reflect.Array;
import java.util.Collection;
import java.io.*;
import java.util.*;

public class Ctrl_Domini {
    private Fabrica fa= new Fabrica();
    private BD_Problemas bdp= new BD_Problemas();
    private BD_Usuaris bdu= new BD_Usuaris();


    public void AddHuma(String nom,String password){
        Huma h= new Huma(nom,password);
        //if(!bdu.getHuma(nom).equals(h)){
            bdu.AddHuma(h);
       //}
        //imprimir error, ya existeix.
    }
    public void AddProblem(String fen){
        Problema p= new Problema(fen);
        bdp.AddProblem(p);
    }
    public void crearPartida(String Atacant, String defensor,String problema){
            Usuari a= bdu.getHuma(Atacant);
            Usuari d= bdu.getHuma(defensor);
            Problema p= bdp.getProblema(problema);
            System.out.println(p.getFEN());
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

}
