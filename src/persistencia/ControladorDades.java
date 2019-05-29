package persistencia;

import java.io.*;
import java.util.Vector;

public class ControladorDades {

    protected static File a;
    protected static FileReader fr;
    protected static FileWriter fw;
    protected String path;

    public ControladorDades(String p) {
        a = null;
        fr = null;
        fw = null;
        path = p;
    }

    public void ObrirArxiu() throws IOException {
        a = new File(path);
        if (!a.exists()){
            a.createNewFile();
        }
    }
    public  void TancarArxiu() throws IOException {
        a = null;
        if (fr != null) fr.close();
        if (fw != null) fw.close();
    }
    public void EsborrarContingut() throws Exception {
        ObrirArxiu();
        fw = new FileWriter(a);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");
        TancarArxiu();
    }

    public void Escriure(String s) throws Exception {
        if (a == null) throw new Exception("Arxiu no obert");

        fw = new FileWriter(a, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(s);
        out.close();
    }

    public Vector<String> Llegir() throws Exception {
        if (a == null) throw new Exception("Arxiu no obert");
        fr = new FileReader(a);
        BufferedReader in = new BufferedReader(fr);
        Vector<String> lineas = new Vector<String>();
        String linea;
        while ((linea = in.readLine()) != null) {
            lineas.add(linea);
        }
        in.close();
        return lineas;
    }

}
