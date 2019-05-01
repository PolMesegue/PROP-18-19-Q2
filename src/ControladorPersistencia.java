import java.util.*;
import java.io.*;
import java.time.Instant;


public class ControladorPersistencia {


    private ControladorDades dp, dpa, du;


    public ControladorPersistencia() {

        File d = new File("./dades/Partides");
        if (!d.exists()) d.mkdirs();
        dp = new ControladorDades("./dades/Problemes.txt");
        dpa = new ControladorDades("./dades/Usuaris.txt");
        du = new ControladorDades("./dades/Partides.txt");

    }
/*
    public void CarregarHorari(String s) {
        String p = "./dades/Horaris/" + s;
        dh = new ControladorDades(p);
    }
*/
    //Escritures (String)

    public void EscriureProblema(String s) throws Exception{
        da.ObrirArxiu();
        da.Escriure(s);
        da.TancarArxiu();
    }
    public void EscriureUsuari(String s) throws Exception{
        dassig.ObrirArxiu();
        dassig.Escriure(s);
        dassig.TancarArxiu();
    }
    public void EscriurePartida(String s) throws Exception{
        dg.ObrirArxiu();
        dg.Escriure(s);
        dg.TancarArxiu();
    }

    public void EscriureHorari(String s) throws Exception{
        long test = Instant.now().toEpochMilli();
        dh = new ControladorDades("./dades/Horaris/horari" + Long.toString(test) + ".txt");
        dh.ObrirArxiu();
        dh.Escriure(s);
        dh.TancarArxiu();
    }

}
