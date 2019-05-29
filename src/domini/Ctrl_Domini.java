package domini;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.IntToDoubleFunction;

import persistencia.ControladorPersistencia;

public class Ctrl_Domini {
    private Fabrica fa= new Fabrica();
    private BD_Problemas bdp= new BD_Problemas();
    private BD_Usuaris bdu= new BD_Usuaris();
    private Ranking rank = new Ranking();

    private Partida joc;

    private ControladorPersistencia CtrlPer = new ControladorPersistencia();

    public void crearMaquina(){
        Maquina m1= new Maquina("M1");
        bdu.AddMaquina(m1);
    }


    // 0 1 2 3 4 5 peces blancas: peon alfil cavall torre reina rey
    // 6 7 8 9 10 11 peces negres: peon alfil cavall torre reina rey
    public boolean addTaulell(ArrayList<Integer> peces, int nMat) {
            Tauler T = new Tauler();
            int BnT=0, BnC=0, BnA=0, BnP=0, BnD = 0, BnR = 0, NnT=0, NnC=0, NnA=0, NnP=0, NnD =0, NnR =0;

        for(int i = 0; i < peces.size(); i+=3) {
            if (peces.get(i+2) == 0) {
                if(BnP >= 8) return false;
                T.setPeo(new Peo(BnP,peces.get(i),peces.get(i+1),true));
                ++BnP;
            }
            if (peces.get(i+2) == 1) {
                if(BnA >= 2) return false;
                T.setAlfil(new Alfil(8+BnA,peces.get(i),peces.get(i+1),true));
                ++BnA;
            }
            if (peces.get(i+2) == 2) {
                if(BnC >= 2) return false;
                T.setCavall(new Cavall(10+BnC,peces.get(i),peces.get(i+1),true));
                ++BnC;
            }
            if (peces.get(i+2) == 3) {
                if(BnT >= 2) return false;
                T.setTorre(new Torre(12+BnT,peces.get(i),peces.get(i+1),true));
                ++BnT;
            }
            if (peces.get(i+2) == 4) {
                if(BnD >= 1) return false;
                T.setReina(new Reina(14,peces.get(i),peces.get(i+1),true));
                ++BnD;
            }
            if (peces.get(i+2) == 5) {
                if(BnR >= 1) return false;
                T.setRei(new Rei(15,peces.get(i),peces.get(i+1),true));
                ++BnR;
            }
            if (peces.get(i+2) == 6) {
                if(NnP >= 8) return false;
                T.setPeo(new Peo(NnP,peces.get(i),peces.get(i+1),false));
                ++NnP;
            }
            if (peces.get(i+2) == 7) {
                if(NnA >= 2) return false;
                T.setAlfil(new Alfil(8+NnA,peces.get(i),peces.get(i+1),false));
                ++NnA;
            }
            if (peces.get(i+2) == 8) {
                if(NnC >= 2) return false;
                T.setCavall(new Cavall(10+NnC,peces.get(i),peces.get(i+1),false));
                ++NnC;
            }
            if (peces.get(i+2) == 9) {
                if(NnT >= 2) return false;
                T.setTorre(new Torre(12+NnT,peces.get(i),peces.get(i+1),false));
                ++NnT;
            }
            if (peces.get(i+2) == 10) {
                if(NnD >= 1) return false;
                T.setReina(new Reina(14,peces.get(i),peces.get(i+1),false));
                ++NnD;
            }
            if (peces.get(i+2) == 11) {
                if(NnR >= 1) return false;
                T.setRei(new Rei(15,peces.get(i),peces.get(i+1),false));
                ++NnR;
            }
        }
        String fen = T.HumantoFEN(T.getPeces_blanques(),T.getPeces_negres());

        ArrayList<Character> noufen = new ArrayList<>();
        boolean espaiBlanc = false;
        for (int i = 0; i < fen.length();++i) {
            if (!espaiBlanc) {
                if (fen.charAt(i) == ' ')  {
                    espaiBlanc = true;
                }
                noufen.add(fen.charAt(i));
            }
            else {
                noufen.add('M');
                noufen.add('a');
                noufen.add('t');
                noufen.add(':');
                noufen.add(' ');
                noufen.add((char) (nMat+'0'));
                break;
            }
        }

        StringBuilder builder = new StringBuilder(noufen.size());
        for(Character ch: noufen)
        {
            builder.append(ch);
        }

        Problema p = new Problema(builder.toString());
        p.setN(nMat);
        Maquina virtual = new Maquina("VIRTUAL");
        if(virtual.te_solucio(p.FENtoHuman().getPeces_blanques(), p.FENtoHuman().getPeces_negres(),nMat)) {
            if (bdp.existsProblema(builder.toString())) {
                return false;
            } else {
                if (p.FENtoHuman() != null) {
                    System.out.println("domini.Problema afegit amb exit\n");
                    bdp.AddProblem(p);

                    String aux = p.getFEN();
                    aux = aux + "\n" + p.getN();
                    try {
                        CtrlPer.EscriureProblema(aux);
                    } catch (Exception B) {
                        B.printStackTrace();
                    }
                } else return false;
            }
        }
        return true;

    }

