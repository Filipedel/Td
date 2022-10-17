

public class pair<T,U> implements paires <T,U> {
    private T var;
    private U othervar;
    public pair (T var, U othervar){
        this.var = var;
        this.othervar = othervar;
    }
    @Override
    public T fst(){
        return var;
    }
    @Override
    public U snd(){
        return othervar;
    }
    @Override
    public <V> paires <V,U> changeFst(V variable){
        return new pair<V,U>(variable, othervar);
    }
    @Override
    public <V> paires <T,V> changeSnd(V variable){
        return new pair<T,V> (var, variable);
    }

    public String toString(){
        return String.format("(%s, %s) :: Paire[%s,%s]", this.fst(), this.snd(), this.fst().getClass().getSimpleName(), this.snd().getClass().getSimpleName());
    }
     public static void main(String[] args) {
        pair  <Integer, String> a = new pair <> (5,"DODO");
        pair <Double, String> b = new pair <> (1.0, "un");
        pair <Double, pair <Integer, String>> c = new pair<>(1.0, a);
        System.out.println(a.changeFst("quatre"));
        System.out.println(a.toString()); 
        System.out.println(b.toString());
        System.out.println(c.toString());
    }



}