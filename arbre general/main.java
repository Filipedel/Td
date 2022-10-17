


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class main {
    public static final Arbre arbre0() {
        return new Noeud(new ArrayList<Arbre>());
    }
    public static final Arbre arbre1() {
        final Arbre<Integer> f1 = new Feuille<>(1);
        final Arbre<Integer> f2 = new Feuille<>(3);
        final Arbre<Integer> n1 = new Noeud(List.of(f1,f2));
        final Arbre<Integer> f3 = new Feuille<>(5);
        final Arbre<Integer> n2 = new Noeud(List.of(n1,f3));
        return n2;
    }
    public static final Arbre arbre2() {
        final Arbre<String> f1 = new Feuille<>("d");
        final Arbre<String> f2 = new Feuille<>("e");
        final Arbre<String> n1 = new Noeud(List.of(f1,f2));
        final Arbre<String> f3 = new Feuille<>("F");
        final Arbre<String> n2 = new Noeud(List.of(n1,f3));
        return n2;
    }
    @Test public void testSize() {
        assertEquals(0, arbre0().taille());
        assertEquals(3, arbre1().taille());
        assertEquals(3, arbre2().taille());
    }
    @Test public void testContient() {
        assertFalse(arbre0().contient(1));
        assertFalse(arbre0().contient(2));
        assertTrue(arbre1().contient(5));
        assertFalse(arbre1().contient(4));
        assertTrue(arbre2().contient("F"));
        assertFalse(arbre2().contient("C"));
    }
    @Test public void testValeurs() {
        final Set<Integer> contenu = Set.of(1,3,5);
        final Set<String> contenu2 = Set.of("d","e","F");
        assertEquals(Set.of(), arbre0().valeurs());
        assertEquals(contenu, arbre1().valeurs());
        assertEquals(contenu2, arbre2().valeurs());

    }
}
