package domini;

import java.util.Collection;
import java.util.*;

import java.sql.Timestamp;
import java.util.Date;

public class Fabrica {

    private Collection<Partida> CollectionPartidas;

    public Fabrica(){
        this.CollectionPartidas = new ArrayList<>();
    }

    public void CrearPartida(Usuari a,Usuari d, Problema p, Tauler t){
        Date fecha = new Date();
        Timestamp s= new Timestamp(fecha.getTime());
        Partida game= new Partida(s,p,t,a,d);
        CollectionPartidas.add(game);
    }

    public Partida getPartida(Timestamp fecha){

        for(Partida elem : CollectionPartidas){
            if(elem.getFecha().equals(fecha)){
                return elem;
            }
        }
        return null;
    }

    public Collection<Partida> getCollectionPartidas() {
        return CollectionPartidas;
    }

    public void borrarPartida(Timestamp fecha){
        for(Partida elem : CollectionPartidas){
            if(elem.getFecha().equals(fecha)){
                CollectionPartidas.remove(elem);
            }
        }
    }
}
