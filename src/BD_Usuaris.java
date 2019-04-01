import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BD_Usuaris {

    private Collection<Huma> CollectionHumans;

    BD_Usuaris(){
        this.CollectionHumans = new ArrayList<>();
    }
    public void AddHuma(Huma h){
        CollectionHumans.add(h);

    }

    public Huma getHuma(String nom){
        for(Huma elem : CollectionHumans){
            if(elem.getNom().equals(nom)){
                return elem;
            }
        }
        return null;
    }
    public void delHuma(String nom){
        Iterator<Huma> itr=this.CollectionHumans.iterator();
        while(itr.hasNext()){
            if(itr.next().getNom().equals(nom)){
                itr.remove();
            }
        }
    }
    public boolean existsHuma(String nom){
        Iterator<Huma> itr=this.CollectionHumans.iterator();
        while(itr.hasNext()){
            if(itr.next().getNom().equals(nom)){
                return true;
            }
        }
        return false;

    }

    public Collection<Huma> getCollectionHumans() {
        return CollectionHumans;
    }
}
