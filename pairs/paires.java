


public interface paires <T,U> {
public T fst();
public U snd();
public <V> paires <V,U> changeFst(V v);
public <V> paires <T,V> changeSnd(V v);
}