package domini;

import java.util.*;
import java.io.*;


public class ControladorPersistencia {


    private ControladorDades dp, dpa, du;


    public ControladorPersistencia() {

        File d = new File("./dades/Partides");
        if (!d.exists()) d.mkdirs();
        dp = new ControladorDades("./dades/Problemes.txt");
        dpa = new ControladorDades("./dades/Usuaris.txt");
        du = new ControladorDades("./dades/Partides.txt");

    }

    public void CarregarPartida(String s) {
        String p = "./dades/Partides/" + s;
        dp = new ControladorDades(p);
    }

    //Escritures (String)

    public void EscriureProblema(String s) throws Exception{
        dp.ObrirArxiu();
        dp.Escriure(s);
        dp.TancarArxiu();
    }
    public void EscriureUsuari(String s) throws Exception{
        du.ObrirArxiu();
        du.Escriure(s);
        du.TancarArxiu();
    }
    public void EscriurePartida(String s) throws Exception{
        dpa.ObrirArxiu();
        dpa.Escriure(s);
        dpa.TancarArxiu();
    }


    //Lectures
    public Vector<String> LlegirProblema() throws Exception{
        dp.ObrirArxiu();
        Vector<String> aux = dp.Llegir();
        dp.TancarArxiu();
        return aux;
    }
    public Vector<String> LlegirUsuari() throws Exception{
        du.ObrirArxiu();
        Vector<String> aux = du.Llegir();
        du.TancarArxiu();
        return aux;
    }
    public Vector<String> LlegirPartida() throws Exception{
        dpa.ObrirArxiu();
        Vector<String> aux = dpa.Llegir();
        dpa.TancarArxiu();
        return aux;
    }

    
}
