package domini;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class Ranking {
    Map<String,Integer> map = new HashMap<String,Integer>();



    public void addUsuariGuanyador(String nom){
        if(!map.containsKey(nom)){
            map.put(nom,1);
        }
        else{
            int aux = map.get(nom);
            aux++;
            map.put(nom,aux);
        }
    }
    public ArrayList<String> getUsuarisRanking(){
        ArrayList<String> noms = new ArrayList<>();
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            noms.add(key);
        }
        return noms;
    }
    public ArrayList<Integer> getGuanyadasRanking(){
        ArrayList<Integer> punts = new ArrayList<>();
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            punts.add(map.get(key));
        }
        return punts;
    }

}
