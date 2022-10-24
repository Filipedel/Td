import java.awt.*;

public class Test {
    public static void main(String[] args){
        Somme<Integer> somme = (x,y)-> x + y;
        Somme<String> somme2 = (x, y) -> x.concat(y);
        Somme<Double> somme3 = (x,y) -> x + y;
        Somme<Long> somme4 = (x,y)-> x + y;
//TEST SOmme
        System.out.println(somme.somme(4,5)+ " "+ somme2.somme("a","b")+" "+somme3.somme(3.3,3.2));


    }

}
