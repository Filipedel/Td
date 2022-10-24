import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Somme<Integer> somme = (x,y)-> x + y;
        Somme<String> somme2 = (x, y) -> x.concat(y);
        Somme<Double> somme3 = (x,y) -> x + y;
        Somme<Long> somme4 = (x,y)-> x + y;
//TEST SOmme
        System.out.println(somme.somme(4,5)+ " "+ somme2.somme("a","b")+" "+somme3.somme(3.3,3.2));
//TEST STRING

        List<String> l2s = new ArrayList<>();
        l2s.add("e1");
        l2s.add("e2");
        ToString<List<String>> tt = x -> {
            StringBuilder build = new StringBuilder();
            x.forEach((val)->{
                build.append(val + ",");
            });
            return build.toString();
        };
        System.out.println(tt.display(l2s));

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("k1", 5);
        hm.put("k2", 10);
        ToString<HashMap<String, Integer>> toStringMap = x -> {
            StringBuilder build = new StringBuilder();
            x.forEach((key, val) -> {
                build.append(String.format("%s : %d, ", key, val));
            });
            return build.toString();
        };
        System.out.println(toStringMap.display(hm));

    }

}
