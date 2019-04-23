

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Partida {

    private static Timestamp fecha;
    private Problema p;
    private Tauler t;
    private Usuari a;
    private Usuari d;
    private Rellotge timer;

    Partida(Timestamp f,Problema p, Tauler t, Usuari a, Usuari d){
        fecha=f;
        this.p=p;
        this.t=t;
        this.a=a;
        this.d=d;
    }



    public void mourePeça(, int x, int y){
        //char whoStarts = p.whoStarts();

        //acaba de començar la partida
        if(timer.getfirst()){
            timer.startTimer();
            timer.changePlayer();
            timer.setFirst(false);
        }

        t.moure(/*necesitara posicions de la peça i el desti*/);

        //modificar el cambii
        t.modificar();

        long test = timer.stopTimer();
        test = test/1000;
        if (timer.getPlayer()) {
            timer.decreaseCounterT1((int) test);
            System.out.println(timer.getT1());
        }
        else {
            timer.decreaseCounterT2((int) test);
            timer.getT2();
        }
        timer.startTimer();
        timer.changePlayer();

    }

    public Usuari getA() {
        return a;
    }

    public Usuari getD() {
        return d;
    }

    public Problema getP() {
        return p;
    }

    public Tauler getT() {
        return t;
    }

    public void setA(Usuari a) {
        this.a = a;
    }

    public void setD(Usuari d) {
        this.d = d;
    }

    public void setP(Problema p) {
        this.p = p;
    }

    public void setT(Tauler t) {
        this.t = t;
    }

    public Timestamp getFecha() {
        return fecha;
    }
}
