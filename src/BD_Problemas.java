
import java.util.Collection;
import java.io.*;
import java.util.*;

public class BD_Problemas {

    private Collection<Problema> CollectionProblems;

    public BD_Problemas(){
        this.CollectionProblems = new ArrayList<>();
    }

    public void AddProblem(Problema problem) {

        CollectionProblems.add(problem);
    }

    public Problema getProblema(String fen){
        for(Problema elem : CollectionProblems){
            if(elem.getFEN().equals(fen)){
                return elem;
            }
        }
        return null;
    }
    public void delProblem(String id){
        Iterator<Problema> itr=this.CollectionProblems.iterator();
        while(itr.hasNext()){
            if(itr.next().getID().equals(id)){
                itr.remove();
            }
        }
    }
    public boolean existsProblema(String fen){
        Iterator<Problema> itr=this.CollectionProblems.iterator();
        while(itr.hasNext()){
            if(itr.next().getFEN().equals(fen)){
                return true;
            }
        }
        return false;

    }


    public Collection<Problema> getCollectionProblems() {
        return CollectionProblems;
    }
}
