import java.util.*;

public class Noeud<U extends Sommable<U>>  implements Arbre<U> {
    private final List<Arbre<U>> newnoeud ;
    public Noeud(List<Arbre<U>> newnoeud){
        this.newnoeud = newnoeud;
    }
    @Override
    public int taille(){
        Integer taille = 0;
        for (Arbre a: newnoeud){
            taille = taille + a.taille();
        }
        return taille;
    }

    @Override
    public boolean contient(U val) {
        for (Arbre<U> a : newnoeud) {
            if (a.contient(val)) {
                return true;
            }
        }
        return false;
    }

    public List<Arbre<U>> getNewnoeud() {
        return newnoeud;
    }

    @Override
    public Set<U> valeurs() {
        Set<U> valeur = new HashSet<>();

        for (Arbre a : newnoeud) {
            valeur.addAll(a.valeurs());
        }

        return valeur;
    }

    @Override
    public U somme() {
        if (newnoeud == null||  newnoeud.size() == 0){
            return null;
        }
         U rtr = newnoeud.get(0).somme();
        for(Arbre<U> a : newnoeud){
            rtr.sommer(a.somme());
        }
        return rtr;
    }

    public String toString() {
        return "Noeud{" +
                "newnoeud=" + this.newnoeud +
                '}';
    }

    public static void main(String[] args){
        Arbre<Entier> arbre = new Feuille<>(new Entier(1));
        Arbre<Entier> arbre1 = new Feuille<>(new Entier(3));
        Arbre<Entier> arbre2 = new Noeud(List.of(arbre1,arbre));
        System.out.println(arbre2.somme());
    }

}
