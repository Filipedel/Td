
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class filtre<T> {
     public List<T> filtragePredicatif(@NotNull List<Predicate<T>> conditions, List<T> elements){
        List<T> rtn = new ArrayList<>();

        Predicate<T> predicat = x -> true;

        for(Predicate<T> p : conditions){
            predicat = predicat.and(p);
        }
        for(T e : elements) {
            if (predicat.test(e)){
                rtn.add(e);
            }
        }
        return rtn;
    }

}