    public boolean AddProblem(String fen,int mat){

        ArrayList<Character> noufen = new ArrayList<>();
        boolean espaiBlanc = false;
        for (int i = 0; i < fen.length();++i) {
            if (!espaiBlanc) {
                if (fen.charAt(i) == ' ')  {
                    espaiBlanc = true;
                }
                noufen.add(fen.charAt(i));
            }
            else {
                noufen.add('M');
                noufen.add('a');
                noufen.add('t');
                noufen.add(':');
                noufen.add(' ');
                noufen.add((char) (mat +'0'));
                break;
            }
        }

        StringBuilder builder = new StringBuilder(noufen.size());
        for(Character ch: noufen)
        {
            builder.append(ch);
        }

        Problema p= new Problema(builder.toString());
        p.setN(mat);

        Maquina virtual = new Maquina("VIRTUAL");
        //if(virtual.te_solucio(p.FENtoHuman().getPeces_blanques(), p.FENtoHuman().getPeces_negres(),mat)){
            if(bdp.existsProblema(builder.toString())){
                return false;
            }
            else {
                if(p.FENtoHuman() != null) {
                    System.out.println("domini.Problema afegit amb exit\n");
                    bdp.AddProblem(p);
                }
                else return false;
            }
            return true;
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

    public boolean getTorn() {
        return joc.getTorn();
    }

    public void setTorn (boolean torn) {
        joc.setTorn(torn);
    }

    public void setMov(int mov) {
        joc.setMov(mov);
    }

    public void setTemps(float temps) {joc.setTemps(temps);}

    public float getTemps() {

        return joc.getTemps();
    }

    public void delUsuari(String nom) {
        bdu.delHuma(nom);
    }

    public void delProblema(String FEN) {
        bdp.delProblem(FEN);
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
    public ArrayList<Integer> mostrarTaulell(String FEN){
        Problema p = new Problema(FEN);
        Tauler T = p.FENtoHuman();
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
    public ArrayList<Integer> moureMaquina(int i){
        Jugada j = joc.moureMaquina(joc.getP().getN(),i);
        ArrayList<Integer> aux = new ArrayList<>();
        if (j != null) {
            aux.add(j.getPeca().getX());
            aux.add(j.getPeca().getY());
            aux.add(j.getPos_fin_x());
            aux.add(j.getPos_fin_y());
            joc.mourePeca(j.getPeca().getX(), j.getPeca().getY(), j.getPos_fin_x(), j.getPos_fin_y());
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
    public boolean CarregarProblemas() throws Exception{
        Vector<String> FENS = CtrlPer.LlegirProblema();
        Maquina M1 = new Maquina("M1");
        for(int i=0;i< FENS.size();i+=2){
            Problema aux = new Problema(FENS.get(i));
            if(aux.FENtoHuman() != null){
                //if(M1.te_solucio(aux.FENtoHuman().getPeces_blanques(),aux.FENtoHuman().getPeces_negres(),Integer.valueOf(FENS.get(i+1)))){
                if(!AddProblem(FENS.get(i),Integer.valueOf(FENS.get(i+1)))) return false;
            }
            else return false;
        }
        return true;
    }

    public boolean CarregarUsuaris() throws Exception{
        Vector<String> Users =CtrlPer.LlegirUsuari();
        for(int i=0;i< Users.size();i++) {
            if (!AddHuma(Users.get(i), false)) return false;
        }
        return true;
    }

    public boolean AddHuma(String nom, boolean escriure){
        Huma h= new Huma(nom);
        if(bdu.existsHuma(nom)){
            System.out.println("Ya existe usuario con el nombre introducido. \n");
            return false;
        }
        else{
            System.out.println("afegit \n");
            bdu.AddHuma(h);
            if (escriure) {
                try {
                    CtrlPer.EscriureUsuari(nom);
                } catch (Exception B) {
                    B.printStackTrace();
                }
            }
        }
        return true;
    }


    public String getDefensor(){
        return joc.getD().getNom();
    }
    public String getAtacant(){
        return joc.getA().getNom();
    }
    public int getN(){
        return joc.getN();
    }
    public int getMov() {
        return joc.getMov();
    }
    public ArrayList<String> getUsersRanking(){
        return rank.getUsuarisRanking();
    }
    public ArrayList<Integer> getUsersRankingPoints(){
        return rank.getGuanyadasRanking();
    }
    public void addtoranking(String nom){
        rank.addUsuariGuanyador(nom);
    }
    public void deletePartidaActual(){
        fa.borrarPartida(joc.getFecha());
    }
    public void deletePartida(Timestamp fecha) {
        fa.borrarPartida(fecha);
    }



}