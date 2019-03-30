
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

    public Problema getProblema(String id){
        for(Problema elem : CollectionProblems){
            if(elem.getID().equals(id)){
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

}
