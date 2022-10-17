import java.util.Set;

public class Feuille<U> implements Arbre<U>{
    private U valeur;
    public Feuille (U valeur){
        this.valeur=valeur;
    }
    @Override
    public int taille(){
        return  1;
    }
    @Override
    public boolean contient(U val){
        return val.equals(valeur);
    }
    @Override
    public Set<U> valeurs(){
        return Set.of(valeur);
    }

    @Override
    public U somme() {
        return null;
    }
}