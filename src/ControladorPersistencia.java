import java.util.*;
import java.io.*;
import java.time.Instant;


public class ControladorPersistencia {


    private ControladorDades da, dassig, dg, dga, dpe, ds, dta, dts,dh,dhi;

    public ControladorPersistencia() {
        File d = new File("./dades/Horaris");
        if (!d.exists()) d.mkdirs();
        da = new ControladorDades("./dades/Aules.txt");
        dassig = new ControladorDades("./dades/Assignatures.txt");
        dg = new ControladorDades("./dades/Grups.txt");
        dga = new ControladorDades("./dades/GrupsAssignatura.txt");
        dpe = new ControladorDades("./dades/PlansEstudi.txt");
        ds = new ControladorDades("./dades/Sessions.txt");
        dta = new ControladorDades("./dades/TipusAula.txt");
        dts = new ControladorDades("./dades/TipusSessio.txt");
        dhi = new ControladorDades("./dades/HoresImpossibles.txt");
        dh = new ControladorDades("./dades/Horaris/horari.txt");
    }

    public void CarregarHorari(String s) {
        String p = "./dades/Horaris/" + s;
        dh = new ControladorDades(p);
    }

    //Escritures (String)
    public void EscriureAula(String s) throws Exception{
        da.ObrirArxiu();
        da.Escriure(s);
        da.TancarArxiu();
    }
    public void EscriureAssignatura(String s) throws Exception{
        dassig.ObrirArxiu();
        dassig.Escriure(s);
        dassig.TancarArxiu();
    }
    public void EscriureGrup(String s) throws Exception{
        dg.ObrirArxiu();
        dg.Escriure(s);
        dg.TancarArxiu();
    }
    public void EscriureGrupAssignatura(String s) throws Exception{
        dga.ObrirArxiu();
        dga.Escriure(s);
        dga.TancarArxiu();
    }
    public void EscriurePlaEstudis(String s) throws Exception{
        dpe.ObrirArxiu();
        dpe.Escriure(s);
        dpe.TancarArxiu();
    }
    public void EscriureSessio(String s) throws Exception{
        ds.ObrirArxiu();
        ds.Escriure(s);
        ds.TancarArxiu();
    }
    public void EscriureTipusAula(String s) throws Exception{
        dta.ObrirArxiu();
        dta.Escriure(s);
        dta.TancarArxiu();
    }
    public void EscriureTipusSessio(String s) throws Exception{
        dts.ObrirArxiu();
        dts.Escriure(s);
        dts.TancarArxiu();
    }
    public void EscriureHorari(String s) throws Exception{
        long test = Instant.now().toEpochMilli();
        dh = new ControladorDades("./dades/Horaris/horari" + Long.toString(test) + ".txt");
        dh.ObrirArxiu();
        dh.Escriure(s);
        dh.TancarArxiu();
    }
    public void EscriureHoresImpossibles(String[][] s) throws Exception{
        dhi.ObrirArxiu();
        dhi.Escriure(s);
        dhi.TancarArxiu();
    }
}
