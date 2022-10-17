

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Noeud implements Arbre{

    private final List<Arbre> newarbre;

    public Noeud(List<Arbre> newarbre) {
        this.newarbre = newarbre;
    }

    @Override
    public int taille() {
        int taille = 0;
        for (Arbre f : newarbre) {
            taille = taille + f.taille();
        }
        return taille;
    }

    @Override
    public boolean contient(Integer val) {
        for (Arbre a : newarbre) {
            if (a.contient(val)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Integer> valeurs() {
        Set<Integer> valeur = new HashSet<>();

        for (Arbre a : newarbre) {
            valeur.addAll(a.valeurs());
        }

        return valeur;
    }

    @Override
    public Integer somme() {
        int total = 0;
        for (Arbre f : newarbre) {
            total = total + f.somme();
        }
        return total;
    }

    @Override
    public Integer min() {
        if (newarbre == null || newarbre.size() == 0)
            return null;
        int rtr = newarbre.get(0).min();
        for (int i = 1; i < newarbre.size(); i++) {
            int min = newarbre.get(i).min();
            if (min < rtr) {
                rtr = min;
            }
        }
        return rtr;
    }

    @Override
    public Integer max() {
        if (newarbre == null || newarbre.size() == 0)
            return null;
        int rtr = newarbre.get(0).max();
        for (int i = 1; i < newarbre.size(); i++) {
            int max = newarbre.get(i).max();
            if (max > rtr) {
                rtr = max;
            }
        }
        return rtr;
    }

    @Override
    public boolean estTrie() {
        return conditionTrie1() && conditionTrie2();
    }

    private boolean conditionTrie1() {
        boolean trie = true;
        for (int i = 0; i < newarbre.size() - 1; i++) {
            final Arbre arbre = newarbre.get(i);
            if (!arbre.estTrie())
                return false;
        }
        return trie;
    }

    private boolean conditionTrie2() {
        boolean trie = true;
        for (int i = 0; i < newarbre.size() - 1; i++) {
            final Arbre fi = newarbre.get(i);
            final Arbre fj = newarbre.get(i+1);
                if (fi.max() > fj.min())
                    return false;
        }
        return trie;
    }
    
}


    

