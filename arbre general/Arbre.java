import java.util.Set;

public interface Arbre <U> { // à généraliser
    int taille();
    boolean contient(final U val);
    Set<U> valeurs();
    U somme();

    }