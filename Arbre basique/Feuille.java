

import java.util.Set;

public class Feuille implements Arbre {
    
    private Integer valeur;

    public Feuille(int valeur) {
        this.valeur = valeur;
    }

    @Override
    public int taille() {
        return 1;
    }
    
    @Override
    public boolean contient(Integer val) {
        return val.equals(valeur);
    }

    @Override
    public Set<Integer> valeurs() {
        return Set.of(valeur);
    }

    @Override
    public Integer somme() {
        return valeur;
    }

    @Override
    public Integer min() {
        return valeur;
    }

    @Override
    public Integer max() {
        return valeur;
    }

    @Override
    public boolean estTrie() {
        return true;
    }
}