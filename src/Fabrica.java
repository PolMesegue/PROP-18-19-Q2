

import java.util.Collection;
import java.io.*;
import java.util.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fabrica {

    private Collection<Partida> CollectionPartidas;

    public Fabrica(){
        this.CollectionPartidas = new ArrayList<>();
    }

    public void CrearPartida(Atacant a,Defensor d, Problema p, Tauler t){
        Date fecha = new Date();
        Timestamp s= new Timestamp(fecha.getTime());
        Partida game= new Partida(s,p,t,a,d);
        CollectionPartidas.add(game);
    }

    public Collection<Partida> getCollectionPartidas() {
        return CollectionPartidas;
    }

}
