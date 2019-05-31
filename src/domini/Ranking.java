package domini;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;



public class Ranking {

    Map<String,Pair> map = new HashMap<String,Pair>();
    Pair<String, Float> res;


    public void addUsuariGuanyador(String fen, String atacant, float temps){
        res = new Pair<String, Float>(atacant,temps);

        if (!map.containsKey(fen)) {

            map.put(fen, res);
        }



        else {

            if ((float) map.get(fen).getValue() < temps){
                map.remove(fen);
                map.put(fen,res);
            }
        }
    }

    public ArrayList<Float> getTempsRanking() {
        ArrayList<Float> segons = new ArrayList<>();
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            segons.add((float)map.get(key).getValue());
        }
        return segons;
    }


    public ArrayList<String> getUsuarisRanking(){
        ArrayList<String> users = new ArrayList<>();
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            users.add((String)map.get(key).getKey());
        }
        return users;
    }
    public ArrayList<String> getFenRanking(){
        ArrayList<String> fens = new ArrayList<>();
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            fens.add(key);
        }
        return fens;
    }

}
